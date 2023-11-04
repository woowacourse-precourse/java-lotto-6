package lotto.model;

import java.util.List;

public class WinningLotto {

    // TODO: 입력받은 로또 번호와 컴퓨터가 랜덤으로 생성한 로또 번호가 일치하는 match() 메서드 구현
    // TODO: 입력받은 로또 당첨 번호와 입력받은 로또 보너스 번호가 중복되는지 예외 검증 메서드 구현

    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusLottoNumber) {
        validateWinningAndBonusNumberDuplication(lottoNumbers, bonusLottoNumber);
        this.lotto = new Lotto(lottoNumbers);
        this.bonusLottoNumber = new LottoNumber(bonusLottoNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }

    private void validateWinningAndBonusNumberDuplication(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 로또 보너스 번호는 서로 중복되지 않는 숫자여야 합니다.");
        }
    }
}
