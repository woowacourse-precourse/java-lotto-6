package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionMessage;
import lotto.util.NumbersGenerator;

public class Lottos {
    private static final int LOTTO_SIZE = 6;
    private static final int TEN_THOUSAND = 1000;

    private final List<Lotto> lottos;

    private final NumbersGenerator numbersGenerator;

    public Lottos(int money, NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
        this.lottos = createLottosByMoney(money);
    }

    private List<Lotto> createLottosByMoney(int money) {
        List<Lotto> lottos = new ArrayList<>();
        validateTenThousandMultiple(money);
        int amount = toAmount(money);

        for (int i = 0; i < amount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private Lotto createLotto() {
        return new Lotto(numbersGenerator.generator());
    }

    private void validateTenThousandMultiple(int money) {
        if (money == 0 || money % TEN_THOUSAND != 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_TEN_THOUSAND_UNIT_EXCEPTION.getMessage());
        }
    }

    private int toAmount(int money) {
        return money / TEN_THOUSAND;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return lottos.size() * TEN_THOUSAND;
    }

    public int getAmount() {
        return lottos.size();
    }
}
