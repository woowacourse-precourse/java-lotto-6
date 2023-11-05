package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

import java.util.List;

import static lotto.domain.LottoGenerator.generateRandomLottos;
import static lotto.service.LottoService.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public static void play() {
        int purchaseAmount = enterPurchaseAmount();
        List<Lotto> lottos = generateRandomLottos(purchaseAmount);

        printAllPurchasedLotto(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(enterWinningNumbers(), enterBonusNumber());

        matchLottoNumbers(winningNumbers, lottos);

        printWinningStatus();
        printEarningRatio(purchaseAmount);
    }
}
