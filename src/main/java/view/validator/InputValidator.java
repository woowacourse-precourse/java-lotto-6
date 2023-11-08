package view.validator;

import enums.ErrorMessageEnums;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String NAN_MESSAGE = ErrorMessageEnums.NAN_ERROR.toString();
    private static final String NOT_THOUSAND = ErrorMessageEnums.NOT_THOUSAND.toString();
    private static final int UNIT = 1000;

    public static int verifyNumber(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NAN_MESSAGE);
        }
    }

    public static void verifyThousand(String s) {
        int i = Integer.parseInt(s);
        System.out.println(i);
        if (i % UNIT != 0) {
            throw new IllegalArgumentException(NOT_THOUSAND);
        }
    }

    public static List<Integer> verifyWinLotto(String s) {
        return Arrays.stream(s.split(DELIMITER))
                .mapToInt(InputValidator::verifyNumber)
                .boxed()
                .collect(Collectors.toList());
    }


}
