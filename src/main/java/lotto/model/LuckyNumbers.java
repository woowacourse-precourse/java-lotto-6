package lotto.model;

import java.util.List;

import static lotto.validator.Validation.*;

public class LuckyNumbers { // 입력받은 당첨 번호(String > List<String> > List<Integer>)

    private final String readNumbers;
    private List<String> tmpNumbers;

    public LuckyNumbers(String readNumbers) {
        validate(readNumbers);
        this.readNumbers = readNumbers;
    }

    private void validate(String readNumbers) {
        checkComma(readNumbers);
        checkNonSeparatedComma(readNumbers);
        tmpNumbers = checkDigitSeparatedComma(readNumbers);
    }

}
