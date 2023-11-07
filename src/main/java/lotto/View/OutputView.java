package lotto.View;

import lotto.Constant.Constant;
import lotto.Domain.Lotties;
import lotto.Domain.Lotto;

public class OutputView {

    private static OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void showLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + Constant.OUTPUT_LOTTO_COUNT_MESSAGE);
    }

    public void showLotties(Lotties lotties) {
        for (Lotto lotto : lotties.getLotties()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
