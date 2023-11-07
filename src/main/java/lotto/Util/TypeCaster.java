package lotto.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeCaster {
    public static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> output = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+"); // 정수 패턴 정의

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String numberStr = matcher.group(); // 일치하는 숫자 문자열 가져오기
            int number = Integer.parseInt(numberStr);
            output.add(number);
        }

        return output;
    }
}
