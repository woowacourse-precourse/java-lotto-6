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
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자여야 합니다.");
        }
    }

    public List<Integer> convertToIntegerList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(num -> convertToInt(num))
                .collect(Collectors.toList());
    }

}
