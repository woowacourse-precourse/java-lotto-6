package lotto.model;

import lotto.utils.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class Lotto {
    public static final Integer LOTTO_NUMBERS_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 번호 갯수는 6개여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR = "중복되는 숫자는 허용하지 않습니다.";

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        return new Lotto(convertToLottoNumbers(numbers));
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new ErrorMessage(LOTTO_SIZE_ERROR);
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBERS_SIZE) {
            throw new ErrorMessage(LOTTO_DUPLICATE_ERROR);
        }
    }

    public Ranking compareWinLotto(WinLotto winLotto) {
        int matchCount = checkNumberMatchCount(winLotto);
        boolean bonusMatch = isMatchBonusNumber(winLotto.getBonusNumber());
        return Ranking.of(matchCount, bonusMatch);
    }

    private boolean isMatchBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int checkNumberMatchCount(WinLotto winLotto) {
        return (int) winLotto.getWinNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> getNumberValues() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
