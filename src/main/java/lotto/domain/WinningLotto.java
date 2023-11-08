package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private static final String NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NUMBERS_DUPLICATE_ERROR = "[ERROR] 로또 번호와 보너스 번호는 중복 없이 입력해야 합니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> numbers) {
        super(numbers);
        this.validate(numbers);
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<LottoNumber> numbers) {
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateRange(List<LottoNumber> numbers) {
        numbers.forEach(number -> {
            if (number.getNumber() < MIN_NUMBER || number.getNumber() > MAX_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
            }
        });
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

    public Prize match(Lotto playerLotto) {
        int matchingCount = countMatchingNumbers(playerLotto);
        boolean matchBonus = playerLotto.contains(bonusNumber);

        return Prize.valueOf(matchingCount, matchBonus);
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
