import java.io.FileNotFoundException;

/**
 * This is the main function to run the experiments for PRIDE system.
 * Note: Some of the experiment takes a lot of time on a normal laptop, about 4-5 hours or even more	 
 * @author Hao Yang
 * @version 1.0
 */

public class main {

	public static void main(String[] str) throws FileNotFoundException{
		/**
		 * Experiment 1: time consuming of encrypt 3 digits numbers, power operation between the encrypted value with another UTM data, 
		 * and decryption to find x1x2+y1y2
		 * @param int n		how many time you prefer to run the experiment and find the average(suggest 10 or more)
		 */
		//Testing.experiment1(10);
		
		/**
		 * Experiment 2: time consuming of computing the distance between a fixed base and some users at a specific time.
		 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
		 * @throws FileNotFoundException
		 */
		//Testing.experiment2(1);

		/**
		 * Experiment 3: time consuming of computing the distance set between multiple users at a specific time.
		 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
		 * @param testcase2		Integer, the GPS data file for testing, could chose 1-6
		 */
		Testing.experiment3(1,2);

		/**
		 * Experiment 4: time consuming of computing the distance between a fixed base and some users at a specific time,
		 * using the distance prediction method.
		 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
		 * @throws FileNotFoundException
		 */
		//Testing.experiment4(3);

		/**
		 * Experiment 5: time consuming of computing the distance set between multiple users at a specific time,
		 * using the distance prediction method.
		 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
		 * @throws FileNotFoundException
		 */
		//Testing.experiment5(1,2);

		/**
		 * Experiment 6: time consuming of computing the distance between a fixed base and some users at a specific time,
		 * using the distance prediction method, and the advanced method to control the point range.
		 * @param testcase1		Integer, the GPS data file for testing, could chose 1-6
		 * @throws FileNotFoundException
		 */
		//Testing.experiment6(1);
	}
}