package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.CustomerConst.IS_NOT_NUMBER;

public class Converter {


    public static List<Integer> to(String numbers) {
        List<Integer> numberInteger = new ArrayList<>();
        String[] split = numbers.split(",");
        for (String now : split) {
            try {
                Integer nowNumber = Integer.parseInt(now);
                numberInteger.add(nowNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(IS_NOT_NUMBER);
            }
        }
        return numberInteger;
    }

    public static String from(List<Integer> numbers) {

        return numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

}
