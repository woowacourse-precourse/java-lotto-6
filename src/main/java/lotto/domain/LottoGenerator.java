package lotto.domain;

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
        long lottoCount = money / 1000;
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
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(sortNumbers(randomNumbers));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

}
