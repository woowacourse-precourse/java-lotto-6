package lotto.model;

public class WinningStatistics {
	
	private int []numberWinnings = new int[5];
	private double totalProfitRate;
	
	public double getRate() {
		return this.totalProfitRate;
	}
	
	public void setRate(double rate) {
		this.totalProfitRate = rate;
	}
	
	public int[] getWinningCount() {
		return this.numberWinnings;
	}
	
	public void firstWinning() {
		numberWinnings[0]++;
	}
	public void secondWinning() {
		numberWinnings[1]++;
	}
	public void thirdWinning() {
		numberWinnings[2]++;
	}
	public void fourthWinning() {
		numberWinnings[3]++;
	}
	public void fifthWinning() {
		numberWinnings[4]++;
	}
}
