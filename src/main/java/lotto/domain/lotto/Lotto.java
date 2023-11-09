package lotto.domain.lotto;

import static lotto.domain.number.LottoRandomNumber.LIMIT_RANGE;
import static lotto.domain.number.LottoRandomNumber.LOTTO_SIZE;
import static lotto.domain.number.LottoRandomNumber.START_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.domain.converter.LottoConverter;
import lotto.dto.request.WinningLottoRequest;

public class Lotto {

    private static final String REGEX_PROPERTY = "^[0-9,]*$";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateCaseDuplicates(numbers);
        validateCaseNumber(numbers);
        this.numbers = numbers;
    }

    public Lotto(WinningLottoRequest request) {
        validateType(request.getWinningLotto());
        LottoConverter converter = new LottoConverter();
        numbers = converter.winningLottoConvertToList(request.getWinningLotto());
        validate(numbers);
    }

    public boolean isDuplicate(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력크기가 맞지 않습니다.");
        }
    }

    private void validateType(String numbers) {
        if (!Pattern.matches(REGEX_PROPERTY, numbers)) {
            throw new IllegalArgumentException("[ERROR] 허용되지 않는 입력이 있습니다.");
        }
    }

    private void validateCaseDuplicates(List<Integer> numbers) {
        Set<Integer> input = new HashSet<>(numbers);
        if (input.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 입력입니다.");
        }
    }

    private void validateCaseNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < START_RANGE || LIMIT_RANGE < number)) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 수를 입력해주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}