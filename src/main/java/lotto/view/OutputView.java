package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.constant.OutputConstant;
import lotto.domain.Lotto;

public class OutputView {

    public void printPurchaseAmount(String purchaseAmount) {
        System.out.printf(OutputConstant.PURCHASE_RESULT.getMessage(), purchaseAmount);
    }

    public void printLottoNumbers(List<Lotto> lotteries) {
        StringBuilder lottoNumbers = new StringBuilder();

        for (Lotto lotto : lotteries) {
            lottoNumbers.append("[");
            lottoNumbers.append(lotteries).append("]");
        }

        System.out.println(lottoNumbers);
    }
}
