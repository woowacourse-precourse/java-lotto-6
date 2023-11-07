package lotto.view;

import lotto.dto.LottoNumbersDTO;
import lotto.dto.LottoRankResultDTO;
import lotto.dto.LottoTotalReturnDTO;

public interface OutputView {
    void requestPurchaseAmount();
    void printCountOfLotto(int count);
    void printLottoNumbers(LottoNumbersDTO lottoNumbersDTO);
    void requestWinningLottoNumbers();
    void requestBonusLottoNumber();
    void printWinningStatistics();
    void printWinningNumberCount(LottoRankResultDTO lottoRankResultDTO);
    void printTotalReturn(LottoTotalReturnDTO lottoTotalReturnDTO);

}
