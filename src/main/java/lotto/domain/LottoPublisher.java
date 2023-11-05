package lotto.domain;

import static lotto.constant.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.PURCHASE_UNIT;
import static lotto.constant.LottoNumber.WINNING_NUMBER_LENGTH;
import static lotto.constant.LottoNumber.ZERO;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_MONEY;
import static lotto.constant.message.ErrorMessage.NOT_PURCHASE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPublisher {
    private List<Lotto> userLottos;

    public LottoPublisher(String money) {
        getLottosInformation(validatePurchasePrice(money));
    }

    public LottoPublisher getLottosInformation(int money) {
        this.userLottos = createLottos(money);
        return this;
    }

    private List<Lotto> createLottos(int money) {
        return IntStream.range(ZERO.getNumber(), countLottoAmount(money))
                .mapToObj(index -> new Lotto(generateRandomLottoNumber()))
                .collect(Collectors.toList());
    }

    private int countLottoAmount(int money) {
        return money / PURCHASE_UNIT.getNumber();
    }

    private int validatePurchasePrice(String money) {
        checkValidInteger(money);
        checkDivideByThousand(money);

        return Integer.parseInt(money);
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

    private List<Integer> generateRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER.getNumber(), MAXIMUM_LOTTO_NUMBER.getNumber(), WINNING_NUMBER_LENGTH.getNumber());
    }
}
