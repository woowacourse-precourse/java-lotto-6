package lotto.model;

import lotto.model.number.LottoNumber;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        super(lotto.getLottoNumbers());
        this.bonusNumber = bonusNumber;
    }

    /**
     * Description: 몇 개의 번호가 일치하는지 반환
     *
     * @param lotto
     * @return 일치 번호 개수
     */
    public int getMatchCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().getNumbers().stream()
                .filter(this::isContain)
                .count();
    }

    /**
     * Description: 매개변수로 받은 LottoNumber가 당첨 번호 안에 속하는지 여부
     *
     * @param lottoNumber
     * @return 당첨 번호 안에 속하는지 여부
     */
    private boolean isContain(LottoNumber lottoNumber) {
        return getLottoNumbers().getNumbers().stream()
                .anyMatch(lottoNumber::equals);
    }

    /**
     * Description: 매개변수로 받은 Lotto 안에 보너스 번호가 있는지 여부
     *
     * @param lotto
     * @return 보너스 번호가 있는지 여부
     */
    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().getNumbers().stream()
                .anyMatch(bonusNumber::equals);
    }
}
