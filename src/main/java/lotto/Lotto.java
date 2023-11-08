package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    // 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        redundancyCheck(numbers);
        rangeValidationForNumbers(numbers);
        this.numbers = numbers;
    }

    // 6자리인지 검증
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 숫자를 6개 입력하세요");
            throw new IllegalArgumentException();
        }
    }

    // 중복된 숫자 인지 검증
    private void redundancyCheck(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            System.out.println("[ERROR] 같은 숫자를 2개 이상 입력할 수 없습니다");
            throw new IllegalArgumentException();
        }
    }

    // 각 번호가 1~45 사이인지 검증
    private void rangeValidationForNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            Service.rangeValidation(number);
        }
    }

    // 입력받은 문구를 리스트로 변환
    public static List<Integer> convertStringToIntegerList(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String number : inputNumbers.split(",")) {
                numbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력하세요");
            numbers.clear();
            throw new IllegalArgumentException();
        }
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
