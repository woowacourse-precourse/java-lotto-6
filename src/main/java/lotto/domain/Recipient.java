package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.view.InputView;

public class Recipient {

    private List<Lotto> lottos;

    //todo : 여기에 console의 입력을 끌어다 쓰는게 맞는가? , 하지만 사람이 돈을 제시하는 느낌이고 싶은데..
    public String tellMoney(){
        return InputView.inputMoneyToBuyMessage();
    }
}
