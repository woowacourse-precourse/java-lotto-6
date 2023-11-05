package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.code.ExceptionMessage;
import lotto.util.Calculator;
import lotto.util.InputValidator;

public class Game {
    private final static int LOTTO_PRICE = 1000;
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    public static int receiveAmount;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Game(String receiveAmount) {
        validateAmount(receiveAmount);
        this.receiveAmount = Integer.parseInt(receiveAmount);
    }

    public Game setWinningNumbers(String enterNumbers) {
        List<String> numbers = List.of(enterNumbers.split(","));
        validWinningNubmers(numbers);

        winningNumbers = numbers.stream()
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());

        return this;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Game setBonusNumber(String enterNumber){
        validBonusNubmer(enterNumber);
        bonusNumber = Integer.parseInt(enterNumber);
        return this;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


    public int lottoPurchaseCount(){
        return Calculator.divide(receiveAmount, LOTTO_PRICE);
    }

    private void validateAmount(String amount) {
        if(!InputValidator.isNumber(amount) || !InputValidator.isMultiple(Integer.parseInt(amount), LOTTO_PRICE)){
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_NUMBER_ERROR.getMessage());
        }
    }

    private static void validWinningNubmers(List<String> enterWinningNumbers) {

        if(!isCorrectCount(enterWinningNumbers.size()) || isDuplicateNumber(enterWinningNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_VALID_ERROR.getMessage());
        }

        validWinningNubmer(enterWinningNumbers);
    }

    private static void validWinningNubmer(List<String> winningNumbers) {
        for (var winningNumber : winningNumbers) {
            if (!InputValidator.isNumber(winningNumber) || !isCorrectNumber(Integer.parseInt(winningNumber))) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_ERROR.getMessage());
            }
        }
    }

    private void validBonusNubmer(String bonusNumber) {
        if(!InputValidator.isNumber(bonusNumber)
                || !isCorrectNumber(Integer.parseInt(bonusNumber)) || winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_ERROR.getMessage());
        }
    }
    private static boolean isCorrectCount(int length) {
        return length == LOTTO_NUMBER_COUNT;
    }

    private static boolean isCorrectNumber(int winningNumber) {
        return winningNumber >= MIN_NUMBER && winningNumber <= MAX_NUMBER;
    }

    private static boolean isDuplicateNumber(List<String> winningNumbers) {
        Set<String> deduplicateNumbers = new HashSet<>(winningNumbers);
        return winningNumbers.size() != deduplicateNumbers.size();
    }
}
