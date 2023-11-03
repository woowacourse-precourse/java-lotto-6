package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.Lottos;
import lotto.Model.UserLotto;
import lotto.View.PrintView;

import java.util.Iterator;

public class MainController {
    InputController inputController;
    LottoGeneratorController generatorController;
    PrintView view;

    public MainController(){
        inputController = new InputController();
        generatorController = new LottoGeneratorController();
        view = new PrintView();
    }

    public int[] lottoCheck(Lottos lottos, UserLotto user_lotto){
        // 5, 4, 3, 2, 1등 순
        int[] rank_cnt = {0, 0, 0, 0, 0};

        // 당첨번호 갯수 추출
        Iterator<Lotto> it = lottos.getLottos().iterator();
        while(it.hasNext()){
            Lotto lotto = it.next();
            int cnt = countEqualNumber(lotto, user_lotto);

            if(cnt >= 3 && cnt != 5){
                rank_cnt[cnt - 3]++;
            }else if(cnt == 5){
                // 보너스번호가 일치하는가?
                if(lotto.getNumbers().contains(user_lotto.getNumbers().indexOf(user_lotto.getNumbers().size() - 1))){
                    rank_cnt[3]++;
                }else
                    rank_cnt[2]++;
            }
        }

        return rank_cnt;
    }

    public int countEqualNumber(Lotto lotto, UserLotto user_lotto){
        int cnt = 0;

        // 1개의 lotto
        Iterator<Integer> user_it = user_lotto.getNumbers().iterator();

        while(user_it.hasNext()){
            int num = user_it.next();
            if(lotto.getNumbers().contains(num))
                cnt++;
        }

        return cnt;
    }

    public float getRevenue(int[] rank_cnt, int[] winner_price, int money){
        float result = 0;
        int price = 0;

        for(int i = 0; i < rank_cnt.length; i++){
            if(rank_cnt[i] > 0)
                price += winner_price[i];
        }

        result = (float)price / money * 100;

        return result;
    }

    public void lottoStart(){
        int[] winnings = {5000, 50000, 1500000, 30000000, 2000000000};
        int money = inputController.inputMoney();
        Lottos lottos = generatorController.lottoGenerate(money);
        UserLotto user_lotto = inputController.inputNumbers();
        int[] rank_cnt = lottoCheck(lottos, user_lotto);
        float rate = getRevenue(rank_cnt, winnings, money);
        view.resultPrint(rank_cnt, rate);

    }


}
