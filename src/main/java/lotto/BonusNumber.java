package lotto;

public class BonusNumber {
    private final LottoNumber lottoNumber;

    BonusNumber(Lotto lotto, Integer lottoNumber) {
        this.lottoNumber = new LottoNumber(lottoNumber);
        validateDuplicateBonusNumber(lotto);
    }

    private void validateDuplicateBonusNumber(Lotto lotto) {
        if (lotto.containLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
        }
    }

    public LottoNumber getLottoNumber() {
        return this.lottoNumber;
    }
}
