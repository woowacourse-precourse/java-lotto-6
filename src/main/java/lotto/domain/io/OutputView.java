package lotto.domain.io;

public class OutputView {
    public static final void printLottos(String lottosStatus) {
        System.out.println(lottosStatus);
    }

    public static void printLottoAmount(Integer ticketCount) {
        System.out.println(String.format(OutputViewFormat.GUIDE_LOTTO_AMOUNT_FORMAT.getState(), ticketCount));
    }
}
