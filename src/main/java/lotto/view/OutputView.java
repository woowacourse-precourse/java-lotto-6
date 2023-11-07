package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void showLottoNum( int num, List<Lotto> lottoGames){
        System.out.println("\n"+num+"개를 구매했습니다.");
        for (int i = 0; i < lottoGames.size(); i++) {
            Lotto lotto = lottoGames.get(i);
            List<Integer> numbers = lotto.getLottoNumber();
            System.out.println(numbers);
        }
    }
}
