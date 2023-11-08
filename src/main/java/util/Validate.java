package util;

import java.util.List;

public class Validate {
    public static void isValidInput(String input) {
        try {
            int price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
    public static void isValidPrice(int price) {
        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
    }

    public static void isValidLotto(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw  new IllegalArgumentException("[ERROR] 로또는 총 6개의 숫자여야 합니다.");
        for (int num : numbers) {
            if (num < 1 || num > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 값은 입력하실 수 없습니다.");
        }
    }

    public static void isValidBonus(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
