package lotto.model;

public class WinningLotto{
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public Rank compare(Lotto targetLotto){
        return Rank.findBy(lotto.matchCount(targetLotto),
                targetLotto.hasNumber(bonusNumber));
    }

}
