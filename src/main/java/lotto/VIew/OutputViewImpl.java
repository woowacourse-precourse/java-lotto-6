package lotto.VIew;

import static lotto.Message.OutputViewMessage.PURCHASED_LOTTO_COUNT;

import java.util.List;
import lotto.Domain.LottoGroup;
import lotto.Domain.LottoResult.LottoResult;

public class OutputViewImpl implements OutputView{


    @Override
    public void printLottoCount(int lottoCount) {
        System.out.println(PURCHASED_LOTTO_COUNT.getMessage(lottoCount));
    }

    @Override
    public void printOrderedLottos(LottoGroup lottoGroup) {
        for (int order = 0; order < lottoGroup.findLottoNumbersSize(); order++) {
            List<Integer> numbers = lottoGroup.findLottoByIndex(order).getNumbers();
            numbers.sort(Integer::compareTo);
            System.out.println(numbers);
        }
    }

    @Override
    public void printLottoResult(LottoResult lottoResult) {

    }

    @Override
    public void printProfitRate(float profitRate) {

    }
}
