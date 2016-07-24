import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to read file from a specific place and return a list of all the location information from one client
 * @author Hao Yang
 * @version 1.0
 */

public class Parser {
	
	public static ArrayList<Client> readFile(String fileName ){
		
		//Creating list to store all the location information
		ArrayList<Client> list = new ArrayList<Client>();
		
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//Skip the first 7 Lines in plt file, which contains information that are not helpful
		String line = s.nextLine();
		line = s.nextLine();
		line = s.nextLine();
		line = s.nextLine();
		line = s.nextLine();
		line = s.nextLine();
		line = s.nextLine();
		
//		System.out.println("Read file and generating client...");
//		System.out.println("-----------------------------------");
//		System.out.println();

		int id=0;
		while(s.hasNext()){
			line = s.nextLine();
			
			String temp[] = line.split(",");
			double latitude = Double.parseDouble(temp[0]);
			double longtitude = Double.parseDouble(temp[1]);
			Client tempClient = new Client(id,latitude,longtitude);
			id++;

//			System.out.println("A new client is created...");
//			System.out.println("id: "+tempClient.getId());
//			System.out.println("Latitude: "+latitude);
//			System.out.println("Longitude: "+longtitude);
//			System.out.println("(UTM)Easting: "+tempClient.getEasting());
//			System.out.println("(UTM)Northing: "+tempClient.getNorthing());
//			System.out.println("(UTM)Zone: " +tempClient.getLetterZone());
//			System.out.println("-----------------------------------");
//			System.out.println();
			
			
			list.add(tempClient);

		}
		s.close();
		
//		System.out.println("Finished read file");
//		System.out.println("-----------------------------------");
//		System.out.println();
//		
		return list;
	}
	
	
}


