package lotto.domain;

public class WinningLotto {
    private final Lotto lottoNumbers;
    private final Number bonusNumber;

    public WinningLotto(Lotto inputLottoNumbers, Number inputBonusNumber) {
        validateDuplicated(inputLottoNumbers, inputBonusNumber);
        this.lottoNumbers = inputLottoNumbers;
        this.bonusNumber = inputBonusNumber;
    }

    private void validateDuplicated(Lotto lotto, Number bonusNumber) {
        boolean contains = lotto.contains(bonusNumber);
        if (contains) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 겹칩니다!");
        }
    }

    public LottoRank match(Lotto lottoNumbers) {
        int count = count(lottoNumbers);
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);
        return LottoRank.of(count, bonusMatch);
    }

    private int count(Lotto lottoNumbers) {
        return (int) lottoNumbers.getNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

}
