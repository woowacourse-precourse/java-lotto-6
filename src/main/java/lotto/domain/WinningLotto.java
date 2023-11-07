package lotto.domain;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final Number bonusNumber;

    public WinningLotto(Lotto inputLottoNumbers, Number inputBonusNumber) {
        validateDuplicated(inputLottoNumbers, inputBonusNumber);
        this.winningNumbers = inputLottoNumbers;
        this.bonusNumber = inputBonusNumber;
    }

    private void validateDuplicated(Lotto lotto, Number bonusNumber) {
        boolean contains = lotto.contains(bonusNumber);
        if (contains) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 겹칩니다!");
        }
    }

    public LottoRank match(Lotto lottoNumbers) {
        int count = countMatch(lottoNumbers);
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);
        return LottoRank.of(count, bonusMatch);
    }

    private int countMatch(Lotto lottoNumbers) {
        return (int) winningNumbers.getNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

}
