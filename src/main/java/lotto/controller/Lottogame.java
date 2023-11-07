package lotto.controller;


import java.util.List;
import lotto.domain.InputNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.OutputView;
import lotto.view.Request;

public class Lottogame {
    private List<Lottos> lotto;
    public void start(){
        Integer lottomoney = InputNumber.InputMoney(Request.requestNubmer());
        Integer count = Money.countMoney(lottomoney);
        System.out.print(count);
        Request.resultMoney();
        for(int i = 0; i < count; i++){
            lotto.add(Lottos.create());
        }
        for(Lottos lottos : lotto){
            OutputView.displayLotto(lottos);
        }
    }
}
