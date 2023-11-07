package lotto;

public class Result {
	private static int matchThree = 0;
	private static int matchFour = 0;
	private static int matchFive = 0;
	private static int matchFiveWithBonus = 0;
	private static int matchSix = 0;

	public static void setResult(int number, boolean bonus){
		if (number == Number.THREE.getNumber())
			matchThree++;
		if (number == Number.FOUR.getNumber())
			matchFour++;
		if (number == Number.FIVE.getNumber() && !bonus)
			matchFive++;
		if (number == Number.FIVE.getNumber() && bonus)
			matchFiveWithBonus++;
		if (number == Number.SIX.getNumber())
			matchSix++;
	}
	public static void printResult(){
		Message.STATISTICS_MESSAGE.getMessage();
		Message.MATCH_THREE.getMessage(matchThree);
		Message.MATCH_FOUR.getMessage(matchFour);
		Message.MATCH_FIVE.getMessage(matchFive);
		Message.MATCH_FIVE_WITH_BONUS.getMessage(matchFiveWithBonus);
		Message.MATCH_SIX.getMessage(matchSix);
	}

	public void printProfitRate(int money){
		int total = matchThree * 5000
				+ matchFour * 50000
				+ matchFive * 1500000
				+ matchFiveWithBonus * 30000000
				+ matchSix * 2000000000;
		Message.printMessage("총 수익률은 " + total / money + "입니다.");
	}
}
