package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.Winning;
import lotto.model.generator.Lotto;

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
                .calculatorController(lottoPurchaseNumbers, winningNumber, bonusNumber); // 당첨 계산
        calculatorController.rateOfReturnController(purchase, allPrizeCount); // 수익률 계산
    }
}
