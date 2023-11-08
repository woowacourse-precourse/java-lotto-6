package lotto.service;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoGame;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.Lottos;
import lotto.domain.entity.Purchase;
import lotto.domain.entity.ThousandUnitMoney;
import lotto.domain.entity.WinningResult;
import lotto.domain.entity.WinningTicket;

public interface LottoGameService {

    WinningResult calcWinningResult(Purchase purchase, WinningTicket winningTicket);

    Long saveLottoGame(LottoGame lottoGame);
}
