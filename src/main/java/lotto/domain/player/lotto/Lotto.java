 package lotto.domain.player.lotto;

 import java.util.ArrayList;
 import java.util.List;

 public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validateLottoNumber(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto create(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private static void validateLottoNumber(List<LottoNumber> numbers) {
        validateLottoNumbersLength(numbers);
    }

    private static void validateLottoNumbersLength(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 총 길이는 6이어야 합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
