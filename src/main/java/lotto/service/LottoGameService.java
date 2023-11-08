package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.ThousandUnitMoney;
import lotto.domain.WinningResult;

public interface LottoGameService {

    WinningResult calcWinningResult(Lotto winningNumbers,
                                    LottoNumber bonusNumber,
                                    Lottos automaticLottos,
                                    ThousandUnitMoney purchasePrice,);

    Long saveLottoGame(LottoGame lottoGame);
}
