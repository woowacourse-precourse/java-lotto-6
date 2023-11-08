package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.lottoNumbers = new ArrayList<>(convertToLottoNumbers(numbers));
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static void validateLottoNumber(List<Integer> numbers) {
            validateLottoNumbersLength(numbers);
            validateIsNumberDuplicate(numbers);
    }

    private static void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 총 길이는 6이어야 합니다.");
        }
    }

    private static void validateIsNumberDuplicate(List<Integer> numbers) {
        if (isNumberDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 각 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private static boolean isNumberDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::create)
                .toList();
    }

    public List<Integer> getIntegerNumber() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .toList();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
