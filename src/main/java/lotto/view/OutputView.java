package lotto.view;

import lotto.constant.LottoRateConstant;
import lotto.constant.OutputViewMessage;

public class OutputView {
    private static OutputView instance;

    private OutputView() {}

    public static OutputView getInstance() {
        if(instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printLottos(String lottos, int lottoNum) {
        System.out.println(LottoRateConstant.PURCHASE_NUM_MESSAGE.getMessage(lottoNum));
        System.out.println(lottos);
    }

    public void printLottoRate(String lottoRate, double winningAmountRate) {
        System.out.println(OutputViewMessage.WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(lottoRate);
        System.out.println(LottoRateConstant.TOTAL_RETURN_MESSAGE.getMessage(winningAmountRate));
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
