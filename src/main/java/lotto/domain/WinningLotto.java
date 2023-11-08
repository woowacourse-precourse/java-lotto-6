package lotto.domain;

import java.util.List;
import lotto.dto.LottoMatchResponse;

public class WinningLotto extends Lotto {
    private static final String NUMBERS_DUPLICATE_ERROR = "[ERROR] 로또 번호와 보너스 번호는 중복 없이 입력해야 합니다.";

    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> numbers) {
        super(numbers);
        validateDuplicate(numbers);
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_ERROR);
        }
    }

    private void validateDuplicate(LottoNumber bonusNumber) {
        if (super.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_ERROR);
        }
    }

    public LottoMatchResponse match(Lotto playerLotto) {
        int matchingCount = countMatchingNumbers(playerLotto);
        boolean matchBonus = playerLotto.contains(bonusNumber);

        return new LottoMatchResponse(matchingCount, matchBonus);
    }

    private int countMatchingNumbers(Lotto playerLotto) {
        return (int) super.getNumbers().stream()
                .filter(playerLotto.getNumbers()::contains)
                .count();
    }

    @Override
    public List<Integer> getNumbers() {
        return super.getNumbers();
    }
}
