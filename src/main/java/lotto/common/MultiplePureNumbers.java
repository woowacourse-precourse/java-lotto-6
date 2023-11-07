package lotto.common;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.NonPureNumberException;

public class MultiplePureNumbers {

    private static final String SEPERATOR = ",";
    private final List<PureNumber> pureNumbers;

    public static MultiplePureNumbers wrap(String rawInput) throws NonPureNumberException {
        return new MultiplePureNumbers(rawInput);
    }

    public List<PureNumber> getPureNumbers() {
        return pureNumbers;
    }

    private MultiplePureNumbers(String rawInput) throws NonPureNumberException {
        pureNumbers = new ArrayList<>();
        for (String token : rawInput.split(SEPERATOR)) {
            pureNumbers.add(PureNumber.wrap(token.trim()));
        }
    }
}
