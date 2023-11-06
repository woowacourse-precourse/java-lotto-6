package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.message.ErrorMessage;

import java.util.Arrays;
import java.util.stream.Stream;

public class Utils {
    public static int stringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.NUMBER_FORMAT_ERROR);
            return stringToInt(Console.readLine());
        }
    }

    public static int[] stringToIntArray(String str) {
        try {
            return Arrays.stream(str.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.NUMBER_FORMAT_ERROR);
            return stringToIntArray(Console.readLine());
        }
    }
}
