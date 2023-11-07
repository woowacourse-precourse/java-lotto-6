package lotto.controller;


import java.util.List;
import lotto.domain.InputNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.OutputMoney;
import lotto.view.OutputView;
import lotto.view.Request;

public class Lottogame {
    private List<Lottos> lotto;
    public void start(){
        Integer lottomoney = InputNumber.InputMoney(Request.requestNubmer());
        Integer count = Money.countMoney(lottomoney);
        System.out.print(count);
        OutputMoney.resultMoney(count);

        for(Lottos lottos : lotto){
            OutputView.displayLotto(lottos);
        }
    }
}
