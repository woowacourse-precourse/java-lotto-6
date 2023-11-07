package lotto.view;

import lotto.model.Lotto;
import lotto.model.User;

import java.util.HashMap;

public class OutputView {

    public void printLotto(User user){
        System.out.println((user.getPayed() / 1000) + "개를 구매했습니다.");
        for (Lotto lotto : user.getLottos()){
            System.out.println(lotto.toString());
        }
    }

    public void printPrizes(HashMap<Integer, Integer> matches, double earnedPerPayed) {
        System.out.println("3개 일치 (5,000원) - " + matches.getOrDefault(3, 0) +"개");
        System.out.println("4개 일치 (50,000원) - " + matches.getOrDefault(4, 0) +"개");
        "5개 일치 (1,500,000원)" + matches.getOrDefault(5, 0) +"개"
        "5개 일치, 보너스 볼 일치 (30,000,000원) - "+ matches.getOrDefault(, 0) +"개""
        "6개 일치 (2,000,000,000원) - 0개""
    }
}
