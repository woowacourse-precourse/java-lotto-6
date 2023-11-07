package lotto.ui;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class Output {
    private final String PURCHASE_AMOUNT = "%s개를 구매했습니다.";
    private final String FIFTH_WINNING = "3개 일치 (5,000원) - %s개";
    private final String FOURTH_WINNING = "4개 일치 (50,000원) - %s개";
    private final String THIRD_WINNING = "5개 일치 (150,000원) - %s개";
    private final String SECOND_WINNING = "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개";
    private final String FIRST_WINNING = "6개 일치 (2,000,000,000원) - %s개";
    private final String YEILD = "총 수익률은 %s%s입니다.";
    private final String DECIMAL_PLACE = "0.0";

    public void printLotto(long howManyLotto, List<Lotto> lottos) {
        System.out.println();
        System.out.println(String.format(PURCHASE_AMOUNT, howManyLotto));
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public void printWinning(Map<Integer, Integer> winningByRank) {
        System.out.println();
        System.out.println("당첨 내역");
        System.out.println("---");
        System.out.println(String.format(FIFTH_WINNING, winningByRank.get(5)));
        System.out.println(String.format(FOURTH_WINNING, winningByRank.get(4)));
        System.out.println(String.format(THIRD_WINNING, winningByRank.get(3)));
        System.out.println(String.format(SECOND_WINNING, winningByRank.get(2)));
        System.out.println(String.format(FIRST_WINNING, winningByRank.get(1)));
    }

    public void printYeild(double yeild) {
        DecimalFormat decimalPlace = new DecimalFormat(DECIMAL_PLACE);
        decimalPlace.setRoundingMode(RoundingMode.HALF_UP);
        String decimalPointYield = decimalPlace.format(yeild);
        System.out.println(String.format(YEILD, decimalPointYield, "%"));
    }
}
