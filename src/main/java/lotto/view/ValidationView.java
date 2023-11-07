package lotto.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationView {
    private static final int LOTTO_PRICE = 1000;
    public static int isNumber(String input) throws IllegalArgumentException{
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }
    }
    public static void isDivided(String input){
        int money = Integer.parseInt(input);
        if ((money % LOTTO_PRICE) != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 구매할 수 있습니다.");
        }
    }

    public static void checkConsecutiveCommas(String[] arr) {
        for (String name : arr) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] ','가 중복되었습니다.");
            }
        }
    }

    public static void checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    public static void checkInRange(List<Integer> numbers){
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }
}
