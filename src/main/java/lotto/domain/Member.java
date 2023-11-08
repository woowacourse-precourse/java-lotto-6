package lotto.domain;

import static lotto.constant.NumberConstants.LOTTO_PRICE;

import java.util.List;
import lotto.validator.LottoValidator;
import lotto.validator.MoneyValidator;

public record Member(long inputMoney, List<Lotto> lottos) {

    public Member {
        validateInputMoney(inputMoney);
        validateLottos(lottos);
    }

    private static void validateInputMoney(long money) {
        MoneyValidator moneyValidator = new MoneyValidator(String.valueOf(money));
        moneyValidator.validateAll();
    }

    private static void validateLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::numbers)
                .forEach(numbers -> new LottoValidator(numbers).validateAll());
    }

    public long calculateQuantity() {
        return inputMoney / LOTTO_PRICE;
    }

}
