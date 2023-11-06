package lotto;

import static lotto.constant.Constant.COUNT;
import static lotto.constant.Constant.FIFTH_RESULT;
import static lotto.constant.Constant.FIFTH_WINNING_PRICE;
import static lotto.constant.Constant.FIRST_RESULT;
import static lotto.constant.Constant.FIRST_WINNING_PRICE;
import static lotto.constant.Constant.FOURTH_RESULT;
import static lotto.constant.Constant.FOURTH_WINNING_PRICE;
import static lotto.constant.Constant.LOTTO_PRICE;
import static lotto.constant.Constant.LOTTO_RESULT;
import static lotto.constant.Constant.SECOND_WINNING_PRICE;
import static lotto.constant.Constant.SECONT_RESULT;
import static lotto.constant.Constant.THIRD_RESULT;
import static lotto.constant.Constant.THIRD_WINNING_PRICE;

public enum Result {
    FIRST(0), SECOND(0), THIRD(0), FOURTH(0), FIFTH(0);

    private int value;

    Result(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void addValue() {
        this.value++;
    }

    private static Long calculateReturn() {
        return (FIRST.getValue() * FIRST_WINNING_PRICE + SECOND.getValue() * SECOND_WINNING_PRICE
                + THIRD.getValue() * THIRD_WINNING_PRICE + FOURTH.getValue() * FOURTH_WINNING_PRICE
                + FIFTH.getValue() * FIFTH_WINNING_PRICE);
    }

    public static void printResult(int lottoCount) {
        System.out.print(LOTTO_RESULT);
        System.out.println(FIFTH_RESULT + FIFTH.getValue() + COUNT);
        System.out.println(FOURTH_RESULT + FOURTH.getValue() + COUNT);
        System.out.println(THIRD_RESULT + THIRD.getValue() + COUNT);
        System.out.println(SECONT_RESULT + SECOND.getValue() + COUNT);
        System.out.println(FIRST_RESULT + FIRST.getValue() + COUNT);
        System.out.printf("총 수익률은 %.1f%%입니다.", (double) calculateReturn() / ((long) LOTTO_PRICE * lottoCount) * 100);
    }
}
