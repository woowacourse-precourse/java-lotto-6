package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningStatus;

public class ConsoleOutput implements Output {
    private static final String LOTTO_PRICE_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";
    private static final String MATCH3_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String MATCH4_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String MATCH5_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String MATCH5_WITH_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String MATCH6_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String BUY_NUMBER_OF_LOTTO_MESSAGE = "%d개를 구매했습니다.";
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
    public void printWinningStatus(Map<WinningStatus, Integer> winningStatus) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(MATCH3_MESSAGE.formatted(winningStatus.get(WinningStatus.MATCH3)));
        buffer.append(MATCH4_MESSAGE.formatted(winningStatus.get(WinningStatus.MATCH4)));
        buffer.append(MATCH5_MESSAGE.formatted(winningStatus.get(WinningStatus.MATCH5)));
        buffer.append(MATCH5_WITH_BONUS_MESSAGE.formatted(winningStatus.get(WinningStatus.MATCH5_WITH_BONUS)));
        buffer.append(MATCH6_MESSAGE.formatted(winningStatus.get(WinningStatus.MATCH6)));

        System.out.println(buffer);
    }

    @Override
    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(RETURN_OF_RATE_MESSAGE.formatted(rateOfReturn));
    }
}
