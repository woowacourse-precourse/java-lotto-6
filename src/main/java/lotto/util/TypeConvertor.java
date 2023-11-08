package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Validator.*;

public class TypeConvertor {
    public static List<Integer> stringToIntegerList(String string) {

        List<Integer> lottoNumberList = null;
        try {
            lottoNumberList = Arrays.stream(string.strip().split(","))
                    .map(a -> a.strip())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호에 정수가 아닌 값이 들어있습니다");
        }
        validateLottoNumbers(lottoNumberList);

        return lottoNumberList;
    }

    public static Integer stringToInteger(String string) {

        validateStringMoney(string);

        Integer money = Integer.getInteger(string);

        validateIntegerMoney(money);
        return money;
    }
}