package lotto.domain.inputOutput.output;

import lotto.domain.vendingMachine.lotto.Lotto;

import java.util.HashMap;
import java.util.List;

public class LottoOutput {
    public void displayPayLottoMoney(Integer lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void displayLottosNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println("["
                    + numbers.get(0)
                    + ", " + numbers.get(1)
                    + ", " + numbers.get(2)
                    + ", " + numbers.get(3)
                    + ", " + numbers.get(4)
                    + ", " + numbers.get(5)
                    + "]");
        }
    }


}
