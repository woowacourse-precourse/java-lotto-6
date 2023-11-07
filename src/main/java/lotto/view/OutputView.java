package lotto.view;

import lotto.domain.LottosPurchased;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";

    public void printNumberOfLottosPurchased(LottosPurchased lottosPurchased) {
        int numberOfLottos = lottosPurchased.getNumberOfLottos();

        System.out.println(numberOfLottos + NUMBER_OF_LOTTOS_MESSAGE);
    }

    public void printLottosPurchased(LottosPurchased lottosPurchased) {
        int numberOfLottos = lottosPurchased.getNumberOfLottos();

        for (int i = 0; i < numberOfLottos; i++) {
            System.out.println(lottosPurchased.getLotto(i));
        }
    }
}
