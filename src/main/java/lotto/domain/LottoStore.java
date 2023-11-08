package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int NUM_COUNT = 6;
    private static final int MIN_PRICE = 1000;

    private long chargedMoney;

    public void getMoney(final long moneyInput) {
        validateChargedMoney(moneyInput);
        chargeMoney(moneyInput);
    }

    public void validateChargedMoney(final long moneyInput) {
        if (moneyInput < MIN_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_THOUSAND.errorMessage);
        }
        if (moneyInput % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVIDED_DISABLE.errorMessage);
        }
    }

    public void chargeMoney(final long moneyInput) {
        this.chargedMoney = moneyInput;
    }

    public void sellLottos(final Customer customer) {
        customer.setLotto(generateAllLottos());
    }

    public List<Lotto> generateAllLottos() {
        return LongStream.range(0, chargedMoney / LOTTO_PRICE)
                .mapToObj(number -> generateLottoNumbers())
                .toList();
    }

    public Lotto generateLottoNumbers() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, NUM_COUNT)
                .stream()
                .sorted()
                .toList();

        return new Lotto(numbers);
    }

    public long getChargedMoney() {
        return this.chargedMoney;
    }
}
