package lotto.Controller;

import lotto.Lotto;
import lotto.Model.LottoRandom;
import lotto.View.View;

import java.util.List;

import static lotto.Model.CountRank.countRank;
import static lotto.View.View.lottoResult;


public class Controller {
    View view = new View();
    LottoRandom rand = new LottoRandom();
    public void LottoStart(){

        int myMoney = view.buyMoney();
        int count = view.buyLotto(myMoney);

        System.out.println(myMoney / 1000 + "개를 구매했습니다.");
        String[] listLotto = rand.getBuyLotto(count);
        List correctLotto = correctLotto();
        String bonus = view.bonusNum(correctLotto);
        List countList = countRank(List.of(listLotto), correctLotto, bonus);
        lottoResult(countList, myMoney);

    }

    private List<Integer> correctLotto(){
        List correctLotto = view.correctNum();
        try{
            new Lotto(correctLotto);
            return correctLotto;
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
        return correctLotto();
    }
}