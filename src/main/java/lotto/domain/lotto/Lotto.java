package lotto.domain.lotto;

import java.util.*;

public class Lotto {
    // TODO: 11/6/23 상수 관리
    private static final String START_APPEND_STING = "[";
    private static final String MIDDLE_APPEND_COMMA_BLANK = ", ";
    private static final String END_APPEND_COMMA_BLANK = "]";
    private static final Integer SIZE_NUMBERS = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumbers(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

    // TODO: 11/6/23 상수 정리
    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있습니다.");
            }
        }
    }

    public List<Integer> organizeNumbers() {
        List<Integer> organizeLotto = new ArrayList<>(this.numbers);

        Collections.sort(organizeLotto);

        return organizeLotto;
    }

    public StringBuilder giveInformation() {
        int sizeNumbers = numbers.size();
        List<Integer> organizeNumbers = organizeNumbers();

        StringBuilder informationOfNumbers = getInformation(sizeNumbers, organizeNumbers);

        return informationOfNumbers;
    }

    public Integer getNumber(Integer index) {
        return numbers.get(index);
    }

    private StringBuilder getInformation(Integer sizeNumbers, List<Integer> organizeNumbers) {
        Integer num = 0;
        StringBuilder informationOfNumbers = new StringBuilder();

        appendStringBuild(informationOfNumbers, START_APPEND_STING);

        for (int i = 0; i < sizeNumbers; i++) {
            num = getNum(organizeNumbers, i);
            informationOfNumbers.append(num);

            if (isAppendCondition(sizeNumbers, i)) {
                appendStringBuild(informationOfNumbers, MIDDLE_APPEND_COMMA_BLANK);
            }
        }
        appendStringBuild(informationOfNumbers, END_APPEND_COMMA_BLANK);

        return informationOfNumbers;
    }

    private boolean isAppendCondition(Integer sizeNumbers, Integer i) {
        return i != (sizeNumbers - 1);
    }

    private void appendStringBuild(StringBuilder informationOfNumbers, String string) {
        informationOfNumbers.append(string);
    }

    private Integer getNum(List<Integer> organizeLotto, Integer i) {
        return organizeLotto.get(i);
    }
}
