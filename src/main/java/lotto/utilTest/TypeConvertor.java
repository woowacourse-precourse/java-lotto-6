package lotto.utilTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utilTest.Validator.*;

public class TypeConvertor {
    public static List<Integer> stringToIntegerList(String string) {
        List<Integer> lottoNumbers = null;
        try {
            lottoNumbers = Arrays.stream(string.strip().split(","))
                    .map(a -> a.strip())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호에 정수가 아닌 값이 들어있습니다");
        }
        validateLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    public static Integer stringToInteger(String input) {
        validateStringMoney(input);

        Integer money = Integer.parseInt(input);
        validateIntegerMoney(money);
        return money;
    }
}