package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력되는 숫자는 6자리 여야 합니다.");
        }
        changeIntegerToString(numbers);
    }

    private void duplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다.");
        }
    }

    private void changeIntegerToString(List<Integer> numbers) {
        String numberString = numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(","));

        checkLottoStringInput(numberString);
    }

    private void checkLottoStringInput(String numberString) {
        checkChar(parseLottoNumber(numberString));
        checkEachSpace(parseLottoNumber(numberString));
    }

    private void checkChar(List<String> userlottoList) {
        for (int i = 0; i < userlottoList.size(); i++)
            checkEachChar(userlottoList.get(i));
    }

    private void checkEachChar(String each_num) {
        int check_num = Integer.parseInt(each_num);
        if(check_num > 45 || check_num < 0)
            throw new IllegalArgumentException("[ERROR] 값의 범위는 1부터 45까지 입니다.");
    }

    public List<String> parseLottoNumber(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    private void checkEachSpace(List<String> userlottoList) {
        for (String check_space : userlottoList)
            checkEachCharSpace(check_space);
    }

    private void checkEachCharSpace(String check_space) {
        if(check_space.contains(" "))
            throw new IllegalArgumentException("[ERROR] 빈 곳이 존재합니다.");
    }

    // TODO: 추가 기능 구현
}
