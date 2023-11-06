package lotto.domain.lotto;

import java.util.*;

public class Lotto {
    private static final String START_APPEND_STING = "[";
    private static final String MIDDLE_APPEND_COMMA_BLANK = ", ";
    private static final String END_APPEND_COMMA_BLANK = ", ";

    // TODO: 추가 기능 구현
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumbers(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

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
        int num = 0;
        List<Integer> organizeNumbers = organizeNumbers();

        StringBuilder informationOfNumbers = getInformation(sizeNumbers, organizeNumbers);

        return informationOfNumbers;
    }

    private StringBuilder getInformation(int sizeNumbers, List<Integer> organizeNumbers) {
        int num;
        StringBuilder informationOfNumbers = new StringBuilder();

        appendStringBuild(informationOfNumbers, START_APPEND_STING);

        for (int i = 0; i < sizeNumbers; i++) {
            num = getNum(organizeNumbers, i);
            informationOfNumbers.append(num);

            if (i != sizeNumbers - 1) {
                appendStringBuild(informationOfNumbers, MIDDLE_APPEND_COMMA_BLANK);
            }
        }
        appendStringBuild(informationOfNumbers, END_APPEND_COMMA_BLANK);

        return informationOfNumbers;
    }

    private void appendStringBuild(StringBuilder informationOfNumbers, String string) {
        informationOfNumbers.append(string);
    }

    public Integer getNumber(Integer index) {
        return numbers.get(index);
    }

    private Integer getNum(List<Integer> organizeLotto, int i) {
        return organizeLotto.get(i);
    }
}
