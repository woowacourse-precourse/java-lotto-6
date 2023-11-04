package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.RankingLotto;
import lotto.domain.MyLottos;
import lotto.domain.ResultLotto;

import java.text.DecimalFormat;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PURCHASE_LOTTO_NUMBER_MESSAGE = "%d개를 구매했습니다.";
    private static final String COMMA = ", ";
    private static final String LOTTO_YIELD_MESSAGE = "총 수익률은 ";


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
        String drawLotto = "[";
        drawLotto += lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(COMMA));
        drawLotto += "]";
        return drawLotto;
    }

    public static void winningResult(ResultLotto resultLotto) {
        for (RankingLotto rankingLotto : RankingLotto.values()) {
            if (rankingLotto == RankingLotto.MISS) {
                continue;
            }
            System.out.print(rankingLotto.getMessage());
            System.out.print(" (" + rankingLotto.getReward() + "원) - ");
            System.out.println(resultLotto.getScore().get(rankingLotto) + "개");
        }
    }

    public static void printLottoYield(double yield) {
        System.out.print(LOTTO_YIELD_MESSAGE + roundToTwoDecimalPlaces(yield) + "%입니다.");
    }

    public static String roundToTwoDecimalPlaces(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(number);
    }

}
