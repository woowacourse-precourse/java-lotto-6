package lotto.service;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoGame;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.Lottos;
import lotto.domain.entity.ThousandUnitMoney;
import lotto.domain.entity.WinningResult;

public interface LottoGameService {

    WinningResult calcWinningResult(Lotto winningNumbers,
                                    LottoNumber bonusNumber,
                                    Lottos automaticLottos,
                                    ThousandUnitMoney purchasePrice,);

    Long saveLottoGame(LottoGame lottoGame);
}
