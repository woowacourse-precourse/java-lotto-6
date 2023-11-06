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

    public Function<String, Object> getCreateFunction() {
        return createFunction;
    }

    public Function<String, Object> getCreateFunction(WinningNumbers winningNumbers) {
        return inputValue -> BonusNumber.create(inputValue, winningNumbers);
        //확장 고려) winningNumbers가 필요한 객체가 추가된다면 조건을 걸어 해당 객체를 create하도록 수정.
    }
}
