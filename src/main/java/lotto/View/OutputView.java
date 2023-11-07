package lotto.View;

import java.util.List;
import lotto.Constant.Constant;
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

    public void showLotties(List<Lotto> lotties) {
        for (Lotto lotto : lotties) {
            System.out.println(lotto.getNumbers());
        }
    }
}
