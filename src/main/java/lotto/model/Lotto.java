package lotto.model;

import static lotto.model.LottoRule.validateRange;
import static lotto.util.Division.COMMA;
import static lotto.util.Utils.conversionInt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberDuplicateException;
import lotto.exception.LottoNumberSizeException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumericRange(numbers);

        this.numbers = numbers;
    }

    public Lotto(String inNumbers) {
        List<Integer> numbers = conversionCommaNumber(inNumbers);
        validate(numbers);
        validateDuplicate(numbers);
        validateNumericRange(numbers);

        this.numbers = numbers;
    }

    /**
     * Comma를 기준으로 숫자를 나누어 반환
     *
     * @param input ','를 포함한 숫자
     * @return List<Integer>
     */
    private List<Integer> conversionCommaNumber(String input) {
        String[] splitText = input.split(COMMA);
        List<Integer> numbers = new ArrayList<>();

        for (String number :
                splitText) {
            numbers.add(conversionInt(number));
        }

        return numbers;
    }

    /**
     * 로또 번호 길이에 대한 검증
     *
     * @param numbers
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoNumberSizeException();
        }
    }

    /**
     * 중복된 숫자가 있는지 검사한다.
     *
     * @param numbers 검사할 Integer List
     */
    private void validateDuplicate(List<Integer> numbers) {
        // 중복을 허용하지 않는 Set 자료구조를 사용한다.
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) { // 크기를 비교한다.
            throw new LottoNumberDuplicateException();
        }
    }

    /**
     * 숫자들이 1 ~ 45까지의 범위를 가지는지 검증한다.
     *
     * @param numbers
     */
    private void validateNumericRange(List<Integer> numbers) {
        for (int num :
                numbers) {
            validateRange(num);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
