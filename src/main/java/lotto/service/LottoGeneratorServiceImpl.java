package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.utils.NumberParser;
import lotto.validate.LottoValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.NumberConstant.PRICE_UNIT;

public class LottoGeneratorServiceImpl implements LottoGeneratorService {
    @Override
    public List<Lotto> myLottos(String inputPrice) {
        int price = NumberParser.toInteger(inputPrice);
        int count = getCount(price);
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            myLottos.add(generateLotto());
        }
        return myLottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private int getCount(int price) {
        LottoValidator.isDivedWithThousand(price);
        return price / PRICE_UNIT.getValue();
    }
}
