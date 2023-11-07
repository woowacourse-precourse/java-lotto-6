package lotto.domain.view;

public final class OutputView {
    public static void printLottos(String lottosStatus) {
        System.out.println(lottosStatus);
    }

    public static void printLottoAmount(Integer ticketCount) {
        System.out.printf((OutputViewFormat.GUIDE_LOTTO_AMOUNT_FORMAT.getState()) + "%n", ticketCount);
    }
}
