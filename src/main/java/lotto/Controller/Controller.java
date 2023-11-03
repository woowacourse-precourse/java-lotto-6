package lotto.Controller;

import lotto.Lotto;
import lotto.Model.LottoRandom;
import lotto.View.View;

import java.util.List;

public class Controller {
    View view = new View();
    LottoRandom randLotto = new LottoRandom();
    public void LotteStart(){

        int myMoney = view.buyMoney();
        int count = view.buyLotto(myMoney);

        System.out.println(myMoney / 1000 + "개를 구매했습니다.");

        List listLotto = randLotto.getBuyLotto(count);
        view.myLotto(listLotto);
        List correctLotto= correctLotto();

    }
    private List<Integer> correctLotto(){
        List correctLotto = view.correctNum();
        try{
            new Lotto(correctLotto);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
            correctLotto();
        }
        return correctLotto;
    }
}
