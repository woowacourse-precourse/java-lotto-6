package lotto;

import static lotto.constants.Message.COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class Handling {

    public static List<Integer> parseNumbers(List<String> lotto) {
        List<Integer> inputNumber = new ArrayList<>();

        for (String lottoNumber : lotto) {
            Lotto.checkLottoNumber(lottoNumber);
            inputNumber.add(Integer.parseInt(lottoNumber));
        }

        return inputNumber;
    }

    public static List<String> split(String lotto) {
        Validator.checkComma(lotto);
        return Arrays.asList(lotto.split(COMMA.getMessage()));
    }
}
