package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ExceptionMessage;
import lotto.constant.LottoGame;
import lotto.util.Calculator;
import lotto.util.InputValidator;

public class Game {
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
        return Calculator.divide(receiveAmount, LottoGame.LOTTO_PRICE);
    }

    private void validateAmount(String amount) {
        if(!InputValidator.isNumber(amount) || !Calculator.isMultiple(Integer.parseInt(amount), LottoGame.LOTTO_PRICE)){
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_NUMBER_ERROR.getMessage());
        }
    }

    private static void validWinningNubmers(List<String> enterWinningNumbers) {
        if(!InputValidator.isCorrectCount(enterWinningNumbers.size()) || InputValidator.isDuplicateNumberForString(enterWinningNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_VALID_ERROR.getMessage());
        }

        validWinningNubmer(enterWinningNumbers);
    }

    private static void validWinningNubmer(List<String> winningNumbers) {
        for (var winningNumber : winningNumbers) {
            if (!InputValidator.isNumber(winningNumber) || !InputValidator.isCorrectNumber(Integer.parseInt(winningNumber))) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_ERROR.getMessage());
            }
        }
    }

    private void validBonusNubmer(String bonusNumber) {
        if(!InputValidator.isNumber(bonusNumber)
                || !InputValidator.isCorrectNumber(Integer.parseInt(bonusNumber)) || winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_ERROR.getMessage());
        }
    }
}
