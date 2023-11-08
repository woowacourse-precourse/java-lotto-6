package lotto.model;

import static lotto.view.InputView.lottoBoughtPrice;

public class User {
    public static int lottoBoughtNum;

    public static void lottoBoughtNum() {
        lottoBoughtNum = lottoBoughtPrice / 1000;
    }
}
