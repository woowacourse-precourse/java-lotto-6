package lotto.Controller;

import lotto.Lotto;
import lotto.Model.LottoRandom;
import lotto.View.View;

import java.util.List;

public class Controller {
    public void LotteStart(){
        View view = new View();
        LottoRandom randLotto = new LottoRandom();

        int myMoney = view.buyMoney();
        int count = view.buyLotto(myMoney);

        System.out.println(myMoney / 1000 + "개를 구매했습니다.");

        List listLotto = randLotto.getBuyLotto(count);
        view.myLotto(listLotto);
        List correct = view.correctNum();
        new Lotto(correct);
        String bonus = view.bonusNum(correct);
    }
}
