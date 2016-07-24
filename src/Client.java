import java.math.BigInteger;
/**
 * Class to store a client's information
 * @author Hao Yang
 * @version 1.0
 */
public class Client {

	//GPS information
	private BigInteger latitude;
	private BigInteger longtitude;
	//Client id
	private int Id;
	//Client name
	private String name;
	//Client key for encryption and decryption
	private Paillier privateKey;
	private Paillier publickKey;
	//UTM information
	private double northing;
	private double easting;
	private String letterZone;

	/**
	 * Constructors
	 */

	/**
	 * Generate a client with random a position
	 * @param id		integer
	 * @param name		String
	 */
	public Client(int id, String name){
		this.privateKey = new Paillier(64,16);
		this.publickKey = new Paillier(64,16);
		this.name = name;
		this.Id = id;
		latitude = Utils.generateRandomBigInteger(6);
		longtitude = Utils.generateRandomBigInteger(7);
	}

	/**
	 * Generate a client with a fixed position(GPS), id and a name
	 * @param id			integer
	 * @param name			String
	 * @param latitude		BigInteger
	 * @param longtitude	BigInteger
	 */
	public Client(int Id, String name,BigInteger latitude, BigInteger longtitude) {
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.name = name;
		this.Id = Id;
		this.privateKey = new Paillier(64,16);
		this.publickKey = new Paillier(64,16);
		Deg2UTM converter = new Deg2UTM(Utils.convertToDouble(latitude),Utils.convertToDouble(longtitude));	
		this.easting = converter.getEasting();
		this.northing = converter.getNorthing();
		this.letterZone = converter.getLetter()+" "+converter.getZone();
	}

	/**
	 * Generate a client with a fixed position(GPS), id and a name
	 * @param Id			integer
	 * @param name			String
	 * @param latitude		double
	 * @param longtitude	double
	 */
	public Client(int Id, String name,double latitude, double longitude) {
		this.name = name;
		this.Id = Id;
		this.privateKey = new Paillier(64,16);
		this.publickKey = new Paillier(64,16);
		Deg2UTM converter = new Deg2UTM(latitude,longitude);	
		this.easting = Math.round(converter.getEasting());
		this.northing = Math.round(converter.getNorthing());
		this.letterZone = converter.getLetter()+" "+converter.getZone();
		this.latitude = new BigInteger(""+ (int) this.easting);
		this.longtitude = new BigInteger(""+ (int) this.northing);

	}

	/**
	 * Generate a client with a fixed position
	 * @param Id			integer
	 * @param latitude		double
	 * @param longtitude	double
	 */
	public Client(int Id, double latitude, double longitude) {
		this.Id = Id;
		this.privateKey = new Paillier(64,16);
		this.publickKey = new Paillier(64,16);
		Deg2UTM converter = new Deg2UTM(latitude,longitude);	
		this.easting = Math.round(converter.getEasting());
		this.northing = Math.round(converter.getNorthing());
		this.letterZone = converter.getLetter()+" "+converter.getZone();
		this.latitude = new BigInteger(""+ (int) this.easting);
		this.longtitude = new BigInteger(""+ (int) this.northing);
	}



	/**
	 * Setters and getters
	 */

	//Get value of latitude*y
	public BigInteger getXY(){
		return latitude.multiply(longtitude);
	}

	//Get value of latitude^2+y^2
	public BigInteger getXS_YS(){
		return latitude.multiply(latitude).add(longtitude.multiply(longtitude));
	}
	
	/**
	 * Function to get a matrix of latitude
	 * @return
	 */
	public BigInteger[] getXMatrix(){
		BigInteger matrix[] = new BigInteger [7];
		int temp = (int) this.easting;
		int index=0;
		for(int i=1000000;i>=1;i=i/10){
			if(index==0){
				matrix[index] = new BigInteger("" + 0);
				index++;
			}
			else{
				matrix[index] = new BigInteger("" + temp/i);
				index++;
				temp = temp%i;
			}
		}
		return matrix;
	}

	/**
	 * Function to get a matrix of longtitude
	 * @return
	 */
	public BigInteger[] getYMatrix(){
		BigInteger matrix[] = new BigInteger [7];
		int temp = (int) this.northing;
		int indelatitude=0;
		for(int i=1000000;i>=1;i=i/10){
			matrix[indelatitude] = new BigInteger("" + temp/i);
			indelatitude++;
			temp = temp%i;
		}
		return matrix;
	}
	
	public BigInteger getLatitude() {
		return latitude;
	}

	public void setLatitude(BigInteger latitude) {
		this.latitude = latitude;
	}

	public BigInteger getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(BigInteger longtitude) {
		this.longtitude = longtitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Paillier getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(Paillier privateKey) {
		this.privateKey = privateKey;
	}

	public Paillier getPublickKey() {
		return publickKey;
	}

	public void setPublickKey(Paillier publickKey) {
		this.publickKey = publickKey;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}


	public double getNorthing() {
		return northing;
	}

	public void setNorthing(double northing) {
		this.northing = northing;
	}

	public double getEasting() {
		return easting;
	}

	public void setEasting(double easting) {
		this.easting = easting;
	}

	public String getLetterZone() {
		return letterZone;
	}

	public void setLetterZone(String letterZone) {
		this.letterZone = letterZone;
	}
	
}
