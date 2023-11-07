package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;
    public static int MIN_NUM = 1;
    public static int MAX_NUM = 45;
    public static int SIZE_NUM = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public static List<Integer> makeLottos(String input) {
        commaValidate(input);
        return Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countContain(Lotto lotto) {
        return (int) numbers.stream().filter(lotto::containCheck).count();
    }

    public boolean containCheck(int number) {
        return numbers.contains(number);
    }

    public static void commaValidate(String input) {
        if (!input.contains(",")) {
            System.out.println("[ERROR] 쉼표(,)로 구분해 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void numValidate(List<Integer> input) {
//        if (input.size() != 6) {
//            System.out.println("[ERROR] 6개의 번호를 입력해주세요.");
//            throw new IllegalArgumentException();
//        }
        for (Integer number : input) {
            if (number > MAX_NUM || number < MIN_NUM) {
                System.out.println("[ERROR] " + MIN_NUM + "부터" + MAX_NUM + "사이의 숫자로 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
        if (input.stream().distinct().toList().size() != SIZE_NUM) {
            System.out.println(SIZE_NUM + "개의 숫자가 서로 중복되지 않게 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void BonusValidate(Integer input, List<Integer> winningNumber) {
        if (input > MAX_NUM || input < MIN_NUM) {
            System.out.println("[ERROR] " + MIN_NUM + "부터" + MAX_NUM + "사이의 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (winningNumber.contains(input)) {
            System.out.println("[ERROR] 당첨 번호와 중복되지 않게 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
