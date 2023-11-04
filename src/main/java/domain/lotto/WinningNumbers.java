package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private List<WinningNumber> winningNormalNumbers;
    private WinningNumber bonusNumber;

    public WinningNumbers() {
        this.winningNormalNumbers = new ArrayList<>();
    }

    public void generateWinningNormalNumbers(String inputNumbers) {
        List<Integer> numbers = NumberConverter.convertToWinningNumbers(inputNumbers);
        for (Integer number : numbers) {
            WinningNumber winningNumber = new WinningNumber(number);
            validateDuplicateNumber(winningNumber);
            winningNormalNumbers.add(winningNumber);
        }
        validateNumberOfWinningNormalNumberIsSix();
    }

    public void generateBonusNumber(String inputNumber) {
        Integer number = NumberConverter.convertToWinningNumber(inputNumber);
        bonusNumber = new WinningNumber(number);
        validateDuplicateNumber(bonusNumber);
    }



    private void validateDuplicateNumber(WinningNumber winningNumber) {
        for (WinningNumber winningNormalNumber : winningNormalNumbers) {
            if(winningNormalNumber.equals(winningNumber)) {
                throw new IllegalArgumentException("중복 x");
            }
        }
    }

    private void validateNumberOfWinningNormalNumberIsSix() {
        if(winningNormalNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자 개수는 6개");
        }
    }

    public List<WinningNumber> getWinningNormalNumbers() {
        return winningNormalNumbers;
    }

    public WinningNumber getBonusNumber() {
        return bonusNumber;
    }
}
