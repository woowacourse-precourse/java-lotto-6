package lotto.domain;

import lotto.constant.Message;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private final int UNIT_MONEY = 1000;
    private final int MAXIMUM_MONEY = 100000000;
    private int amount;

    private final List<Lotto> lottos = new ArrayList<>();

    public void saveAmount(int money) {

        validate(money);
        this.amount = money/UNIT_MONEY;
    }

    public void saveNumbers(List<Integer> numbers) {

        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
    }

    public int getAmount() {

        return amount;
    }

    public List<Lotto> getLottos() {

        return lottos;
    }

    private void validate(int money) {

        if(money < UNIT_MONEY) {

            throw new IllegalArgumentException(Message.MINIMUM_MONEY_ERROR_MESSAGE.name());
        }

        if(money > MAXIMUM_MONEY) {

            throw new IllegalArgumentException(Message.MAXIMUM_MONEY_ERROR_MESSAGE.name());
        }

        if(money % UNIT_MONEY != 0) {

            throw new IllegalArgumentException(Message.UNIT_MONEY_ERROR_MESSAGE.name());
        }
    }
}
