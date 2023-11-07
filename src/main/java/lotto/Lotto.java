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
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
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
        if (numbersString.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

        for (String number : numbersString) {
            try {
                int num = Integer.parseInt(number.trim());
                validateNumberRange(num);
                validateUniqueNumber(numbers, num);
                numbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닌 값이 입력되었습니다.");
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 다시 입력하세요.");
            }
        }
        return new Lotto(numbers);
    }
    
    public static void validateNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
        }
    }
    
    public static void validateUniqueNumber(List<Integer> numbers, int num) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 입력되었습니다.");
        }
    }
    
}

