package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;

public class LottoGame {

    LottoManager lottoManager = LottoManager.getInstance();

    public void getRightCost() {
        do {
            getCost();
        } while (!lottoManager.checkNumberOfLottos());
    }

    private void getCost() {
        try {
            lottoManager.setNumberOfLottos(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // TODO 3항연산자 사용 X
    public List<Lotto> addLottos() {
        List<Lotto> allLottos = new ArrayList<>();
        for (int i = 0; i < lottoManager.getNumberOfLottos(); i++) {
            allLottos.add(new Lotto(getRandomNumber()));
        }
        return allLottos;
    }

    private List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
