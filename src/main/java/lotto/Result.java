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
		Message.STATISTICS_MESSAGE.printMessage();
		Message.MATCH_THREE.printMessageWithNumber(matchThree);
		Message.MATCH_FOUR.printMessageWithNumber(matchFour);
		Message.MATCH_FIVE.printMessageWithNumber(matchFive);
		Message.MATCH_FIVE_WITH_BONUS.printMessageWithNumber(matchFiveWithBonus);
		Message.MATCH_SIX.printMessageWithNumber(matchSix);
	}

	public static void printProfitRate(int money){
		int total = matchThree * 5000
				+ matchFour * 50000
				+ matchFive * 1500000
				+ matchFiveWithBonus * 30000000
				+ matchSix * 2000000000;
		Message.printProfitMessage(total, money);
	}
}
