package lotto.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String MONEY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static void printPurchase() {
        System.out.println(MONEY_REQUEST_MESSAGE);
    }

    public static void printLotto(List<Integer> lotto) {
        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        lotto.stream()
                .forEach(number -> stringJoiner.add(number.toString()));
        System.out.println(stringJoiner);
    }

    public static void printLottoCount(int lottoCount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append(lottoCount);
        stringBuilder.append(PURCHASE_MESSAGE);
        System.out.println(stringBuilder);
    }
}
