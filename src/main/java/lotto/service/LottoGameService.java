package lotto.service;

import lotto.dto.request.LottoMoneyRequest;
import lotto.dto.request.LottoNumberRequest;
import lotto.dto.request.LottoRequest;
import lotto.dto.response.LottoBuyResponse;
import lotto.dto.response.LottoGameResultResponse;

public interface LottoGameService {
    LottoBuyResponse buyLottos(LottoMoneyRequest lottoMoneyRequest);

    LottoGameResultResponse calculateResult(LottoRequest winningLotto, LottoNumberRequest bonusLottoNumber);
}
