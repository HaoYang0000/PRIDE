/**
 * Class to stored expirements result, contains user number, running time and saved time of each instance.
 * @author Hao Yang
 * @version 1.0
 */
public class Result{
	private double runningTime=0;
	private int userNumber=0;
	private double savedTime=0;
	private int occurTime = 0;
	private double averageError = 0;
	private int totalNumber = 0;
	
	Result(long endtime,long startTime, int userNumber){
		this.runningTime = (endtime-startTime)/1000000.0;
		this.userNumber = userNumber;
	}

	public double getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(double runningTime) {
		this.runningTime = runningTime;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public double getSavedTime() {
		return savedTime;
	}

	public void setSavedTime(double savedTime) {
		this.savedTime = savedTime;
	}

	public int getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(int occurTime) {
		this.occurTime = occurTime;
	}

	public double getAverageError() {
		return averageError;
	}

	public void setAverageError(double averageError) {
		this.averageError = averageError;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

}