package lotto.domain;

public class WinLotto {

    private final Lotto numbers;
    private final LottoNumber bonus;

    public WinLotto(Lotto winLottoNumber, LottoNumber bonus) {
        validateUniqueness(winLottoNumber, bonus);
        this.numbers = winLottoNumber;
        this.bonus = bonus;
    }
    public static WinLotto of(Lotto winLottoNumber, LottoNumber bonus) {
        return new WinLotto(winLottoNumber, bonus);
    }

    private void validateUniqueness(Lotto winLottoNumber, LottoNumber bonus) {
        if(winLottoNumber.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스볼은 로또 번호와 중복될 수 없습니다.");
        }
    }

}
