package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRamdomNumbers;
import lotto.domain.ReadPurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoRamdomNumbers lottoRamdomNumbers = new LottoRamdomNumbers();

    public void LottoGameStart() {
        String readAmount = inputView.enterLottoPurchaseAmount();
        List<Lotto> lottoNumbers = lottoRamdomNumbers.generateRandomLottoNumbers(readAmount);
        outputView.printIssuedLottoNumbersInAscendingOrder(lottoNumbers);
        Lotto winningLottoNumber = inputView.enterWinningNumbers();

    }

}
