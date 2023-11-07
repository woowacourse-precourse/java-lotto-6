package lotto.controller;

import lotto.model.LottoDrawMachine;
import lotto.model.LottoPaper;
import lotto.model.LottoPurchaseManager;
import lotto.model.LottoResultAnalyzer;
import lotto.model.dto.LottoResultDTO;
import lotto.model.dto.PurchaseResult;
import lotto.system.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(new LottoNumberGenerator());
    private final LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();

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

    public void analyzeProcess(LottoDrawMachine lottoDrawMachine, PurchaseResult purchaseResult) {
        // 로또 용지와 구입 금액
        List<LottoPaper> purchasedLottoPapers = purchaseResult.getPurchasedLottoPapers();
        int purchaseAmount = purchaseResult.getPurchaseAmount();

        // 로또 결과 분석 1: 당첨 번호 일치 개수 파악
        lottoResultAnalyzer.writeResultToLottoPapers(purchasedLottoPapers, lottoDrawMachine.getWinningNumbers());

        // 로또 결과 분석 2: 등수 확인
        lottoResultAnalyzer.matchByLottoPapers(purchasedLottoPapers, lottoDrawMachine.getBonusNumber());

        // 로또 결과 분석 3: 총 당첨 금액 계산
        long totalWinningPrize = lottoResultAnalyzer.calculateTotalWinningPrize(lottoResultAnalyzer.getMatchResults());

        // 로또 결과 분석 4: 총 수익률 계산
        double totalReturnRate = lottoResultAnalyzer.calculateTotalReturnRate(totalWinningPrize, purchaseAmount);

        // 로또 결과지 출력
        LottoResultDTO dto = lottoResultAnalyzer.makeResultDTO(lottoResultAnalyzer.getMatchResults(), totalReturnRate);

        // 통계 출력
        outputView.printWinningStatistics(dto);
    }
}
