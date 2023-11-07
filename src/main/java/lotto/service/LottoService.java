package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;

public class LottoService {
    public UserMoney initUserMoney(final long userMoney) {
        return UserMoney.from(userMoney);
    }

    public WinningLottoNumbers initWinningLottoNumbers(final List<Long> winningLottoNumbers) {
        return WinningLottoNumbers.from(winningLottoNumbers);
    }

    public BonusNumber initBonusNumber(final WinningLottoNumbers winningLottoNumbers, final long bonusNumber) {
        return BonusNumber.of(bonusNumber, winningLottoNumbers.getWinningLottoNumbers());
    }
}