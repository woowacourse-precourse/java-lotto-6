package lotto.util.exception;

import static lotto.model.constant.LottoConstant.LOTTO_NUMBER_LIMIT;
import static lotto.model.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.model.constant.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.util.constant.ValidatorStatus.DUPLICATE_BONUS_NUMBER_INPUT;
import static lotto.util.constant.ValidatorStatus.DUPLICATE_WINNING_NUMBER;
import static lotto.util.constant.ValidatorStatus.INVALID_NUMBER_RANGE;
import static lotto.util.constant.ValidatorStatus.INVALID_WINNING_NUMBER_COUNT;
import static lotto.util.constant.ValidatorStatus.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.util.constant.ValidatorStatus.NON_DIGIT;
import static lotto.util.constant.ValidatorStatus.NOT_DIVIDABLE;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;
import lotto.util.constant.ValidatorStatus;
import lotto.util.message.ErrorMessage;

public class ExceptionHandler {

    public final Map<ValidatorStatus, Consumer<ValidatorStatus>> validatorStatusMap;
    private static final ExceptionHandler instance = new ExceptionHandler();

    private ExceptionHandler() {
        validatorStatusMap = new EnumMap<>(ValidatorStatus.class);
        initValidatorStatusMap();
    }

    public static ExceptionHandler getInstance() {
        return instance;
    }

    private void initValidatorStatusMap() {
        validatorStatusMap.put(NON_DIGIT, this::invalidInputType);
        validatorStatusMap.put(NOT_DIVIDABLE, this::invalidInputUnit);
        validatorStatusMap.put(INVALID_WINNING_NUMBER_FORMAT, this::invalidWinningNumbersFormat);
        validatorStatusMap.put(INVALID_WINNING_NUMBER_COUNT, this::invalidWinningNumbersCount);
        validatorStatusMap.put(INVALID_NUMBER_RANGE, this::invalidWinningNumberRange);
        validatorStatusMap.put(DUPLICATE_WINNING_NUMBER, this::duplicateWinningNumbersFormat);
        validatorStatusMap.put(DUPLICATE_BONUS_NUMBER_INPUT, this::duplicateBonusNumber);
    }

    private void invalidInputType(ValidatorStatus validatorStatus) {
        ErrorMessage.NON_DIGIT.printError();
        throw new IllegalArgumentException();
    }

    private void invalidInputUnit(ValidatorStatus validatorStatus) {
        ErrorMessage.MONEY_NOT_DIVIDABLE.printError();
        throw new IllegalArgumentException();
    }

    private void duplicateWinningNumbersFormat(ValidatorStatus validatorStatus) {
        ErrorMessage.DUPLICATE_NUMBER_EXIST.printError();
        throw new IllegalArgumentException();
    }

    private void invalidWinningNumberRange(ValidatorStatus validatorStatus) {
        ErrorMessage.NUMBER_OUT_OF_RANGE.printError(MIN_LOTTO_NUMBER.getNumber(), MAX_LOTTO_NUMBER.getNumber());
        throw new IllegalArgumentException();
    }

    private void invalidWinningNumbersCount(ValidatorStatus validatorStatus) {
        ErrorMessage.INVALID_NUMBER_COUNT.printError(LOTTO_NUMBER_LIMIT.getNumber());
        throw new IllegalArgumentException();
    }

    private void invalidWinningNumbersFormat(ValidatorStatus validatorStatus) {
        ErrorMessage.INVALID_FORMAT.printError();
        throw new IllegalArgumentException();
    }

    private void duplicateBonusNumber(ValidatorStatus validatorStatus) {
        ErrorMessage.DUPLICATE_NUMBER_EXIST.printError();
        throw new IllegalArgumentException();
    }

}
