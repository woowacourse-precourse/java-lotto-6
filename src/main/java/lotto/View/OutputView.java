package lotto.View;

import lotto.Constant.Constant;

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
}
