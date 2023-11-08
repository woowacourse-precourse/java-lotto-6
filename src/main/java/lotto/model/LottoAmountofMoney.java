package lotto.model;

import static lotto.constant.ErrorMessage.ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.INPUTCONTAINNOTNUMBER;
import static lotto.constant.ErrorMessage.INPUTVALUEPOSITIVE;
import static lotto.constant.ErrorMessage.MONEYISZERO;
import static lotto.constant.ErrorMessage.NOTDIVISIONBYLOTTOPRICE;
import static lotto.constant.Format.REGEX_DIGIT;
import static lotto.constant.Numbers.LOTTOPRICE;

import java.util.regex.Pattern;

public class LottoAmountofMoney {
    private final Integer lottoAmountofMoney;

    public LottoAmountofMoney(String lottoAmountofMoney) throws IllegalArgumentException {
        validate(lottoAmountofMoney);
        this.lottoAmountofMoney = Integer.parseInt(lottoAmountofMoney); // 1.service 로 해야하나 model로 해야하나
    }

    public Integer getLottoAmountofMoney() {
        return lottoAmountofMoney;
    }

    private void validate(String lottoAmountofMoney) {
        validateLottoMoneyIsNumber(lottoAmountofMoney);
        validateLottoMoneyIsPositive(lottoAmountofMoney);
        validateLottoMoneyDivideBy(lottoAmountofMoney);
        validateLottoMoneyIsNotZero(lottoAmountofMoney);
    }

    private void validateLottoMoneyIsNumber(String lottoAmountofMoney) {
        if (!Pattern.matches(REGEX_DIGIT.getValue(), lottoAmountofMoney)) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + INPUTCONTAINNOTNUMBER.getValue());
        }
    }

    private void validateLottoMoneyIsPositive(String lottoAmountofMoney) {
        if (Integer.parseInt(lottoAmountofMoney) < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + INPUTVALUEPOSITIVE);
        }
    }

    private void validateLottoMoneyDivideBy(String lottoAmountofMoney) {
        int money = Integer.parseInt(lottoAmountofMoney);
        if (money % LOTTOPRICE.getIntValue() != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + NOTDIVISIONBYLOTTOPRICE.getValue());
        }
    }

    private void validateLottoMoneyIsNotZero(String lottoAmountofMoney) {
        int money = Integer.parseInt(lottoAmountofMoney);
        if (money == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + MONEYISZERO.getValue());
        }
    }
}
