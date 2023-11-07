package lotto.service;

import static lotto.constants.Constants.LOTTO_NUMBER_RANGE_END;
import static lotto.constants.Constants.LOTTO_NUMBER_RANGE_START;
import static lotto.constants.Constants.LOTTO_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.Output;

public class LottoNumberService {

    public Lottos createRandomLottos(Cost cost) {
        Output.lottoPurchase(cost.getDivideCost());
        List<Lotto> lottos = new ArrayList<>();
        while (cost.hasMoney()) {
            try {
                Lotto randomLotto = createRandomLotto();
                lottos.add(randomLotto);
                cost.buyingLotto();
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        return new Lottos(lottos);
    }


    private Lotto createRandomLotto() {
        List<Integer> randomNumbers = createRandomNumbers();
        Lotto lotto = new Lotto(randomNumbers);
        return lotto;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END,
                LOTTO_NUMBER_SIZE);
        return new ArrayList<>(randomNumbers);
    }
}
