package lotto.view.inputview;

import java.util.function.Function;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.lotto.WinningNumbers;

public enum InputValueType {
    PURCHASE_PRICE("구입금액을 입력해 주세요.", PurchasePrice::create),
    WINNING_NUMBERS("\n당첨 번호를 입력해 주세요.", WinningNumbers::create),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요.", null);

    private final String message;
    private final Function<String, Object> createFunction;

    InputValueType(String message, Function<String, Object> createFunction) {
        this.message = message;
        this.createFunction = createFunction;
    }

    public String getMessage() {
        return message;
    }

    public Function<String, Object> getCreateFunction(Object requiredObject) {
        if (this.equals(BONUS_NUMBER)) {
            return inputValue -> BonusNumber.create(inputValue, (WinningNumbers) requiredObject);
        }

        return createFunction;
    }
}
