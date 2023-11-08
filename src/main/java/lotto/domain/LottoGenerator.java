package lotto.domain;

import static lotto.constant.NumberConstants.LOTTO_NUMBER_MAX;
import static lotto.constant.NumberConstants.LOTTO_NUMBER_MIN;
import static lotto.constant.NumberConstants.LOTTO_NUMBER_SIZE;
import static lotto.constant.NumberConstants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.validator.MoneyValidator;

public class LottoGenerator {

    private final long money;

    public LottoGenerator(long money) {
        this.money = money;
        validateMoney();
    }

    public List<Lotto> generateLottos() {
        long lottoCount = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (long i = 0; i < lottoCount; i++) {
            lottos.add(generateSingleLotto());
        }

        return lottos;
    }

    private void validateMoney() {
        MoneyValidator moneyValidator = new MoneyValidator(String.valueOf(money));
        moneyValidator.validateAll();
    }

    private Lotto generateSingleLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX,
                LOTTO_NUMBER_SIZE);
        return new Lotto(sortNumbers(randomNumbers));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

}
