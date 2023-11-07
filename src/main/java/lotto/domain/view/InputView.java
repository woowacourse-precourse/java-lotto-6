package lotto.domain.view;

public final class InputView {
    public static void getCash() {
        System.out.println(InputViewFormat.GUIDE_CASH.getState());
    }

    public static void getLottoAnswer() {
        System.out.println(InputViewFormat.GUIDE_LOTTO_ANSWER.getState());
    }

    public static void getBonusAnswer() {
        System.out.println(InputViewFormat.GUIDE_BONUS_ANSWER.getState());
    }
}
