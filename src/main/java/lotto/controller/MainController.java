package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.BonusMatchType;
import lotto.constant.MatchNumber;
import lotto.constant.UnitNumber;
import lotto.constant.Winning;
import lotto.model.player.BonusNumber;
import lotto.model.generator.Lotto;
import lotto.model.player.BuyLotto;
import lotto.model.calculator.YieldCalculator;
import lotto.model.calculator.CheckWinning;
import lotto.model.player.WinningNumber;
import lotto.model.calculator.WinningRank;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class MainController {
    private final PlayerController playerController;
    private final GeneratorController generatorController;
    private final CalculatorController calculatorController;

    public MainController() {
        playerController = new PlayerController();
        generatorController = new GeneratorController();
        calculatorController = new CalculatorController();
    }

    public void excute() {
        int purchase = playerController.purchaseController(); // 로또 구입
        List<Lotto> lottoPurchaseNumbers = generatorController.printLottoController(purchase); // 로또 발행
        List<Integer> winningNumber = playerController.winningNumberController(); // 당첨 번호 입력
        int bonusNumber = playerController.bonusNumberController(winningNumber); // 보너스 번호 입력
        Map<Winning, Integer> allPrizeCount = calculatorController
                .wonCalculatorManager(lottoPurchaseNumbers, winningNumber, bonusNumber); // 당첨 계산
        calculatorController.rateOfReturnManager(purchase, allPrizeCount); // 수익률 계산
    }
}
