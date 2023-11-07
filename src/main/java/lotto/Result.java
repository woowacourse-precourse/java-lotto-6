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
}
