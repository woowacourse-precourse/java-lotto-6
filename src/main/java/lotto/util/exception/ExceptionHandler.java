package lotto.util.exception;

import static lotto.util.constant.ValidatorStatus.DUPLICATE_WINNING_NUMBER;
import static lotto.util.constant.ValidatorStatus.INVALID_BONUS_NUMBER_INPUT;
import static lotto.util.constant.ValidatorStatus.INVALID_NUMBER_RANGE;
import static lotto.util.constant.ValidatorStatus.INVALID_WINNING_NUMBER_COUNT;
import static lotto.util.constant.ValidatorStatus.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.util.constant.ValidatorStatus.NON_DIGIT;
import static lotto.util.constant.ValidatorStatus.NOT_DIVIDABLE;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;
import lotto.util.constant.ValidatorStatus;

public class ExceptionHandler {

    public final Map<ValidatorStatus, Consumer<ValidatorStatus>> validatorStatusMap;

    public ExceptionHandler() {
        validatorStatusMap = new EnumMap<>(ValidatorStatus.class);
        initValidatorStatusMap();
    }

    private void initValidatorStatusMap() {
        validatorStatusMap.put(NON_DIGIT, this::invalidInputType);
        validatorStatusMap.put(NOT_DIVIDABLE, this::invalidInputUnit);
        validatorStatusMap.put(INVALID_WINNING_NUMBER_FORMAT, this::invalidWinningNumbersFormat);
        validatorStatusMap.put(INVALID_WINNING_NUMBER_COUNT, this::invalidWinningNumbersCount);
        validatorStatusMap.put(INVALID_NUMBER_RANGE, this::invalidWinningNumberRange);
        validatorStatusMap.put(DUPLICATE_WINNING_NUMBER, this::isNotUniqueWinningNumbersFormat);
        validatorStatusMap.put(INVALID_BONUS_NUMBER_INPUT, this::invalidBonusNumber);
    }

    private void invalidInputType(ValidatorStatus validatorStatus) {
        throw new IllegalArgumentException("숫자가 아닙니다.");
    }

    private void invalidInputUnit(ValidatorStatus validatorStatus) {
        throw new IllegalArgumentException("1000으로 나누어 떨어지지 않습니다.");
    }

    private void isNotUniqueWinningNumbersFormat(ValidatorStatus validatorStatus) {
        throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
    }

    private void invalidWinningNumberRange(ValidatorStatus validatorStatus) {
        throw new IllegalArgumentException("유효하지 않은 범위입니다.");
    }

    private void invalidWinningNumbersCount(ValidatorStatus validatorStatus) {
        throw new IllegalArgumentException("숫자의 갯수가 유효하지 않습니다.");
    }

    private void invalidWinningNumbersFormat(ValidatorStatus validatorStatus) {
        throw new IllegalArgumentException(", 를 이용해서 숫자를 나눠주세요.");
    }

    private void invalidBonusNumber(ValidatorStatus validatorStatus) {
        throw new IllegalArgumentException("유효하지 않은 보너스 넘버입니다.");
    }

}
