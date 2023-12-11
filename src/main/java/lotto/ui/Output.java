package lotto.ui;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.constants.Prize;
import lotto.constants.messages.OutputText;
import lotto.domain.Lotto;

public class Output {
    private final String YIELD_DECIMAL_PLACE = "0.0";
    private final String YIELD_PERCENT_SIGN = "%";

    public void printLotto(long howManyLotto, List<Lotto> lottos) {
        System.out.println();
        System.out.println(String.format(OutputText.PURCHASE_AMOUNT, howManyLotto));
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = sortNumbers(lotto.getNumbers());
            System.out.println(sortedNumbers);
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort((sortedNumbers));
        return sortedNumbers;
    }

    public void printWinning(Map<Integer, Integer> winningByRank) {
        System.out.println();
        System.out.println(OutputText.WINNING_MESSAGE);
        System.out.println(OutputText.DIVIDING_LINE);
        System.out.println(String.format(OutputText.FIFTH_WINNING, winningByRank.get(Prize.FIFTH.getRank())));
        System.out.println(String.format(OutputText.FOURTH_WINNING, winningByRank.get(Prize.FOURTH.getRank())));
        System.out.println(String.format(OutputText.THIRD_WINNING, winningByRank.get(Prize.THIRD.getRank())));
        System.out.println(String.format(OutputText.SECOND_WINNING, winningByRank.get(Prize.SECOND.getRank())));
        System.out.println(String.format(OutputText.FIRST_WINNING, winningByRank.get(Prize.FIRST.getRank())));
    }

    public void printYield(double yield) {
        DecimalFormat decimalPlace = new DecimalFormat(YIELD_DECIMAL_PLACE);
        decimalPlace.setRoundingMode(RoundingMode.HALF_UP);
        String decimalPointYield = decimalPlace.format(yield);
        System.out.println(String.format(OutputText.YIELD, decimalPointYield, YIELD_PERCENT_SIGN));
    }
}
