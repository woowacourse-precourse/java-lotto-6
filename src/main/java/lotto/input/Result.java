package lotto.input;

import static lotto.input.constant.Constant.FIFTH_WINNING_PRICE;
import static lotto.input.constant.Constant.FIRST_WINNING_PRICE;
import static lotto.input.constant.Constant.FOURTH_WINNING_PRICE;
import static lotto.input.constant.Constant.LOTTO_PRICE;
import static lotto.input.constant.Constant.SECOND_WINNING_PRICE;
import static lotto.input.constant.Constant.THIRD_WINNING_PRICE;

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
        System.out.print("당첨 통계\n---\n");
        System.out.println("3개 일치 (5,000원) - " + FIFTH.getValue() + "개");
        System.out.println("4개 일치 (50,000원) - " + FOURTH.getValue() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + THIRD.getValue() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + SECOND.getValue() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + FIRST.getValue() + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", (double) calculateReturn() / ((long) LOTTO_PRICE * lottoCount) * 100);
    }
}
