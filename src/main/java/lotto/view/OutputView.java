package lotto.view;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_FORMAT = "[%s]\n";

    public void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public void printLotto(String lotto) {
        System.out.printf(LOTTO_FORMAT, lotto);
    }
}
