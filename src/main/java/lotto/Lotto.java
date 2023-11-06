package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    static public List<Integer> win_range(String[] input) {
        if (input.length != 6) throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        for (int i = 0; i < input.length; i++) {
            range(input[i]);
            if (Integer.parseInt(input[i]) < 1 || Integer.parseInt(input[i]) > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        Integer[] intinput = Stream.of(input).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        List<Integer> winnum = Arrays.asList(intinput);
        return winnum;
    }

    static public int bonus_range(int number, List<Integer> win) {
        if (win.contains(number)) throw new IllegalArgumentException("[ERROR] 당첨 번호와 다른 번호여야 합니다.");
        return number;
    }

    static public int range(String number) {
        if (number.length() < 1 || number.length() > 2) throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
        for (int i = 0; i < number.length(); i++)
            if (number.charAt(i) < '0' || number.charAt(i) > '9') throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        int intnum = Integer.parseInt(number);
        if (intnum < 1 || intnum > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        return intnum;
    }
}
