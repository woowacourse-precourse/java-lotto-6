package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class ConsoleOutput implements Output {
    private static final String LOTTO_PRICE_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO = "%d개를 구매했습니다.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

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
        System.out.println(NUMBER_OF_LOTTO.formatted(size));
    }

    @Override
    public void printWinningNumbersRequest() {
        System.out.println(WINNING_NUMBERS_REQUEST);
    }

    @Override
    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    @Override
    public void printBonusNumberRequest() {
        System.out.println(BONUS_NUMBER_REQUEST);
    }
}
