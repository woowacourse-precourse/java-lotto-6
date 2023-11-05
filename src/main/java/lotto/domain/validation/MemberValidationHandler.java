package lotto.domain.validation;

import static lotto.domain.constant.LottoConstant.LOTTO_PURCHASE_UNIT;
import static lotto.domain.constant.LottoConstant.MAX_LOTTO_PURCHASE_COUNT;
import static lotto.domain.constant.LottoConstant.MIN_LOTTO_PURCHASE_COUNT;
import static lotto.domain.validation.DefaultValidationMessage.*;

import java.util.NoSuchElementException;
import lotto.util.StringUtils;

public class MemberValidationHandler {
    public static final String INVALID_LOTTO_PURCHASE_UNIT_MESSAGE = ERROR.getMessage() + " 1,000원 단위로 구입금액을 입력해주세요.";
    public static final String INVALID_RANGE_LOTTO_PURCHASE_COUNT_MESSAGE = ERROR.getMessage() + " 최소 1장 최대 100장까지 구매 가능합니다.";
    public static final String INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE = ERROR.getMessage() + " 구입금액에 숫자가 아닌 문자가 있습니다.";
    public static final String INVALID_LOTTO_PURCHASE_AMOUNT_EMPTY_MESSAGE = ERROR.getMessage() + " 구입금액을 입력해주세요.";

    private MemberValidationHandler() {
    }

    public static void validationNumeric(String lottoPurchaseAmount) {
        if(!isNumeric(lottoPurchaseAmount)) {
            throw new NoSuchElementException(INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public static void validationRangeLottoCount(int lottoPurchaseAmount) {
        if(!isValidMaxLottoCount(lottoPurchaseAmount) || !isValidMinLottoCount(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(INVALID_RANGE_LOTTO_PURCHASE_COUNT_MESSAGE);
        }
    }

    public static void validationLottoPurchaseAmountUnit(int lottoPurchaseAmount) {
        if(isLottoPurchaseAmountZero(lottoPurchaseAmount) || !isValidLottoPurchaseAmountUnit(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_UNIT_MESSAGE);
        }
    }

    public static void validationHasText(String lottoPurchaseAmount) {
        if (!StringUtils.hasText(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_AMOUNT_EMPTY_MESSAGE);
        }
    }

    private static boolean isNumeric(String bonsNumber) {
        return bonsNumber.chars().allMatch(Character::isDigit);
    }

    private static boolean isValidLottoPurchaseAmountUnit(int lottoPurchaseAmount) {
        return Math.floorMod(lottoPurchaseAmount, LOTTO_PURCHASE_UNIT) == Number.ZERO.getNumberToInteger();
    }

    private static boolean isLottoPurchaseAmountZero(int lottoPurchaseAmount) {
        return lottoPurchaseAmount == Number.ZERO.getNumberToInteger();
    }

    private static boolean isValidMaxLottoCount(int lottoPurchaseAmount) {
        return getLottoPurchaseCount(lottoPurchaseAmount) <= MAX_LOTTO_PURCHASE_COUNT;
    }

    private static boolean isValidMinLottoCount(int lottoPurchaseAmount) {
        return getLottoPurchaseCount(lottoPurchaseAmount) >= MIN_LOTTO_PURCHASE_COUNT;
    }

    private static int getLottoPurchaseCount(int lottoPurchaseAmount){
        return Math.floorDiv(lottoPurchaseAmount, LOTTO_PURCHASE_UNIT);
    }
}
