package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public class Member {

    private final long inputMoney;
    private final List<Lotto> lottos;

    public Member(long inputMoney, List<Lotto> lottos) {
        validate();
        this.inputMoney = inputMoney;
        this.lottos = lottos;
    }

    private void validate() {
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(lotto -> new LottoValidator(lotto).validateAll());
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
