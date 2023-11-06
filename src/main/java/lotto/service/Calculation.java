package lotto.service;

import lotto.dto.requset.WinningBonusNumber;
import lotto.dto.response.LottoCollection;
import lotto.dto.response.WinningResult;

public interface Calculation {

	LottoCollection createLotto(String price);

	WinningResult winningCalculation(WinningBonusNumber winningBonusNumber);


}
