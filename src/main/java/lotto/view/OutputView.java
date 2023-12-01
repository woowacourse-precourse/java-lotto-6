package lotto.view;

import lotto.domain.LottoBundle;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printLottoBundle(final LottoBundle lottoBundle) {
        Format.PURCHASE_LOTTO.print(lottoBundle.size());
        lottoBundle.getLottos()
                .forEach(lotto ->
                        System.out.println(lotto.getNumbers())
                );
    }
}
