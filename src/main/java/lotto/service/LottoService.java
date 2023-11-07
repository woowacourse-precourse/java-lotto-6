package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.constant.LottoConstant;
import lotto.service.util.LottoGenerator;

public class LottoService {
    public UserMoney initUserMoney(final long userMoney) {
        return UserMoney.from(userMoney);
    }

    public Lottos createUserLottos(final long userMoney) {
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < calculateNumberOfLottos(userMoney); i++) {
            lottos.add(LottoGenerator.generateLotto());
        }
        return Lottos.from(lottos);
    }

    private long calculateNumberOfLottos(final long userMoney) {
        return userMoney / LottoConstant.LOTTO_PRICE.getValue();
    }

    public WinningLottoNumbers initWinningLottoNumbers(final List<Integer> winningLottoNumbers) {
        return WinningLottoNumbers.from(new Lotto(winningLottoNumbers));
    }

    public BonusNumber initBonusNumber(final WinningLottoNumbers winningLottoNumbers, final int bonusNumber) {
        return BonusNumber.of(bonusNumber, winningLottoNumbers.getWinningLottoNumbers());
    }
}