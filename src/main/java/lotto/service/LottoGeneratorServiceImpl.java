package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.utils.NumberParser;
import lotto.validate.LottoValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.NumberConstant.*;

public class LottoGeneratorServiceImpl implements LottoGeneratorService {
    private LottoGeneratorServiceImpl() {}
    private static class LottoGeneratorHelper {
        private static final LottoGeneratorService LOTTO_GENERATOR_SERVICE = new LottoGeneratorServiceImpl();
    }

    public static LottoGeneratorService getInstance(){
        return LottoGeneratorHelper.LOTTO_GENERATOR_SERVICE;
    }

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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN.getValue(), MAX.getValue(), SIZE.getValue());
        return new Lotto(numbers);
    }

    private int getCount(int price) {
        LottoValidator.isDivedWithThousand(price);
        return price / PRICE_UNIT.getValue();
    }
}
