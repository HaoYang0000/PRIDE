import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class to implement expirements
 * @author Hao Yang
 * @version 1.0
 */

public class Testing {

	static int counter = 0;
	static Result[] result ;
	public static double encryptionTime[];
	public static double decryptionTime[];
	public static double powerTime[];

	/**
	 * Experiment 1: time consuming of encrypt 3 digits numbers, power operation between the encrypted value with another UTM data, 
	 * and decryption to find x1x2+y1y2
	 * Note: This experiment takes a lot of time on a normal laptop, about 4-5 hours or even more
	 * @param runTime		Integer,how many time you prefer to run the experiment and find the average(suggest 10 or more)
	 * @throws FileNotFoundException
	 */
	public static void experiment1(int runTime) throws FileNotFoundException {
		//Key for encryption and decryption
		Paillier key = new Paillier(64,16);
		//BigInteger of different digits, from 3 digits to 10 digits
		BigInteger x3 = Utils.generateRandomBigInteger(3);
		BigInteger y3 = Utils.generateRandomBigInteger(3);
		BigInteger x4 = Utils.generateRandomBigInteger(4);
		BigInteger y4 = Utils.generateRandomBigInteger(4);
		BigInteger x5 = Utils.generateRandomBigInteger(5);
		BigInteger y5 = Utils.generateRandomBigInteger(5);
		BigInteger x6 = Utils.generateRandomBigInteger(6);
		BigInteger y6 = Utils.generateRandomBigInteger(6);
		BigInteger x7 = Utils.generateRandomBigInteger(7);
		BigInteger y7 = Utils.generateRandomBigInteger(7);
		//BigInteger to store the encrypted value
		BigInteger encrypt_X3 = new BigInteger("1");
		BigInteger encrypt_Y3 = new BigInteger("1");
		BigInteger encrypt_X4 = new BigInteger("1");
		BigInteger encrypt_Y4 = new BigInteger("1");
		BigInteger encrypt_X5 = new BigInteger("1");
		BigInteger encrypt_Y5 = new BigInteger("1");
		BigInteger encrypt_X6 = new BigInteger("1");
		BigInteger encrypt_Y6 = new BigInteger("1");
		BigInteger encrypt_X7 = new BigInteger("1");
		BigInteger encrypt_Y7 = new BigInteger("1");
		//BigInteger to store the value of the encrypted value times a UTM data
		BigInteger power_X3 = new BigInteger("1");
		BigInteger power_Y3 = new BigInteger("1");
		BigInteger power_X4 = new BigInteger("1");
		BigInteger power_Y4 = new BigInteger("1");
		BigInteger power_X5 = new BigInteger("1");
		BigInteger power_Y5 = new BigInteger("1");
		BigInteger power_X6 = new BigInteger("1");
		BigInteger power_Y6 = new BigInteger("1");
		BigInteger power_X7 = new BigInteger("1");
		BigInteger power_Y7 = new BigInteger("1");

		/*
		 * result[0-4] = Encryption 3 digts - 7 digits
		 * result[5-9] = Power operation 3 digts - 7 digits
		 * result[10-14] = Decryption 3 digts - 7 digits
		 */
		double result[] = new double[15];

		//Print the result to the target file
		File resultFile  = new File("result/experiment1/result.txt");
		try {
			new File("result/experiment1").mkdirs();
			resultFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = new PrintWriter(resultFile);

		for(int i=0;i<runTime;i++){
			/**
			 * Step 1: Encryption 
			 */
			long totalTimeStart = System.nanoTime();
			encrypt_X3 = key.Encryption(x3);
			encrypt_Y3 = key.Encryption(y3);
			long totalTimeEnd = System.nanoTime();
			out.write("computation time of encrypt 3 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[0] =  (result[0] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			encrypt_X4 = key.Encryption(x4);
			encrypt_Y4 = key.Encryption(y4);
			totalTimeEnd = System.nanoTime();
			out.write("computation time of encrypt 4 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[1] =  (result[1] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			encrypt_X5 = key.Encryption(x5);
			encrypt_Y5 = key.Encryption(y5);
			totalTimeEnd = System.nanoTime();
			out.write("computation time of encrypt 5 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[2] =  (result[2] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			encrypt_X6 = key.Encryption(x6);
			encrypt_Y6 = key.Encryption(y6);
			totalTimeEnd = System.nanoTime();
			out.write("computation time of encrypt 6 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[3] =  (result[3] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			encrypt_X7 = key.Encryption(x7);
			encrypt_Y7 = key.Encryption(y7);
			totalTimeEnd = System.nanoTime();
			out.write("computation time of encrypt 7 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[4] =  (result[4] + (totalTimeEnd-totalTimeStart)/1000000.0);

			/**
			 * Step 2: Power operation 
			 */
			totalTimeStart = System.nanoTime();
			power_X3 = Utils.BigIntegerPow(encrypt_X3, Utils.generateRandomBigInteger(3));
			power_Y3 = Utils.BigIntegerPow(encrypt_Y3, Utils.generateRandomBigInteger(3));
			totalTimeEnd = System.nanoTime();
			out.write("Power operation of 3 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[5] =  (result[5] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			power_X4 = Utils.BigIntegerPow(encrypt_X4, Utils.generateRandomBigInteger(4));
			power_Y4 = Utils.BigIntegerPow(encrypt_Y4, Utils.generateRandomBigInteger(4));
			totalTimeEnd = System.nanoTime();
			out.write("Power operation of 4 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[6] =  (result[6] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			power_X5 = Utils.BigIntegerPow(encrypt_X5, Utils.generateRandomBigInteger(5));
			power_Y5 = Utils.BigIntegerPow(encrypt_Y5, Utils.generateRandomBigInteger(5));
			totalTimeEnd = System.nanoTime();
			out.write("Power operation of 5 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[7] =  (result[7] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			power_X6 = Utils.BigIntegerPow(encrypt_X6, Utils.generateRandomBigInteger(6));
			power_Y6 = Utils.BigIntegerPow(encrypt_Y6, Utils.generateRandomBigInteger(6));
			totalTimeEnd = System.nanoTime();
			out.write("Power operation of 6 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[8] =  (result[8] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			power_X7 = Utils.BigIntegerPow(encrypt_X7, Utils.generateRandomBigInteger(7));
			power_Y7 = Utils.BigIntegerPow(encrypt_Y7, Utils.generateRandomBigInteger(7));
			totalTimeEnd = System.nanoTime();
			out.write("Power operation of 7 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[9] =  (result[9] + (totalTimeEnd-totalTimeStart)/1000000.0);

			/**
			 * Step 3: Decryption to find x1x2+y1y2
			 */
			totalTimeStart = System.nanoTime();
			key.Decryption(power_X3.multiply(power_Y3));
			totalTimeEnd = System.nanoTime();
			out.write("Decryption time of 3 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[10] =  (result[10] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			key.Decryption(power_X4.multiply(power_Y4));
			totalTimeEnd = System.nanoTime();
			out.write("Decryption time of 4 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[11] =  (result[11] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			key.Decryption(power_X5.multiply(power_Y5));
			totalTimeEnd = System.nanoTime();
			out.write("Decryption time of 5 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[12] =  (result[12] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			key.Decryption(power_X6.multiply(power_Y6));
			totalTimeEnd = System.nanoTime();
			out.write("Decryption time of 6 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[13] =  (result[13] + (totalTimeEnd-totalTimeStart)/1000000.0);

			totalTimeStart = System.nanoTime();
			key.Decryption(power_X7.multiply(power_Y7));
			totalTimeEnd = System.nanoTime();
			out.write("Decryption time of 7 digit is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			result[14] = (result[14] + (totalTimeEnd-totalTimeStart)/1000000.0);
		}

		/**
		 * Find the average time of each part
		 */
		for(int i=0;i<15;i++){
			result[i] = result[i]/runTime;
		}
		out.write("Average computation time of encrypt 3 digit is " + result[0]+"ms\n");
		out.write("Average computation time of encrypt 4 digit is " + result[1]+"ms\n");
		out.write("Average computation time of encrypt 5 digit is " + result[2]+"ms\n");
		out.write("Average computation time of encrypt 6 digit is " + result[3]+"ms\n");
		out.write("Average computation time of encrypt 7 digit is " + result[4]+"ms\n");
		out.write("Average power operation of 3 digit is "+ result[5]+"ms\n");
		out.write("Average power operation of 4 digit is "+ result[6]+"ms\n");
		out.write("Average power operation of 5 digit is "+ result[7]+"ms\n");
		out.write("Average power operation of 6 digit is "+ result[8]+"ms\n");
		out.write("Average power operation of 7 digit is "+ result[9]+"ms\n");
		out.write("Average decryption time of 3 digit is "+ result[10]+"ms\n");
		out.write("Average decryption time of 4 digit is "+ result[11]+"ms\n");
		out.write("Average decryption time of 5 digit is "+ result[12]+"ms\n");
		out.write("Average decryption time of 6 digit is "+ result[13]+"ms\n");
		out.write("Average decryption time of 7 digit is "+ result[14]+"ms\n");


		/**
		 * Testing for using matrix algroithm
		 */
		double time = 0;
		//Generate two random clients
		Client a = new Client(1,"a");
		Client b = new Client(2,"b");
		encryptionTime = new double [runTime];
		decryptionTime = new double [runTime];
		powerTime = new double [runTime];

		for(int i=0;i<runTime;i++){
			long totalTimeStart = System.nanoTime();
			newAlgorithm(a,b,i);
			long totalTimeEnd = System.nanoTime();
			out.write("Running time is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms\n");
			time = time + (totalTimeEnd-totalTimeStart)/1000000.0;
		}

		double tempencryptionTime = 0;
		double tempdecryptionTime = 0;
		double temppowerTime = 0;
		for(int i=0;i<runTime;i++){
			tempencryptionTime = tempencryptionTime + encryptionTime[i];
			tempdecryptionTime = tempdecryptionTime + decryptionTime[i];
			temppowerTime = temppowerTime + powerTime[i];
		}
		tempencryptionTime = tempencryptionTime/runTime;
		tempdecryptionTime = tempdecryptionTime/runTime;
		temppowerTime = temppowerTime/runTime;

		out.write("Average encryption time of new algorithm:"+ tempencryptionTime+"ms\n");
		out.write("Average decruption time of new algorithm:"+ tempdecryptionTime+"ms\n");
		out.write("Average power time of new algorithm:"+ temppowerTime+"ms\n");
		out.close();
	}

	/**
	 * (Helper for experiment 1)Compute all the distances between Clients (matrix algorithm).
	 * @param a				One client
	 * @param b				Another client
	 * @param index			index number to help computing the average
	 */
	public static void newAlgorithm(Client a, Client b,int index){
		//Time stamp of computation 
		long start, end;
		start = System.nanoTime();

		//Random r for decryption
		BigInteger r1 = Utils.generateRandomBigInteger(7);

		//Client a: Encrypt and send to Client b
		BigInteger xMatrix[] = a.getXMatrix();
		BigInteger yMatrix[] = a.getYMatrix();
		for(int i=0;i<a.getXMatrix().length;i++){
			xMatrix[i] = a.getPublickKey().Encryption(xMatrix[i],r1);
		}
		for(int i=0;i<a.getYMatrix().length;i++){
			yMatrix[i] = a.getPublickKey().Encryption(yMatrix[i],r1);
		}	

		end = System.nanoTime();
		double ms = (end-start) / 1000000.0;
		encryptionTime[index] = ms;

		start = System.nanoTime();
		//Client b
		BigInteger x1Matrix[] = b.getXMatrix();
		BigInteger y1Matrix[] = b.getYMatrix();

		//Result set of W
		BigInteger resultX[][] = new BigInteger[7][7];
		BigInteger resultY[][] = new BigInteger[7][7];

		//Client b compute w'(power operation) and send to client a
		for(int j=0;j<7;j++){
			for(int k=0;k<7;k++){
				resultX[j][k] = Utils.BigIntegerPow(xMatrix[j],x1Matrix[k]);
				resultY[j][k] = Utils.BigIntegerPow(yMatrix[j],y1Matrix[k]);
			}
		}
		end = System.nanoTime();
		ms = (end-start) / 1000000.0;
		powerTime[index] = ms;

		//Client a computes the decryptd value and get the result
		BigInteger resultW = new BigInteger("0");

		start = System.nanoTime();
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
		Utils.computeDistance(a,b,resultW);

		end = System.nanoTime();
		ms = (end-start) / 1000000.0;
		decryptionTime[index] = ms;

		//Method to check the real result
		//System.out.println("The result should be : "+ Utils.checkResult(a,b));

	}


	/**
	 * Experiment 2: time consuming of computing the distance between a fixed base and some users at a specific time.
	 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
	 * @throws FileNotFoundException
	 */
	public static void experiment2(int testcase1) throws FileNotFoundException{
		//Print the result to the target file
		File resultFile  = new File("result/experiment2/result.txt");
		try {
			new File("result/experiment2").mkdirs();
			resultFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = new PrintWriter(resultFile);

		//Reading files and generate Clients
		Scanner s = null;
		ArrayList<String> fileName = new ArrayList<String>();
		String file = "";
		String test = "";
		switch(testcase1){
		case 1:
			file = "data/fileName1.txt";
			test = "data/testcase/Data/000/Trajectory/";
			break;
		case 2:
			file = "data/fileName2.txt";
			test = "data/testcase/Data/001/Trajectory/";
			break;
		case 3:
			file = "data/fileName3.txt";
			test = "data/testcase/Data/002/Trajectory/";
			break;
		case 4:
			file = "data/fileName4.txt";
			test = "data/testcase/Data/003/Trajectory/";
			break;
		case 5:
			file = "data/fileName5.txt";
			test = "data/testcase/Data/004/Trajectory/";
			break;
		case 6:
			file = "data/fileName6.txt";
			test = "data/testcase/Data/005/Trajectory/";
			break;
		default:
			file = "data/fileName1.txt";
			test = "data/testcase/Data/000/Trajectory/";
			break;
		}
		try {
			s = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNext()){
			fileName.add(s.next());
		}

		result = new Result[fileName.size()];
		//List to store all the client
		ArrayList<Client> list = new ArrayList<Client>();
		//fixed base
		Client base = new Client(9999,"base");
		for(int i=0;i<fileName.size();i++){
			list = Parser.readFile(test+fileName.get(i));

			long totalTimeStart = System.nanoTime();
			counter=0;
			for(int j=0; j<list.size();j++){

				Client b = list.get(j);
				b.setId(j);
				long startTime = System.nanoTime();
				Utils.computeMatrix(base,b);
				counter++;
				long endTime = System.nanoTime();

				//System.out.println("Computation time is = "+((endTime-startTime)/1000000.0)+"ms");
				//System.out.println();

			}

			long totalTimeEnd = System.nanoTime();
			System.out.println("---------------------------------");
			System.out.println("All tests in "+fileName.get(i)+" are finished, Total computation time is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms");
			System.out.println("The number of user is "+list.size());
			System.out.println("Average computation time is = "+((totalTimeEnd-totalTimeStart)/1000000.0/counter)+"ms");

			Result temp = new Result(totalTimeEnd,totalTimeStart,counter);
			result[i] = temp;

		}

		/**
		 * Sorting the result based on the user number
		 */
		for(int i=0;i<result.length;i++){
			for(int j=i+1;j<result.length;j++){
				if(result[i].getUserNumber() >= result[j].getUserNumber()){
					Result temp = result[j];
					result[j] = result[i];
					result[i] = temp;
				}
			}
		}

		/**
		 * Print out results
		 */
		out.write("---------Experiment 2---------\n");
		for(int i=0;i<result.length;i++){
			out.write("User number :"+result[i].getUserNumber() +"\t");
			out.write("Running time: "+result[i].getRunningTime() +"\n");
		}

		out.close();
	}

	/**
	 * Experiment 3: time consuming of computing the distance set between multiple users at one specific time.
	 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
	 * @param testcase2		Integer, the GPS data file for testing, could chose 1-6
	 * @throws FileNotFoundException
	 */
	public static void experiment3(int testcase1,int testcase2) throws FileNotFoundException{
		//Print the result to the target file
		File resultFile  = new File("result/experiment3/result.txt");
		try {
			new File("result/experiment3").mkdirs();
			resultFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = new PrintWriter(resultFile);

		//Reading files and generate Clients
		Scanner s1 = null;
		Scanner s2 = null;
		ArrayList<String> fileName1 = new ArrayList<String>();
		ArrayList<String> fileName2 = new ArrayList<String>();
		String file1 = "";
		String test1 = "";
		String file2 = "";
		String test2 = "";
		switch(testcase1){
		case 1:
			file1 = "data/fileName1.txt";
			test1 = "data/testcase/Data/000/Trajectory/";
			break;
		case 2:
			file1 = "data/file1Name2.txt";
			test1 = "data/test1case/Data/001/Trajectory/";
			break;
		case 3:
			file1 = "data/file1Name3.txt";
			test1 = "data/test1case/Data/002/Trajectory/";
			break;
		case 4:
			file1 = "data/file1Name4.txt";
			test1 = "data/test1case/Data/003/Trajectory/";
			break;
		case 5:
			file1 = "data/file1Name5.txt";
			test1 = "data/test1case/Data/004/Trajectory/";
			break;
		case 6:
			file1 = "data/file1Name6.txt";
			test1 = "data/test1case/Data/005/Trajectory/";
			break;
		default:
			file1 = "data/file1Name1.txt";
			test1 = "data/test1case/Data/000/Trajectory/";
			break;
		}
		switch(testcase1){
		case 1:
			file2 = "data/fileName1.txt";
			test2 = "data/testcase/Data/000/Trajectory/";
			break;
		case 2:
			file2 = "data/fileName2.txt";
			test2 = "data/testcase/Data/001/Trajectory/";
			break;
		case 3:
			file2 = "data/fileName3.txt";
			test2 = "data/testcase/Data/002/Trajectory/";
			break;
		case 4:
			file2 = "data/fileName4.txt";
			test2 = "data/testcase/Data/003/Trajectory/";
			break;
		case 5:
			file2 = "data/fileName5.txt";
			test2 = "data/testcase/Data/004/Trajectory/";
			break;
		case 6:
			file2 = "data/fileName6.txt";
			test2 = "data/testcase/Data/005/Trajectory/";
			break;
		default:
			file2 = "data/fileName1.txt";
			test2 = "data/testcase/Data/000/Trajectory/";
			break;
		}
		try {
			s1 = new Scanner(new File(file1));
			s2 = new Scanner(new File(file2));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s1.hasNext()){
			fileName1.add(s1.next());
		}
		while(s2.hasNext()){
			fileName2.add(s2.next());
		}

		//List to store all the client
		ArrayList<Client> list = new ArrayList<Client>();
		ArrayList<Client> list2 = new ArrayList<Client>();

		int boundry;
		if(fileName1.size()>fileName2.size()){
			boundry = fileName2.size();
		}
		else{
			boundry = fileName1.size();
		}

		result = new Result[boundry];

		for(int i=0;i<boundry;i++){
			list = Parser.readFile(test1+fileName1.get(i));
			list2 = Parser.readFile(test2+fileName2.get(i));
			long totalTimeStart = System.nanoTime();
			counter=0;

			ArrayList<Client> tempList = new ArrayList<Client>();
			if(list.size()>=list2.size()){
				tempList = list;
				list = list2;
				list2 = tempList;
			}

			for(int j=0; j<list.size();j++){
				Client a = list.get(j);
				for(int k=0;k<list2.size();k++){
					Client b = list2.get(k);
					//time for one computation
					long startTime = System.nanoTime();
					Utils.computeMatrix(a,b);
					counter++;
					long endTime = System.nanoTime();
				}

				//System.out.println("Computation time is = "+((endTime-startTime)/1000000.0)+"ms");
				//System.out.println();
			}
			long totalTimeEnd = System.nanoTime();
			System.out.println("---------------------------------");
			System.out.println("All tests in "+fileName1.get(i)+" and "+fileName2.get(i)+" are finished, Total computation time is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms");
			System.out.println("The number of pair is "+counter);
			System.out.println("Average computation time is = "+((totalTimeEnd-totalTimeStart)/1000000.0/counter)+"ms");

			Result temp = new Result(totalTimeEnd,totalTimeStart,counter);
			result[i] = temp;

		}

		/**
		 * Sorting the result
		 */
		for(int i=0;i<result.length;i++){
			for(int j=i+1;j<result.length;j++){
				if(result[i].getUserNumber() >= result[j].getUserNumber()){
					Result temp = result[j];
					result[j] = result[i];
					result[i] = temp;
				}
			}
		}

		/**
		 * Print out results
		 */
		out.write("----------Experiment 3--------\n");
		for(int i=0;i<result.length;i++){
			out.write("User number :"+result[i].getUserNumber()+"\t" );
			out.write("Running time: "+result[i].getRunningTime() +"\n");
		}
		out.close();
	}

	/**
	 * Experiment 4: time consuming of computing the distance between a fixed base and some users at a specific time,
	 * using the distance prediction method.
	 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
	 * @throws FileNotFoundException
	 */
	public static void experiment4(int testcase1) throws FileNotFoundException{
		//Reading files and generate Clients
		Scanner s = null;
		ArrayList<String> fileName = new ArrayList<String>();
		String file = "";
		String test = "";
		switch(testcase1){
		case 1:
			file = "data/fileName1.txt";
			test = "data/testcase/Data/000/Trajectory/";
			break;
		case 2:
			file = "data/fileName2.txt";
			test = "data/testcase/Data/001/Trajectory/";
			break;
		case 3:
			file = "data/fileName3.txt";
			test = "data/testcase/Data/002/Trajectory/";
			break;
		case 4:
			file = "data/fileName4.txt";
			test = "data/testcase/Data/003/Trajectory/";
			break;
		case 5:
			file = "data/fileName5.txt";
			test = "data/testcase/Data/004/Trajectory/";
			break;
		case 6:
			file = "data/fileName6.txt";
			test = "data/testcase/Data/005/Trajectory/";
			break;
		default:
			file = "data/fileName1.txt";
			test = "data/testcase/Data/000/Trajectory/";
			break;
		}
		try {
			s = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNext()){
			fileName.add(s.next());
		}

		result = new Result[fileName.size()];
		//List to store all the client
		ArrayList<Client> list = new ArrayList<Client>();

		int[] range =  {5,8,10,15,18,20};
		int[] std = {10,12,15,18,20};
		int[] error = {5,8,10,15,18,20};
		for(int sizeR = 0;sizeR<range.length;sizeR++){
			for(int sizeS = 0;sizeS<std.length;sizeS++){
				for(int sizeE = 0;sizeE < error.length;sizeE++){

					File file1  = new File("result/experiment4/Std"+std[sizeS]+"Range"+range[sizeR]+"Error"+error[sizeE]+".txt");
					try {
						new File("result/experiment4").mkdirs();
						file1.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					PrintWriter out = new PrintWriter(file1);

					String string = "std is :" + std[sizeS] + " range is :" + range[sizeR] +" error is : " + error[sizeE] +"\n";
					out.write(string);

					//fixed base
					Client base = new Client(9999,"base");
					for(int i=0;i<fileName.size();i++){
						list = Parser.readFile(test+fileName.get(i));

						long totalTimeStart = System.nanoTime();
						counter=0;

						BigInteger holder = new BigInteger("0");
						BigInteger lastPosition = new BigInteger("0");
						ArrayList<Double> rangeList = new ArrayList<Double>();
						boolean predictMode = false;

						//Variables to help save the results
						double tempTime = 0;
						int occurTime = 0;
						double averageError = 0;

						for(int j=0; j<list.size();j++){
							Client b = list.get(j);
							//time for one computation
							long startTime = System.nanoTime();
							holder = Utils.computeMatrix(base,b);
							counter++;
							long endTime = System.nanoTime();

							//Check if the predict mode is on
							//If false, add the current distance to the list
							if(predictMode == false)
								rangeList.add(Utils.convertToDouble(holder));
							//If true, predict the distance
							else if(predictMode == true){
								//Store the saved time, occur time and error
								System.out.println("The predict position is "+(Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList))+ ", the real distance is "+holder);
								//If the prediction is not good enough, close the predict mode
								if(Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder))>=error[sizeE]){
									System.out.println("Predict mode is off now. The error is "+ Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder))+"m.");
									predictMode = false;
									rangeList = new ArrayList<Double>();
									rangeList.add(Utils.convertToDouble(holder));
								}
								//If the prediction is good enough, move on
								else{
									tempTime = tempTime + (range[sizeR]-1)*(endTime - startTime)/1000000.0;
									occurTime++;
									averageError = averageError + Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder));
									j = j+(range[sizeR]-1);
								}
								//Update the latest position anyway
								lastPosition = holder;
							}

							if(rangeList.size()==range[sizeR] && predictMode == false){
								if(Utils.computeSTD(rangeList)<std[sizeS]){
									System.out.println("Predict mode is on now. The STD is "+ Utils.computeSTD(rangeList));
									predictMode = true;
									lastPosition = holder;
									j = j+(range[sizeR]-1);
								}
								//Remove the first element
								else{
									rangeList.remove(0);
								}

							}


						}

						long totalTimeEnd = System.nanoTime();
						System.out.println("---------------------------------");
						System.out.println("All tests in "+fileName.get(i)+" are finished, Total computation time is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms");
						System.out.println("The number of user is "+list.size());
						System.out.println("Average computation time is = "+((totalTimeEnd-totalTimeStart)/1000000.0/counter)+"ms");

						Result temp = new Result(totalTimeEnd,totalTimeStart,counter);
						temp.setSavedTime(tempTime);
						temp.setOccurTime(occurTime);
						temp.setAverageError(averageError/occurTime);
						temp.setTotalNumber(counter);
						result[i] = temp;

					}

					/**
					 * Print out results
					 */
					System.out.println("------------------");
					out.write("------------Round----------------\n");
					//round
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+(i+1));
							out.write("\n");
						}
					}
					out.write("------------Occur time----------------\n");
					//occur time
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+result[i].getOccurTime());
							out.write("\n");
						}
					}
					out.write("-------------Computation time---------------\n");
					//average error
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+result[i].getTotalNumber());
							out.write("\n");
						}
					}
					out.write("----------Saved time------------------\n");
					//saved time 
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+result[i].getSavedTime());
							out.write("\n");
						}
					}

					out.write("-------------Average error---------------\n");
					//average error
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+result[i].getAverageError());
							out.write("\n");
						}
					}

					out.write("\n");
					out.close();
				}
			}
		}
	}



	/**
	 * Experiment 5: time consuming of computing the distance set between multiple users at a specific time,
	 * using the distance prediction method.
	 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
	 * @param testcase2		Integer, the GPS data file for testing, could chose 1-6
	 * @throws FileNotFoundException
	 */
	public static void experiment5(int testcase1, int testcase2) throws FileNotFoundException{
		//Reading files and generate Clients
		Scanner s1 = null;
		Scanner s2 = null;
		ArrayList<String> fileName1 = new ArrayList<String>();
		ArrayList<String> fileName2 = new ArrayList<String>();
		String file1 = "";
		String test1 = "";
		String file2 = "";
		String test2 = "";
		switch(testcase1){
		case 1:
			file1 = "data/fileName1.txt";
			test1 = "data/testcase/Data/000/Trajectory/";
			break;
		case 2:
			file1 = "data/fileName2.txt";
			test1 = "data/testcase/Data/001/Trajectory/";
			break;
		case 3:
			file1 = "data/fileName3.txt";
			test1 = "data/testcase/Data/002/Trajectory/";
			break;
		case 4:
			file1 = "data/fileName4.txt";
			test1 = "data/testcase/Data/003/Trajectory/";
			break;
		case 5:
			file1 = "data/fileName5.txt";
			test1 = "data/testcase/Data/004/Trajectory/";
			break;
		case 6:
			file1 = "data/fileName6.txt";
			test1 = "data/testcase/Data/005/Trajectory/";
			break;
		default:
			file1 = "data/fileName1.txt";
			test1 = "data/testcase/Data/000/Trajectory/";
			break;
		}
		switch(testcase2){
		case 1:
			file2 = "data/fileName1.txt";
			test2 = "data/testcase/Data/000/Trajectory/";
			break;
		case 2:
			file2 = "data/fileName2.txt";
			test2 = "data/testcase/Data/001/Trajectory/";
			break;
		case 3:
			file2 = "data/fileName3.txt";
			test2 = "data/testcase/Data/002/Trajectory/";
			break;
		case 4:
			file2 = "data/fileName4.txt";
			test2 = "data/testcase/Data/003/Trajectory/";
			break;
		case 5:
			file2 = "data/fileName5.txt";
			test2 = "data/testcase/Data/004/Trajectory/";
			break;
		case 6:
			file2 = "data/fileName6.txt";
			test2 = "data/testcase/Data/005/Trajectory/";
			break;
		default:
			file2 = "data/fileName1.txt";
			test2 = "data/testcase/Data/000/Trajectory/";
			break;
		}
		try {
			s1 = new Scanner(new File(file1));
			s2 = new Scanner(new File(file2));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s1.hasNext()){
			fileName1.add(s1.next());
		}

		while(s2.hasNext()){
			fileName2.add(s2.next());
		}

		int boundry;
		if(fileName1.size()>fileName2.size()){
			boundry = fileName2.size();
		}
		else{
			boundry = fileName1.size();
		}

		result = new Result[boundry];
		//List to store all the client
		ArrayList<Client> list = new ArrayList<Client>();
		ArrayList<Client> base = new ArrayList<Client>();

		int[] range =  {5,8,10,15,18,20};
		int[] std = {10,12,15,18,20};
		int[] error = {5,8,10,15,18,20};
		for(int sizeR = 0;sizeR<range.length;sizeR++){
			for(int sizeS = 0;sizeS<std.length;sizeS++){
				for(int sizeE = 0;sizeE < error.length;sizeE++){

					File file  = new File("result/experiment5/Std"+std[sizeS]+"Range"+range[sizeR]+"Error"+error[sizeE]+".txt");
					try {
						new File("result/experiment5").mkdirs();
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					PrintWriter out = new PrintWriter(file);



					String string = "std is :" + std[sizeS] + " range is :" + range[sizeR] +" error is : " + error[sizeE] +"\n";
					out.write(string);


					for(int i=0;i<boundry;i++){
						list = Parser.readFile(test1+fileName1.get(i));
						base = Parser.readFile(test2+fileName2.get(i));
						long totalTimeStart = System.nanoTime();
						counter=0;

						BigInteger holder = new BigInteger("0");
						BigInteger lastPosition = new BigInteger("0");
						ArrayList<Double> rangeList = new ArrayList<Double>();
						boolean predictMode = false;

						//Variables to help save the results
						double tempTime = 0;
						int occurTime = 0;
						double averageError = 0;

						ArrayList<Client> a = new ArrayList<Client>();
						if(list.size()>=base.size()){
							a = list;
							list = base;
							base = a;
						}

						for(int j=0; j<list.size();j++){
							Client b = list.get(j);
							//time for one computation
							long startTime = System.nanoTime();
							holder = Utils.computeMatrix(base.get(j),b);
							counter++;
							long endTime = System.nanoTime();

							//Check if the predict mode is on
							//If false, add the current distance to the list
							if(predictMode == false)
								rangeList.add(Utils.convertToDouble(holder));
							//If true, predict the distance
							else if(predictMode == true){
								//Store the saved time, occur time and error
								System.out.println("The predict position is "+(Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList))+ ", the real distance is "+holder);
								//If the prediction is not good enough, close the predict mode
								if(Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder))>=error[sizeE]){
									System.out.println("Predict mode is off now. The error is "+ Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder))+"m.");
									predictMode = false;
									rangeList = new ArrayList<Double>();
									rangeList.add(Utils.convertToDouble(holder));
								}
								//If the prediction is good enough, move on
								else{
									tempTime = tempTime + (range[sizeR]-1)*(endTime - startTime)/1000000.0;
									occurTime++;
									averageError = averageError + Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder));
									j = j+(range[sizeR]-1);
								}
								//Update the latest position anyway
								lastPosition = holder;
							}

							if(rangeList.size()==range[sizeR] && predictMode == false){
								if(Utils.computeSTD(rangeList)<std[sizeS]){
									System.out.println("Predict mode is on now. The STD is "+ Utils.computeSTD(rangeList));
									predictMode = true;
									lastPosition = holder;
									j = j+(range[sizeR]-1);
								}
								//Remove the first element
								else{
									rangeList.remove(0);
								}

							}


						}

						long totalTimeEnd = System.nanoTime();
						System.out.println("---------------------------------");
						System.out.println("All tests in "+fileName1.get(i)+" and "+fileName2.get(i)+" are finished, Total computation time is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms");
						System.out.println("Average computation time is = "+((totalTimeEnd-totalTimeStart)/1000000.0/counter)+"ms");

						Result temp = new Result(totalTimeEnd,totalTimeStart,counter);
						temp.setSavedTime(tempTime);
						temp.setOccurTime(occurTime);
						temp.setAverageError(averageError/occurTime);
						temp.setTotalNumber(counter);
						result[i] = temp;

					}
					/**
					 * Print out results
					 */
					out.write("------------Round----------------\n");
					//round
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+(i+1));
							out.write("\n");
						}
					}
					out.write("------------Occur time----------------\n");
					//occur time
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+result[i].getOccurTime());
							out.write("\n");
						}
					}
					out.write("-------------Computation time---------------\n");
					//average error
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+result[i].getTotalNumber());
							out.write("\n");
						}
					}
					out.write("----------Saved time------------------\n");
					//saved time 
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+result[i].getSavedTime());
							out.write("\n");
						}
					}

					out.write("-------------Average error---------------\n");
					//average error
					for(int i=0;i<result.length;i++){
						if(result[i].getOccurTime() != 0){
							out.write(""+result[i].getAverageError());
							out.write("\n");
						}
					}

					out.close();

				}
			}
		}
	}

	/**
	 * Experiment 6: time consuming of computing the distance between a fixed base and some users at a specific time,
	 * using the distance prediction method, and the advanced method to control the point range.
	 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
	 * @throws FileNotFoundException
	 */
	public static void experiment6(int testcase1) throws FileNotFoundException{
		//Reading files and generate Clients
		Scanner s = null;
		ArrayList<String> fileName = new ArrayList<String>();
		String file = "";
		String test = "";
		switch(testcase1){
		case 1:
			file = "data/fileName1.txt";
			test = "data/testcase/Data/000/Trajectory/";
			break;
		case 2:
			file = "data/fileName2.txt";
			test = "data/testcase/Data/001/Trajectory/";
			break;
		case 3:
			file = "data/fileName3.txt";
			test = "data/testcase/Data/002/Trajectory/";
			break;
		case 4:
			file = "data/fileName4.txt";
			test = "data/testcase/Data/003/Trajectory/";
			break;
		case 5:
			file = "data/fileName5.txt";
			test = "data/testcase/Data/004/Trajectory/";
			break;
		case 6:
			file = "data/fileName6.txt";
			test = "data/testcase/Data/005/Trajectory/";
			break;
		default:
			file = "data/fileName1.txt";
			test = "data/testcase/Data/000/Trajectory/";
			break;
		}
		try {
			s = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNext()){
			fileName.add(s.next());
		}

		result = new Result[fileName.size()];
		//List to store all the client
		ArrayList<Client> list = new ArrayList<Client>();

		int std = 10;
		int error = 5;
		int[] rangeA =  {3,4,5,6,7,8};
		int[] levelA = {1,2,3,4,5,6};


		for(int sizeR = 0;sizeR<rangeA.length;sizeR++){
			for(int sizeL = 0;sizeL<levelA.length;sizeL++){

				File file1  = new File("result/experiment6/Range"+rangeA[sizeR]+"Level"+levelA[sizeL]+".txt");
				try {
					new File("result/experiment6").mkdirs();
					file1.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PrintWriter out = new PrintWriter(file1);



				String string = " range is :" + rangeA[sizeR] +" level is : " + levelA[sizeL] +"\n";
				out.write(string);

				//fixed base
				Client base = new Client(9999,"base");
				for(int i=0;i<fileName.size();i++){
					list = Parser.readFile(test+fileName.get(i));

					long totalTimeStart = System.nanoTime();
					counter=0;

					int level = levelA[sizeL];
					int range = rangeA[sizeR];
					BigInteger holder = new BigInteger("0");
					BigInteger lastPosition = new BigInteger("0");
					ArrayList<Double> rangeList = new ArrayList<Double>();
					boolean predictMode = false;

					//Variables to help save the results
					double tempTime = 0;
					int occurTime = 0;
					double averageError = 0;

					for(int j=0; j<list.size();j++){
						Client b = list.get(j);
						//time for one computation
						long startTime = System.nanoTime();
						holder = Utils.computeMatrix(base,b);
						counter++;
						long endTime = System.nanoTime();

						//Check if the predict mode is on
						//If false, add the current distance to the list
						if(predictMode == false)
							rangeList.add(Utils.convertToDouble(holder));
						//If true, predict the distance
						else if(predictMode == true){
							//Store the saved time, occur time and error
							System.out.println("The predict position is "+(Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList))+ ", the real distance is "+holder);
							//If the prediction is not good enough, close the predict mode
							if(Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder))>= (error+level)){
								System.out.println("Predict mode is off now. The error is "+ Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder))+"m.");
								predictMode = false;
								rangeList = new ArrayList<Double>();
								rangeList.add(Utils.convertToDouble(holder));
								level = 0;
								range = rangeA[sizeR];
							}
							//If the prediction is good enough, move on
							else{
								level = level+levelA[sizeL];
								range = range + level;
								tempTime = tempTime + (range-1)*(endTime - startTime)/1000000.0;
								occurTime++;
								averageError = averageError + Math.abs((Utils.convertToDouble(lastPosition)+Utils.predictDistance(rangeList)) - Utils.convertToDouble(holder));
								j = j+range-1;
							}
							//Update the latest position anyway
							lastPosition = holder;
						}

						if(rangeList.size()==range && predictMode == false){
							if(Utils.computeSTD(rangeList)< std){
								System.out.println("Predict mode is on now. The STD is "+ Utils.computeSTD(rangeList));
								predictMode = true;
								lastPosition = holder;
								j = j+range-1;
							}
							//Remove the first element
							else{
								rangeList.remove(0);
							}

						}


					}

					long totalTimeEnd = System.nanoTime();
					System.out.println("---------------------------------");
					System.out.println("All tests in "+fileName.get(i)+" are finished, Total computation time is "+((totalTimeEnd-totalTimeStart)/1000000.0)+"ms");
					System.out.println("The number of user is "+list.size());
					System.out.println("Average computation time is = "+((totalTimeEnd-totalTimeStart)/1000000.0/counter)+"ms");

					Result temp = new Result(totalTimeEnd,totalTimeStart,counter);
					temp.setSavedTime(tempTime);
					temp.setOccurTime(occurTime);
					temp.setAverageError(averageError/occurTime);
					temp.setTotalNumber(counter);
					result[i] = temp;

				}


				/**
				 * Print out results
				 */
				out.write("------------Round----------------\n");
				//round
				for(int i=0;i<result.length;i++){
					if(result[i].getOccurTime() != 0){
						out.write(""+(i+1));
						out.write("\n");
					}
				}
				out.write("------------Occur time----------------\n");
				//occur time
				for(int i=0;i<result.length;i++){
					if(result[i].getOccurTime() != 0){
						out.write(""+result[i].getOccurTime());
						out.write("\n");
					}
				}
				out.write("-------------Computation time---------------\n");
				//average error
				for(int i=0;i<result.length;i++){
					if(result[i].getOccurTime() != 0){
						out.write(""+result[i].getTotalNumber());
						out.write("\n");
					}
				}
				out.write("----------Saved time------------------\n");
				//saved time 
				for(int i=0;i<result.length;i++){
					if(result[i].getOccurTime() != 0){
						out.write(""+result[i].getSavedTime());
						out.write("\n");
					}
				}

				out.write("-------------Average error---------------\n");
				//average error
				for(int i=0;i<result.length;i++){
					if(result[i].getOccurTime() != 0){
						out.write(""+result[i].getAverageError());
						out.write("\n");
					}
				}

				out.write("\n");
				out.close();

			}
		}
	}

}
