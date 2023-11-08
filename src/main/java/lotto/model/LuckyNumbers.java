package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.validator.Validation.*;

public class LuckyNumbers { // 입력받은 당첨 번호(String > List<String> > List<Integer>)

    private final String readNumbers;
    private List<String> tmpNumbers;
    private List<Integer> luckyNumbers = new ArrayList<>();

    public LuckyNumbers(String readNumbers) {
        validate(readNumbers);
        this.readNumbers = readNumbers;
    }

    private void validate(String readNumbers) {
        checkComma(readNumbers);
        checkNonSeparatedComma(readNumbers);
        tmpNumbers = checkDigitSeparatedComma(readNumbers);
    }

    public List<Integer> getNumbers() {
        changeTypeToNumbers();
        return luckyNumbers;
    }

    private void changeTypeToNumbers() {
        for (String number : tmpNumbers) {
            luckyNumbers.add(Integer.parseInt(number));
        }
    }

}