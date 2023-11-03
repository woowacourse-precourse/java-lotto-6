package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public void createLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        printLottos();
    }

    private void printLottos() {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers().toString());
        }
    }
}
