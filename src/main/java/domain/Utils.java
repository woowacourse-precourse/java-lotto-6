package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> generateRandomNumbers(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

    // 입력 받은 문자열을 숫자 배열로 변환
    public static int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    // 입력 받은 문자열을 숫자 리스트로 변환
    public static List<Integer> stringToIntegerList(String string) {
        Validation.validateListParseInt(Arrays.asList(string.split(",")));
        return Arrays.stream(stringToIntArray(string))
                .boxed()
                .collect(Collectors.toList());
    }

    // 입력 받은 문자를 숫자로 변환 (보너스 번호 입력)
    public static int stringToInteger(String string) {
        Validation.validateParseInt(string);
        return Integer.parseInt(string);
    }

}
