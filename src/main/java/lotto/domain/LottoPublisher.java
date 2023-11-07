package lotto.domain;

import static lotto.constant.LottoNumber.PURCHASE_UNIT;
import static lotto.constant.LottoNumber.ZERO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Util;

public class LottoPublisher extends Validation {
    private List<Lotto> userLottos;
    private int lottoAmount;
    private int money;

    public LottoPublisher(String money) {
        validatePurchasePrice(money);
        createLottos();
    }

    private void validatePurchasePrice(String money) {
        checkValidInteger(money);
        checkDivideByThousand(money);

        this.money = Integer.parseInt(money);
    }

    private void createLottos() {
        this.userLottos = IntStream.range(ZERO.getNumber(), countLottoAmount(money))
                .mapToObj(index -> new Lotto(Util.generateRandomNumber()))
                .collect(Collectors.toList());
    }

    private int countLottoAmount(int money) {
        int amount = money / PURCHASE_UNIT.getNumber();
        this.lottoAmount = amount;

        return amount;
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public int getMoney() {
        return money;
    }
}
