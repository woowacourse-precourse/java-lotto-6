package util;

import java.util.List;

public class Validate {
    public static void isValidPrice(int price) {
        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
    }

    public static void isValidNumber(List<Integer> numbers) {

    }
}
