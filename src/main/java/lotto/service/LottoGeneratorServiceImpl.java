package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorServiceImpl implements LottoGeneratorService {
    @Override
    public List<Lotto> myLottos(int price) {
        int count = price / 1000;
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            myLottos.add(generateLotto());
        }
        return myLottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
