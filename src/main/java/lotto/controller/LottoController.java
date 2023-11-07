package lotto.controller;

import lotto.model.LottoDrawMachine;
import lotto.model.LottoPaper;
import lotto.model.LottoPurchaseManager;
import lotto.model.dto.PurchaseResult;
import lotto.system.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(new LottoNumberGenerator());

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public PurchaseResult purchaseProcess() {
        // 구입 금액 입력 받기
        int purchaseAmount = inputView.inputPurchaseAmount();

        // 구입 금액 계산
        int purchaseQuantity = lottoPurchaseManager.calculatePurchaseQuantity(purchaseAmount);

        // 로또 구입
        List<LottoPaper> purchasedLottoPapers = lottoPurchaseManager.purchaseLottoPapers(purchaseQuantity);

        // 구입한 용지 출력
        outputView.printPurchaseResult(purchaseQuantity);
        outputView.printPurchasedLottoPaper(purchasedLottoPapers);

        return new PurchaseResult(purchaseAmount, purchasedLottoPapers);
    }

    public LottoDrawMachine createDrawMachineProcess() {
        // 당첨 번호 입력
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        // 보너스 번호 입력
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        // lottoDrawMachine 에 저장
        return new LottoDrawMachine(winningNumbers, bonusNumber);
    }
}
