package controller;

import lotto.Lotto;
import model.LottoJudge;
import model.ProfitCalculable;

public record ProcessLottoGameParameters(ProfitCalculable rateCalculateMan, LottoJudge judgeMan,
                                         Lotto userLotto, int bonusNumber, int money) {
}

