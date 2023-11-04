package lotto.domain;

import lotto.function.GetNumberFunction;
import lotto.function.PrintMessageFunction;

import java.util.List;

public class GetLottoNumbers {

    GetNumberFunction getNumberFunction = new GetNumberFunction();
    PrintMessageFunction printMessageFunction = new PrintMessageFunction();

    public Lotto LottoNumbers() {
        List<Integer> lottoNumbers = getNumberFunction.getLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        printMessageFunction.printLottoNumbers(lotto.getLottoNumbers());

        return lotto;
    }
}
