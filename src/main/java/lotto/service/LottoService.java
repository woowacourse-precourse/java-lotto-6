package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;

public class LottoService {
    public UserMoney initUserMoney(final String userMoney) {
        return UserMoney.from(userMoney);
    }

    public WinningLottoNumbers initWinningLottoNumbers(final List<String> winningLottoNumbers) {
        return WinningLottoNumbers.from(winningLottoNumbers);
    }

    public BonusNumber initBonusNumber(final WinningLottoNumbers winningLottoNumbers, final String bonusNumber) {
        return BonusNumber.of(winningLottoNumbers.getWinningLottoNumbers(), Long.parseLong(bonusNumber));
    }
}