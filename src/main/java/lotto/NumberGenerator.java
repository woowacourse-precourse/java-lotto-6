package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.configuration.Constants;

import java.util.ArrayList;
import java.util.List;

import static lotto.configuration.LottoConfig.*;

public class NumberGenerator {

    public int createOne(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.Error.MESSAGE + Constants.Error.CONVERT_NUMBER_ERROR);
        }
        return number;
    }

    public List<Integer> createRandomNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(START.getValue(), END.getValue(), COUNT.getValue()));
    }

}
