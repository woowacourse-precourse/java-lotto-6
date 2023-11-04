package lotto.global;

import static lotto.global.LottoInformation.LOTTO_BALLS_NUMBER;
import static lotto.global.LottoInformation.LOTTO_MAX_NUMBER;
import static lotto.global.LottoInformation.LOTTO_MIN_NUMBER;
import static lotto.global.LottoInformation.LOTTO_PRICE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;

public class Store {

    public static int convertPriceToCount(int price) {
        return price / LOTTO_PRICE_UNIT.getValue();
    }

    public static LottoBundle generateLottoBundle(int count) {
        final List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoBundle.add(generateLotto());
        }
        return new LottoBundle(lottoBundle);
    }

    private static Lotto generateLotto() {
        return new Lotto(createNumber());
    }

    private static List<Integer> createNumber() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER.getValue(),
                LOTTO_MAX_NUMBER.getValue(),
                LOTTO_BALLS_NUMBER.getValue()
        );
        return numbers.stream().distinct().sorted().collect(Collectors.toList());
    }
}
