package lotto.view;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class PrintGames {
    public void purchaseHistory(List<Lotto> lottoGames) {
        int count = lottoGames.size();
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = lottoGames.get(i).getNumbers();
            Collections.sort(lotto);
            System.out.println(lotto);
        }
    }
}
