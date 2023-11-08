package lotto.domain.number;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.utils.StringUtils.convertToIntegerList;
import static lotto.utils.StringUtils.splitString;
import static lotto.utils.Validator.validatePositiveNumbers;

public class ManualNumberStrategy implements NumberStrategy {
    private final Lotto numbers;

    // 생성자로 미리 파라미터 세팅
    // String -> List<Integer> (이 변환은 utils로 전처리하기) -> Lotto
    public ManualNumberStrategy(String numbers) {
        validate(numbers); // 수동 넘버 검증 (숫자 6개, 정수)
        this.numbers = new Lotto(validate(numbers)); // 일반 검증
    }

    // 입력받은 파리미터로 Lotto 리턴
    @Override
    public Lotto generateNumber() {
        return numbers;
    }

    // 정수 아닌 경우, 양수 아닌 경우
    private List<Integer> validate(String numbers) {
        List<String> splitNumbers = splitString(numbers);
        List<Integer> convertedNumbers = convertToIntegerList(splitNumbers); // 여기서 정수 검증까지

        validatePositiveNumbers(convertedNumbers);
        return convertedNumbers;
    }
}
