package lotto.Exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoException {

    final int lottoLength = 6;

    public int checkPriceException(String initialPrice) {
        int price;

        try {
            price = Integer.parseInt(initialPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }

        return price;
    }

    public List<Integer> checkSelectedNumber(String initialNumbers) {
        List<Integer> numbers = checkInt(initialNumbers);
        checkPositive(numbers);
        checkLenght(numbers);

        return numbers;
    }

    public List<Integer> checkInt(String initialNumbers) {
        try {
            List<Integer> numbers = Arrays.stream(initialNumbers.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    public void checkPositive(List<Integer> numbers) {
        for(int number : numbers) {
            if (number < 1 && number > 45) {
                throw new IllegalArgumentException("1부터 45까지의 숫자를 입력해주세요.");
            }
        }
    }

    public void checkLenght(List<Integer> numbers) {
        if (numbers.size() != lottoLength) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }
    }

}
