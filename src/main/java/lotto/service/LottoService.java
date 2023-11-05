package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.Collections;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoService {

    public Lottos createUserLottos(int amount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount; i++) {
            List<Integer> randomNumbers = generateRandomNumbers();
            sortNumbersByAsc(randomNumbers);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    public Lotto createAnswerLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Integer> sortNumbersByAsc(List<Integer> integerList) {
        Collections.sort(integerList);
        return integerList;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
    }
}
