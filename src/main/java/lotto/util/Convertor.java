package lotto.util;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {

    private volatile static Convertor INSTANCE;

    private Convertor() {

    }

    public static Convertor getInstance() {
        if (INSTANCE == null) {
            synchronized (Convertor.class) {
                generateInstance();
            }
        }

        return INSTANCE;
    }

    private static void generateInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Convertor();
        }
    }

    public int convertToInt(String number) {
        number = number.replace(" ", "");
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_WRONG_FORMAT);
        }
    }

    public List<Integer> convertToIntegerList(String numbers) {
        numbers = numbers.replace(" ", "");
        return Arrays.stream(numbers.split(","))
                .map(num -> convertToInt(num))
                .collect(Collectors.toList());
    }

}
