package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

import java.util.List;

import static lotto.util.LottoGenerator.generateRandomLottos;
import static lotto.service.LottoService.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public static void play() {
        int purchaseAmount = enterPurchaseAmount();
        List<Lotto> lottos = generateRandomLottos(purchaseAmount);

        printAllPurchaseLotto(lottos);

        Lotto lottoNumbers = enterWinningNumbers();
        int bonusNumber = enterBonusNumber(lottoNumbers);

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers, bonusNumber);
        matchLottoNumbers(winningNumbers, lottos);

        printResult(purchaseAmount);
    }

    public static void printResult(int purchaseAmount){
        printWinningStatus();
        printEarningRatio(purchaseAmount);
    }
}
