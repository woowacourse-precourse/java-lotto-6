package lotto.view;

import lotto.common.message.OutputMessage;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;
    public int outputPurchaseLotto(int inputPrice){
        int lottoCount = inputPrice / LOTTO_PRICE;
        System.out.println();
        System.out.println(String.format(OutputMessage.OUTPUT_BUYING_RESULT, lottoCount));
        return lottoCount;
    }

}
