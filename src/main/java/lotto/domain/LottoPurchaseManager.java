package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.utils.LottoGenerator;
import lotto.validator.LottoNumberValidator;

public class LottoPurchaseManager {
    private static final int LOTTO_PRICE = 1000;
    private final long inputMoney;
    private Lottos lottos;

    public LottoPurchaseManager(long inputMoney) {
        this.inputMoney = inputMoney;
        lottos = createLottos();
    }

    public static LottoPurchaseManager create(String inputMoneyFromUser) {
        long money = LottoNumberValidator.validateNumeric(inputMoneyFromUser);
        validatePurchaseAmount(money);
        return new LottoPurchaseManager(money);
    }

    private Lottos createLottos() {
        long quantity = calculateLottoQuantity();
        return LottoGenerator.generateLottos(quantity);
    }

    public long getInputMoney() {
        return inputMoney;
    }

    public Lottos getLottos() {
        return lottos;
    }

    private long calculateLottoQuantity() {
        return inputMoney / LOTTO_PRICE;
    }

    private static void validatePurchaseAmount(long money) {
        validatePositive(money);
        validateDividedByLottoPrice(money);
    }

    private static void validatePositive(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    private static void validateDividedByLottoPrice(long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
