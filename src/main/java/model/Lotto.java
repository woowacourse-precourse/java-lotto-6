package model;

import view.PrintError;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private final PrintError printError = new PrintError();

    // 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = sortNumbers(numbers);
    }

    // 번호가 6개인지 검증
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            printError.numberSizeMessage();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    // 번호 반환
    public List<Integer> getNumbers() {
        return numbers;
    }

    // 로또 번호가 중복인지 검증한다.
    public void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Object> duplicatedChecker = new HashSet<>();
        for(Integer number : numbers) {
            duplicatedChecker.add(number);
        }
        if(duplicatedChecker.size() != 6) {
            printError.numberDuplicatedMessage();
            throw new IllegalArgumentException();
        }
    }


    // 숫자의 범위가 1~45인지 검증한다.
    public void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                printError.numberRangeMessage();
                throw new IllegalArgumentException();
            }
        }
    }

    // 번호를 오름차순으로 정렬한다.
    public List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }


    // 로또 번호를 출력한다.
    public void printLotto() {
        System.out.println(numbers);
    }
}
