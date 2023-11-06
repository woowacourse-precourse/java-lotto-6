package lotto.VIew;

import static lotto.Message.OutputViewMessage.PURCHASED_LOTTO_COUNT;

import lotto.Domain.LottoGroup;
import lotto.Domain.LottoResult.LottoResult;

public class OutputViewImpl implements OutputView{


    @Override
    public void printLottoCount(int lottoCount) {
        System.out.println(PURCHASED_LOTTO_COUNT.getMessage(lottoCount));
    }

    @Override
    public void printOrderedLottos(LottoGroup lottoGroup) {

    }

    @Override
    public void printLottoResult(LottoResult lottoResult) {

    }

    @Override
    public void printProfitRate(float profitRate) {

    }
}
