package lotto.View;

import lotto.Model.Rate;
import lotto.Model.Winning;
import lotto.Model.WinningResult;
import lotto.Util.Rule;

import java.util.Arrays;

public class OutputResultView {
    private static final String NEWLINE = "\n";

    public static void printResult(WinningResult winningResult, Rate rate) {
        System.out.println(Rule.OUTPUTWINNING_MESSAGE);
        Arrays.stream(Winning.values())
                .filter(winning -> !winning.equals(Winning.EMPTY))
                .forEach(winning -> System.out.println(getprintResultWinning(winning, winningResult)));
        System.out.printf((Rule.OUTPUTRATE_MESSAGE) + NEWLINE, rate.getRate());
    }

    private static String getprintResultWinning(Winning winning, WinningResult winningResult) {
        if (winning == Winning.SECOND) {
            return String.format(Rule.OUTPUTBONUSMATCH_MESSAGE
                    , winning.getMatchLottoNumber()
                    , String.format("%,d", winning.getMoney())
                    , winningResult.getWinningCount(winning));
        }
        return String.format(Rule.OUTPUTMATCH_MESSAGE
                , winning.getMatchLottoNumber()
                , String.format("%,d", winning.getMoney())
                , winningResult.getWinningCount(winning));
    }
}
