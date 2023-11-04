package lotto.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String MONEY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String ANSWER_REQUEST_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_REQUEST_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static void printPurchase() {
        System.out.println(MONEY_REQUEST_MESSAGE);
    }

    public static void printLotto(List<Integer> lotto) {
        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        lotto.forEach(number -> stringJoiner.add(number.toString()));
        System.out.println(stringJoiner);
    }

    public static void printLottoCount(int lottoCount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append(lottoCount);
        stringBuilder.append(COUNT_MESSAGE);
        System.out.println(stringBuilder);
    }

    public static void printAnswer() {
        System.out.println(ANSWER_REQUEST_MESSAGE);
    }

    public static void printBonus() {
        System.out.println(BONUS_REQUEST_MESSAGE);
    }
}
