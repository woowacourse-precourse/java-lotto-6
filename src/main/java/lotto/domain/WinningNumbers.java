package lotto.domain;

import lotto.constant.Message;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private List<Integer> numbers;
    private int bonusNumber;

    public void saveWinningNumbers(List<Integer> numbers) {

        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    public void saveBonusNumber(int bonusNumber){

        checkDuplicateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> numbers) {

        if (numbers.size() != 6){

            throw new IllegalArgumentException(Message.WINNING_NUMBERS_SIZE_ERROR_MESSAGE.name());
        }
    }

    private void validateRange(List<Integer> numbers) {

        for(int number : numbers){

            if(number < 1 || number > 45) {

                throw new IllegalArgumentException(Message.WINNING_NUMBERS_OVER_RANGE_ERROR_MESSAGE.name());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {

        Set<Integer> set = new HashSet<>(numbers);

        if(set.size() != 6) {

            throw new IllegalArgumentException(Message.WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE.name());
        }
    }

    private void checkDuplicateBonusNumber(int bonusNumber){

        List<Integer> numbers = getNumbers();

        for(int num : numbers){

            if(num == bonusNumber){

                throw new IllegalArgumentException(Message.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE.name());
            }
        }
    }

    public List<Integer> getNumbers(){

        return numbers;
    }

    public int getBonusNumber(){

        return bonusNumber;
    }
}
