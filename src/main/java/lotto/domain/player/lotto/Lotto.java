package lotto.domain.player.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.lottoNumbers = new ArrayList<>(convertToLottoNumbers(numbers));
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static void validateLottoNumber(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
    }

    private static void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 총 길이는 6이어야 합니다.");
        }
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::create)
                .toList();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
