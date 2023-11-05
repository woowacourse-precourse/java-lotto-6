package lotto.view;

import lotto.model.Lotto;
import lotto.model.Price;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String MONEY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String ANSWER_REQUEST_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_REQUEST_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void printPurchase() {
        System.out.println(MONEY_REQUEST_MESSAGE);
    }

    public static void printLottoCount(int lottoCount) {
        String formattedString = String.format("\n%d%s", lottoCount, COUNT_MESSAGE);
        System.out.println(formattedString);
        stringBuilder.setLength(0);
    }

    public static void printLotto(List<Integer> lotto) {
        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        for (int number: lotto) {
            stringJoiner.add(String.valueOf(number));
        }
        System.out.println(stringJoiner);
        stringBuilder.setLength(0);
    }

    public static void printAnswer() {
        System.out.println(ANSWER_REQUEST_MESSAGE);
    }

    public static void printBonus() {
        System.out.println(BONUS_REQUEST_MESSAGE);
    }

    public static void printPrice(String result, String price, int count) {
        String formattedString = String.format("%s(%s) - %d개", result, price, count);
        System.out.println(formattedString);
        stringBuilder.setLength(0);
    }

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }
}
