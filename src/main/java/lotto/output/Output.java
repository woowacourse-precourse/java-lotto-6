package lotto.output;

import lotto.domain.Lotteries;

public class Output {
    public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_LOTTO_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void print(final String message) {
        System.out.println(message);
    }

    public static void printLotteries(final Lotteries lotteries) {
        System.out.println(lotteries);
        System.out.println();
    }
}
