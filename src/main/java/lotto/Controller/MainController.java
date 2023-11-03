package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.Lottos;
import lotto.Model.UserLotto;

import java.util.Iterator;

public class MainController {
    InputController inputController;
    LottoGeneratorController generatorController;

    public MainController(){
        inputController = new InputController();
        generatorController = new LottoGeneratorController();
    }

    public int[] lottoCheck(Lottos lottos, UserLotto user_lotto){
        // 5, 4, 3, 2, 1등 순
        int[] rank = {0, 0, 0, 0, 0};

        // 당첨번호 갯수 추출
        Iterator<Lotto> it = lottos.getLottos().iterator();
        while(it.hasNext()){
            Lotto lotto = it.next();
            int cnt = countEqualNumber(lotto, user_lotto);

            if(cnt >= 3 && cnt != 5){
                rank[cnt - 3]++;
            }else if(cnt == 5){
                // 보너스번호가 일치하는가?
                if(lotto.getNumbers().contains(user_lotto.getNumbers().indexOf(user_lotto.getNumbers().size() - 1))){
                    rank[3]++;
                }else
                    rank[2]++;
            }
        }

        return rank;
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

    public void lottoStart(){
        int money = inputController.inputMoney();
        Lottos lottos = generatorController.lottoGenerate(money);
        UserLotto user_lotto = inputController.inputNumbers();
        int[] rank = lottoCheck(lottos, user_lotto);
        for(int i = 0; i < rank.length; i++)
            System.out.println(rank[i]);
    }


}
