package lotto.view;

import static lotto.util.Constants.*;
import static lotto.util.PrintPhrase.*;

import java.awt.desktop.SystemEventListener;
import java.text.DecimalFormat;
import java.util.List;

import lotto.model.EarningResult;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.util.PrintPhrase;

public class OutputView {
	public static void printUserLotto(UserLotto userLotto){
		List<Lotto> lottoList = userLotto.getLottoList();
		System.out.print(lottoList.size());
		System.out.println(PrintPhrase.OutputMessage.MSG_LOTTO_QUANTITY);
		for (Lotto lotto : lottoList) {
			List<Integer> numbers = lotto.getNumbers();
			System.out.println(numbers.toString());
		}
	}
	public void printEarningResult(EarningResult result){
		System.out.println();
		printWinningLotto(result);
		printEarning(result);
	}
	public void printWinningLotto(EarningResult result){
		System.out.println(PrintPhrase.OutputMessage.MSG_WINNING_STATISTICS);
		System.out.println(PrintPhrase.OutputMessage.MSG_LINE);
		printThreeHit(result);
		printFourHit(result);
		printFiveHit(result);
		printFiveWithBonusHit(result);
		printSixHit(result);
	}
	public void printStaticsFormatPre(){
		System.out.print(PrintPhrase.OutputMessage.MSG_WINNING_WITHOUT_BONUSNUM);
		System.out.print(PrintPhrase.BLANK + PrintPhrase.BRACKET_START);
	}
	public void printStaticsFormatMid(){
		System.out.print(PrintPhrase.OutputMessage.MSG_MONEY_UNIT+ PrintPhrase.BRACKET_END + PrintPhrase.BLANK);
		System.out.print(PrintPhrase.LINE);
		System.out.print(PrintPhrase.BLANK);
	}
	private void printStaticsFormatPost() {
		System.out.println(PrintPhrase.OutputMessage.MSG_COUNT_UNIT);
	}
	public void printThreeHit(EarningResult result){
		System.out.print(HIT_THREE);
		printStaticsFormatPre();
		DecimalFormat decimalFormat = new DecimalFormat(FORMAT_PRICE);
		System.out.print(decimalFormat.format(HIT_THREE_PRIZE));
		printStaticsFormatMid();
		System.out.print(result.getTotalThreeHit());
		printStaticsFormatPost();
	}
	public void printFourHit(EarningResult result){
		System.out.print(HIT_FOUR);
		printStaticsFormatPre();
		DecimalFormat decimalFormat = new DecimalFormat(FORMAT_PRICE);
		System.out.print(decimalFormat.format(HIT_FOUR_PRIZE));
		printStaticsFormatMid();
		System.out.print(result.getTotalFourHit());
		printStaticsFormatPost();
	}
	public void printFiveHit(EarningResult result){
		System.out.print(HIT_FIVE);
		printStaticsFormatPre();
		DecimalFormat decimalFormat = new DecimalFormat(FORMAT_PRICE);
		System.out.print(decimalFormat.format(HIT_FIVE_PRIZE));
		printStaticsFormatMid();
		System.out.print(result.getTotalFiveHit());
		printStaticsFormatPost();
	}
	public void printFiveWithBonusHit(EarningResult result){
		System.out.print(PrintPhrase.OutputMessage.MSG_WINNING_WITH_BONUSNUM);
		System.out.print(PrintPhrase.BLANK + PrintPhrase.BRACKET_START);
		DecimalFormat decimalFormat = new DecimalFormat(FORMAT_PRICE);
		System.out.print(decimalFormat.format(HIT_FIVE_WITH_BONUS_PRIZE));
		printStaticsFormatMid();
		System.out.print(result.getTotalFiveWithBonusHit());
		printStaticsFormatPost();
	}
	public void printSixHit(EarningResult result){
		System.out.print(HIT_SIX);
		printStaticsFormatPre();
		DecimalFormat decimalFormat = new DecimalFormat(FORMAT_PRICE);
		System.out.print(decimalFormat.format(HIT_SIX_PRIZE));
		printStaticsFormatMid();
		System.out.print(result.getTotalSixHit());
		printStaticsFormatPost();
	}
	public void printEarning(EarningResult result){
		System.out.print(PrintPhrase.OutputMessage.MSG_RATE_OF_RETURN_FIRST);
		DecimalFormat decimalFormat = new DecimalFormat(FORMAT_ONE_DICIMAL);
		System.out.print(Double.parseDouble(decimalFormat.format(result.getEarningRate())));
		System.out.print(PrintPhrase.OutputMessage.MSG_RATE_OF_RETURN_END);
	}
}
