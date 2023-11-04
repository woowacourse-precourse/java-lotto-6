package lotto;

import java.util.HashMap;

public class OutputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String AMOUNT_OF_LOTTO_MESSAGE = "개를 구매했습니다.";

    public static void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }
    public static void printAmountOfLotto(int count){
        System.out.println(count + AMOUNT_OF_LOTTO_MESSAGE);
    }
    public static void printLotto(HashMap<Integer, Lotto> lotties) {
        for (int i = 0; i < lotties.size(); i++) {
            System.out.println(lotties.get(i).getLotto());
        }
    }
}
