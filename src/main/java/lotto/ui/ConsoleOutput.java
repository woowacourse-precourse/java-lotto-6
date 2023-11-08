package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningStatus;

public class ConsoleOutput implements Output {
    private static final String LOTTO_PRICE_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "\n보너스 번호를 입력해 주세요.";
    private static final String BUY_NUMBER_OF_LOTTO_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String START_WINNING_STATUS_MESSAGE = "\n당첨 통계\n---\n";
    private static final String RETURN_OF_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printLottoPriceRequest() {
        System.out.println(LOTTO_PRICE_REQUEST);
    }

    @Override
    public void printPurchasedLotto(List<Lotto> lottos) {
        printNumberOfLotto(lottos.size());
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        System.out.println("[" + lotto.getNumbers() + "]");
    }

    private void printNumberOfLotto(int size) {
        System.out.println(BUY_NUMBER_OF_LOTTO_MESSAGE.formatted(size));
    }

    @Override
    public void printWinningNumbersRequest() {
        System.out.println(WINNING_NUMBERS_REQUEST);
    }

    @Override
    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    @Override
    public void printBonusNumberRequest() {
        System.out.println(BONUS_NUMBER_REQUEST);
    }

    @Override
    public void printWinningStatus(WinningStatus winningStatus) {
        System.out.print(START_WINNING_STATUS_MESSAGE + winningStatus.getMessages());
    }

    @Override
    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(RETURN_OF_RATE_MESSAGE.formatted(rateOfReturn));
    }
}
