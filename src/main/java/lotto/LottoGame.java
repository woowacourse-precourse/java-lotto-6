package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    List<Lotto> lottos;

    public LottoGame() {
        this.lottos = new ArrayList<>();
    }


    public void buy(int quantity) {
        for (int q = 0; q < quantity; q++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<List<Integer>> getLottos() {
        List<List<Integer>> lottosNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            lottosNumbers.add(numbers);
        }
        return lottosNumbers;
    }

}
