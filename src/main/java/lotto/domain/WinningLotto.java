package lotto.domain;

public class WinningLotto {
    private static final String ERROR_HEAD = "[ERROR] ";
    private final Lotto winningNumbers;
    private final Number bonusNumber;

    public WinningLotto(final Lotto inputLottoNumbers, final Number inputBonusNumber) {
        validateDuplicated(inputLottoNumbers, inputBonusNumber);
        this.winningNumbers = inputLottoNumbers;
        this.bonusNumber = inputBonusNumber;
    }

    private void validateDuplicated(final Lotto lotto, final Number bonusNumber) {
        boolean contains = lotto.contains(bonusNumber);
        if (contains) {
            throw new IllegalArgumentException(ERROR_HEAD + "보너스 번호가 당첨 번호와 겹칩니다!");
        }
    }

    public LottoRank match(final Lotto lottoNumbers) {
        int count = countMatch(lottoNumbers);
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);
        return LottoRank.of(count, bonusMatch);
    }

    private int countMatch(final Lotto lottoNumbers) {
        return (int) winningNumbers.getNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

}
