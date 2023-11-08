package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class LottoStore {
    private int cash;
    private List<Lotto> lottos;
    LottoStore(){
        System.out.println("구입금액을 입력해 주세요.");
        InputCash();
    }
    void InputCash(){
        try {
            int tmpCash = Integer.parseInt(Console.readLine());
            if(tmpCash % 1000 != 0) throw new IllegalArgumentException();
            if(tmpCash < 1000) throw new IllegalArgumentException();
            this.cash = tmpCash;
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력");
            InputCash();
        }
    }

    void buy_Lotto(){
        List<Lotto> temp_lotto = new ArrayList<>();
        System.out.println(cash / 1000 + "개를 구매했습니다.");
        for(int i = 0; i < cash / 1000; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> BuyLotto = new ArrayList<>();
            BuyLotto.addAll(numbers);
            Collections.sort(BuyLotto);
            Lotto lotto = new Lotto(BuyLotto);
            temp_lotto.add(lotto);
        }
        setLotto(temp_lotto);
    }

    void setLotto(List<Lotto> lottos){
        this.lottos = lottos;
    }

    List<Lotto> getLotto(){
        return this.lottos;
    }

    void showLotto(){
        for (Lotto lotto : this.lottos) {
            lotto.showNumbers();
        }
    }
}
