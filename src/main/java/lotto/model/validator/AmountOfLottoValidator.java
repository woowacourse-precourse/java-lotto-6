package lotto.model.validator;

public interface AmountOfLottoValidator {
    void checkType(String amountOfLotto);

    void checkAmountWithinLottoPriceRange(long amountOfLotto);

    void checkDivideByLottoPrice(long amountOfLotto);
}
