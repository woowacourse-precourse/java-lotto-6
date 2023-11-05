package lotto;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
            }
            if (numbers.lastIndexOf(number) != numbers.indexOf(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
            }
        }
    }

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }   

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public void add(Integer number) {
        numbers.add(number);
    }

    public static Lotto createLottoFromUserInput() {
        String input = Console.readLine();
        String[] numbersString = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersString) {
            int num = Integer.parseInt(number.trim());
            numbers.add(num);
        }
        return new Lotto(numbers);
    }
}

