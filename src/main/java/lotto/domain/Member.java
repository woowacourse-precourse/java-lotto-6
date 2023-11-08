package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;
import lotto.validator.MoneyValidator;

public class Member {

    private final long inputMoney;
    private final List<Lotto> lottos;

    public Member(long inputMoney, List<Lotto> lottos) {
        this.inputMoney = inputMoney;
        this.lottos = lottos;
        validate();
    }

    private void validate() {
        validateMoney();
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(lotto -> new LottoValidator(lotto).validateAll());
    }

    private void validateMoney() {
        MoneyValidator moneyValidator = new MoneyValidator(String.valueOf(inputMoney));
        moneyValidator.validateAll();
    }

    public long getInputMoney() {
        return inputMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public long calculateQuantity() {
        return inputMoney / 1000L;
    }

}
