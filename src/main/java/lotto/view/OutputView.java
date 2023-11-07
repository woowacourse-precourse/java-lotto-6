package lotto.view;

import lotto.domain.CostValidator;
import lotto.domain.Lotto;
import lotto.util.Constants;

import java.util.List;

public class OutputView {
    public void lottoCountResult(List<Lotto> lottoNums){
        System.out.println("\n"+CostValidator.lottoCount+ Constants.LOTTO_MESSAGE);
        lottoNumResult(lottoNums);
    }
    public void lottoNumResult(List<Lotto> lottoNums){
        lottoNums.forEach(lotto->lotto.printResult());
        System.out.println();
    }
    public void lottoResult(){
        System.out.println(Constants.END_RESULT_MESSAGE);
    }
    public void lottoRate(){

    }
}
