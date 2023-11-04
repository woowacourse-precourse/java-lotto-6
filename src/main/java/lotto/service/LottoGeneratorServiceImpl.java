package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.utils.NumberParser;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorServiceImpl implements LottoGeneratorService {
    @Override
    public List<Lotto> myLottos(String inputPrice) {
        int price = NumberParser.toInteger(inputPrice);
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
