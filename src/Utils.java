import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class holds a set of helper functions for the PRIDE system. 
 *
 * @author Hao Yang
 * @version 1.0
 */

public class Utils {

	/**
	 * Function to generate a random BigInteger with n bits
	 * @param n 	bit length, integer
	 * @return		
	 */
	public static BigInteger generateRandomBigInteger(int n)
	{
		String letters = "0123456789";
		Random random = new Random();
		String result = "";
		for (int i=0; i<n; i++)
		{
			int index = (int)(random.nextDouble()*letters.length());
			result += letters.substring(index, index+1);
		}
		return new BigInteger(result);
	}

	/**
	 * Alterntive function for BigInteger class to compute Power of BigIntger, base BigInteger
	 * @param base			BigInteger
	 * @param exponent		BigInteger
	 * @return		
	 */
	public static BigInteger BigIntegerPow(BigInteger base, BigInteger exponent) {
		BigInteger result = BigInteger.ONE;
		while (exponent.signum() > 0) {
			if (exponent.testBit(0)) result = result.multiply(base);
			base = base.multiply(base);
			exponent = exponent.shiftRight(1);
		}
		return result;
	}
	
	/**
	 * Function to compute the distance of two clients, with the returned value of x1x2+y1y2
	 * @param a				One of the client 
	 * @param b				Another client
	 * @param x1x2+y1y2		The result of x1x2+y1y2
	 * @return
	 */
	public static BigInteger computeDistance(Client a, Client b,BigInteger x1x2_y1y2){
		
		BigInteger result = sqrt(a.getXS_YS().add(b.getXS_YS()).subtract(x1x2_y1y2.multiply(new BigInteger("2"))));
		
		/*
		 * Print out the result to the answer
		 */
		//System.out.println("Distance between : user "+a.getId()+" and user "+b.getId()+" is " +result + "m");
		return result;
	}
	

	/**
	 * Function to compute x1x2+y1y2 of Clients.
	 * @param a			One of the client
	 * @param b			Another client
	 * @return
	 */
	public static BigInteger computeMatrix(Client a, Client b){

		//Random r for decryption
		BigInteger r1 = Utils.generateRandomBigInteger(7);

		//Client a: Encrypt and send to client b
		BigInteger xaMatrix[] = a.getXMatrix();
		BigInteger yaMatrix[] = a.getYMatrix();
		for(int i=0;i<a.getXMatrix().length;i++){
			xaMatrix[i] = a.getPublickKey().Encryption(xaMatrix[i],r1);
		}
		for(int i=0;i<a.getYMatrix().length;i++){
			yaMatrix[i] = a.getPublickKey().Encryption(yaMatrix[i],r1);
		}	

		//Client b
		BigInteger xbMatrix[] = b.getXMatrix();
		BigInteger ybMatrix[] = b.getYMatrix();

		//Result set of W
		BigInteger resultX[][] = new BigInteger[7][7];
		BigInteger resultY[][] = new BigInteger[7][7];

		//Client b compute w'(power operation) and send to client a
		for(int j=0;j<7;j++){
			for(int k=0;k<7;k++){
				resultX[j][k] = Utils.BigIntegerPow(xaMatrix[j],xbMatrix[k]);
				resultY[j][k] = Utils.BigIntegerPow(yaMatrix[j],ybMatrix[k]);
			}
		}

		//Client a computes the decryptd value and get the result
		BigInteger resultW = new BigInteger("0");

		//00*B1B2
		BigInteger temp = new BigInteger("0");
		temp = resultX[0][0].multiply(resultY[0][0]);
		temp = a.getPublickKey().Decryption(temp).multiply(new BigInteger(""+(long) Math.pow(10,12)));
		resultW = resultW.add(temp);

		//Numbers at the edge: 0*A2*B1B2'*A20*B2B2'.....
		int power = 11;
		for(int i=1;i<7;i++){
			temp = new BigInteger("0");
			temp = resultX[0][i].multiply(resultX[i][0]).multiply(resultY[0][i]).multiply(resultY[i][0]);
			temp = a.getPublickKey().Decryption(temp).multiply(new BigInteger(""+(long) Math.pow(10,power)));
			resultW = resultW.add(temp);
			power--;
		}

		//Numbers inside the matrix: B2B2'*A2A2'......
		power = 11;
		for(int i=1;i<7;i++){
			power = power - i;
			for(int j=1;j<7;j++){
				temp = new BigInteger("0");
				temp = resultX[i][j].multiply(resultY[i][j]);
				temp = a.getPublickKey().Decryption(temp).multiply(new BigInteger(""+(long) Math.pow(10,power)));
				resultW = resultW.add(temp);
				power--;
			}
			power = 11;
		}

		//Compute distance between two client
		return Utils.computeDistance(a,b,resultW);

		//Helper function to check the real distance between two clients using the formula
		//distance d = sqrt( (x1-x2)^2 + (y1-y2)^2 )
		//System.out.println("The result should be : "+ Utils.checkResult(a,b));

	}

	/**
	 * Function to find the sqrt root of one BigInteger
	 * @param n			BigInteger
	 * @return
	 */
	public static BigInteger sqrt(BigInteger n) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		while(b.compareTo(a) >= 0) {
			BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
			if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
			else a = mid.add(BigInteger.ONE);
		}
		return a.subtract(BigInteger.ONE);
	}

	/**
	 * Helper function to check the real distance between two clients
	 * using formula distance d = sqrt( (x1-x2)^2 + (y1-y2)^2 )
	 * @param clientA
	 * @param clientB
	 * @return
	 */
	public static double checkResult(Client clientA, Client clientB) {
		double x1_x2 = Math.pow((clientA.getNorthing()-clientB.getNorthing()),2);
		double y1_y2 = Math.pow((clientA.getEasting()-clientB.getEasting()),2);
		
		return Math.sqrt(x1_x2+y1_y2);
	}
	
	/**
	 * Function to conver a BigInteger variable to type double
	 * @param bigInteger		
	 * @return
	 */
	public static double convertToDouble(BigInteger bigInteger){
		String temp = bigInteger.toString();
		double result = Double.parseDouble(temp);
		return result;
	}
	
	/**
	 * Function to predict the distance between the current points and next point with different range of points
	 * @param rangeList			A list that stored results of some distance data
	 * @return
	 */
	public static double predictDistance(ArrayList<Double> rangeList){
		double range[] = new double[rangeList.size()-1];
		int index = 0;
		for(int i=rangeList.size()-1;i>1;i--){
			range[index] = rangeList.get(i)-rangeList.get(i-1);
			index++;
		}
		
		double total = 0;
		for(int i=0;i<rangeList.size()-1;i++){
			total = total + range[i];
		}

		return total;
	}
	
	/**
	 * Compute the standard diviation using ranges of point
	 * @param rangeList			A list that stored results of some distance data
	 * @return
	 */
	public static double computeSTD(ArrayList<Double> rangeList){
		double averageSpeed=0;
		double result = 0;
		ArrayList<Double> temp = new ArrayList<Double>();
		for(int i=0;i<rangeList.size();i++){
			averageSpeed = averageSpeed + rangeList.get(i);
		}
		averageSpeed = averageSpeed/rangeList.size();
		
		//Calculate the deviations
		for(int i=0;i<rangeList.size();i++){
			temp.add((averageSpeed-rangeList.get(i))*(averageSpeed-rangeList.get(i)));
		}
		for(int i=0;i<rangeList.size();i++){
			result = result + temp.get(i);
		}
		result = Math.sqrt(result/rangeList.size());
		
		return result;
	}
	
}
