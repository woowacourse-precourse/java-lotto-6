package lotto.domain;

import lotto.constant.Message;

import java.util.List;

public class WinningNumbers {

    private List<Integer> numbers;
    private int bonusNumber;

    public void saveWinningNumbers(List<Integer> numbers) {

        validateSize(numbers);
        validateRange(numbers);
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

        int cnt = (int) numbers.stream()
                .filter(e -> e < 1 && e > 45)
                .count();

        if(cnt != 0) {

            throw new IllegalArgumentException(Message.WINNING_NUMBERS_OVER_RANGE_ERROR_MESSAGE.name());
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
