package lotto.view;

import lotto.domain.CostValidator;
import lotto.util.Constants;

public class OutputView {
    public void lottoCountResult(){
        System.out.println(CostValidator.lottoCount+ Constants.LOTTO_MESSAGE);
    }
    public void lottoResult(){
        System.out.println(Constants.END_RESULT_MESSAGE);
    }
    public void lottoRate(){

    }
}
