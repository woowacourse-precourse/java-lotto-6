package lotto.model;

import static lotto.constants.LottoConstants.LOTTO_END;
import static lotto.constants.LottoConstants.LOTTO_SIZE;
import static lotto.constants.LottoConstants.LOTTO_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final Money money;
    private Lottos lottos;

    public LottoMachine(Money money) {
        this.money = money;
        createLottos();
    }

    public Lottos getLottos() {
        return lottos;
    }

    private void createLottos() {
        int reps = money.getMoney() / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < reps; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END,
                    LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
        this.lottos = new Lottos(lottos);
    }

}
