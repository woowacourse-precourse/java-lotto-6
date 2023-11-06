package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_PRINT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_PRINT_MESSAGE = "당첨 통계\n---";

    public void printNumberOfLottosPurchased(int numberOfLottos) {
        System.out.println(numberOfLottos + NUMBER_OF_LOTTOS_PURCHASED_PRINT_MESSAGE);
    }

    public void printLottosPurchased(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
