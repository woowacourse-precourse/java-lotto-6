package lotto.view;

import java.util.List;
import lotto.constant.OutputConstant;

public class OutputView {

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.printf(OutputConstant.PURCHASE_RESULT.getMessage(), purchaseAmount);
    }

    public void printLottoNumbers(List<List<Integer>> lotteriesNumber) {
        for (List<Integer> lottoNumbers : lotteriesNumber) {
            System.out.println(lottoNumbers);
        }
    }
}
