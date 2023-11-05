package lotto.common.validate;

import java.util.List;
import lotto.common.constants.ErrorMessage;

public class Validate {
    public void buyPriceValidate(String inputPrice) {
        inBlank(inputPrice);
        notNumber(inputPrice);
        underThousand(inputPrice);
        notThousandUnit(inputPrice);
    }

    public void sixHitLottoNumberValidate(List<String> inputLottoNumbers) {
        emptySpace(inputLottoNumbers);
    }

    private void inBlank(String inputString) {
        if (inputString.isBlank()) {
            System.out.println(ErrorMessage.ERROR_BLANK.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void notNumber(String inputString) {
        if (!inputString.matches("^[0-9]*$")) {
            System.out.println(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void underThousand(String inputString) {
        if (Integer.parseInt(inputString) < 1000) {
            System.out.println(ErrorMessage.ERROR_UNDER_THOUSAND.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void notThousandUnit(String inputString) {
        if (Integer.parseInt(inputString) % 1000 != 0) {
            System.out.println(ErrorMessage.ERROR_NOT_THOUSAND_UNITS.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void emptySpace(List<String> numbers) {
        if (!numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void overInput(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void outOfNumberRange(int inputNumber) {
        if (inputNumber < 1 || inputNumber > 45) {
            System.out.println(ErrorMessage.ERROR_NOT_LOTTO_RANGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void overlapInput(List<String> numbers) {

    }

    private void beforeOverlapInput(List<String> numbers) {

    }
}
