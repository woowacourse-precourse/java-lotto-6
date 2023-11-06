package lotto.domain.io;

public class InputView {
    public static final void getCash() {
        System.out.println(InputViewFormat.GUIDE_CASH.getState());
    }

    public static void getLottoAnswer() {
        System.out.println(InputViewFormat.GUIDE_LOTTO_ANSWER.getState());
    }
}
