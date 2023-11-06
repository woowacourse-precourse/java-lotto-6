package lotto.domain;

import static lotto.constant.LottoNumber.PURCHASE_UNIT;
import static lotto.constant.LottoNumber.ZERO;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_MONEY;
import static lotto.constant.message.ErrorMessage.NOT_PURCHASE_UNIT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Util;

public class LottoPublisher {
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

    private void checkValidInteger(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_MONEY.getMessage());
        }
    }

    private void checkDivideByThousand(String money) {
        if (Integer.parseInt(money) % PURCHASE_UNIT.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(NOT_PURCHASE_UNIT.getMessage());
        }
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
