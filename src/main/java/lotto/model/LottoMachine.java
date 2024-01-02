package lotto.model;

import static lotto.constants.LottoInformation.NUMBER_MAX;
import static lotto.constants.LottoInformation.NUMBER_MIN;
import static lotto.constants.LottoInformation.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> buyLotto(Money money) {
        List<Lotto> randomLotto = new ArrayList<>();
        for (int i = 0; i < money.numberOfLotto(); i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            if (!randomLotto.contains(lotto)) {
                randomLotto.add(lotto);
            }
        }
        return randomLotto;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_MIN, NUMBER_MAX, SIZE);
    }
}
