package lotto.view;

import java.util.List;
import javax.xml.transform.Result;
import lotto.constant.MessageConstant;
import lotto.constant.ResultConstant;
import lotto.model.Lotto;
import lotto.model.LottoMachine;

public class OutputView {
    public void printBuyLotto(LottoMachine lottoMachine){
        List<Lotto> lottos = lottoMachine.getLottos();
        System.out.println(ResultConstant.BUY_MESSAGE.getMessage(lottos.size()));
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
