package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.RankingLotto;
import lotto.domain.MyLottos;
import lotto.domain.ResultLotto;

import java.text.DecimalFormat;

public class OutputView {
    private static final String PURCHASE_LOTTO_NUMBER_MESSAGE = "%d개를 구매했습니다.";
    private static final String COMMA = ", ";
    private static final String LOTTO_YIELD_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String WINNING_LOTTO_REWARD_MESSAGE = " (%s원) -";
    private static final String WINNING_LOTTO_SCORE_MESSAGE = " %s개";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";


    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printMyLottos(int lottoNumber, MyLottos myLottos) {
        System.out.println(String.format(PURCHASE_LOTTO_NUMBER_MESSAGE, lottoNumber));
        drawLotto(myLottos);
    }

    public static void drawLotto(MyLottos myLottos) {
        myLottos.getLottos().stream().forEach(lotto ->
                System.out.println(drawLottoNumber(lotto))
        );
    }

    public static String drawLottoNumber(Lotto lotto) {
        return OPEN_BRACKET + String.join(COMMA, lotto.getNumbers().stream()
                .map(Object::toString)
                .toArray(String[]::new)) + CLOSE_BRACKET;
    }

    public static void winningResult(ResultLotto resultLotto) {
        for (RankingLotto rankingLotto : RankingLotto.values()) {
            if (rankingLotto == RankingLotto.MISS) {
                continue;
            }
            System.out.print(rankingLotto.getMessage());
            System.out.print(String.format(WINNING_LOTTO_REWARD_MESSAGE, rankingLotto.getReward()));
            System.out.println(String.format(WINNING_LOTTO_SCORE_MESSAGE, resultLotto.getScore().get(rankingLotto)));
        }
    }

    public static void printLottoYield(double yield) {
        System.out.print(String.format(LOTTO_YIELD_MESSAGE,roundToTwoDecimalPlaces(yield)));
    }

    public static String roundToTwoDecimalPlaces(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(number);
    }

}
