package lotto;

public class BonusNumber extends LottoNumber {
    private final LottoNumber lottoNumber;

    BonusNumber(Lotto lotto, Integer lottoNumber) {
        super(lottoNumber);
        this.lottoNumber = new LottoNumber(lottoNumber);
        validateDuplicateBonusNumber(lotto);
    }

    private void validateDuplicateBonusNumber(Lotto lotto) {
        if (lotto.containLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호 입니다.");
        }
    }

    public LottoNumber getLottoNumber() {
        return this.lottoNumber;
    }
}
