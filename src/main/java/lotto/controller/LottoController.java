package lotto.controller;

import lotto.domain.*;
import lotto.exception.InvalidInputException;
import lotto.utils.LottoInputValidator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;
import java.util.Map;

import static lotto.domain.Lotto.getLottoNumbersAsString;

public class LottoController {

    private final LottoGameCalculator lottoGameCalculator;
    private LottoGame lottoGame;
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoResultCalculator calculator;

    private final LottoInputValidator inputValidator;

    public LottoController(LottoGameCalculator lottoGameCalculator,
                           LottoInputView lottoInputView,
                           LottoOutputView lottoOutputView,
                           LottoResultCalculator calculator,
                           LottoInputValidator inputValidator) {
        this.lottoGameCalculator = lottoGameCalculator;
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.calculator = calculator;
        this.inputValidator = inputValidator;
    }

    public void start(){
        String purchasedPrice = inputPurchasePrice();
        if (purchasedPrice == null) return;

        int purchaseAmount = getPurchaseAmount(purchasedPrice);

        getAllLottoTickets(purchaseAmount);

        List<String> withSplitLottoNumbers = getWinningNumbersAsString();

        List<Integer> checkWinningNumbers = getCheckWinningNumbers(withSplitLottoNumbers);

        //보너스 번호 입력 & 출력
        String bonusNumber = lottoInputView.bonusNumberInput();
        lottoOutputView.bonusNumberPrint(bonusNumber);

        // 보너스 번호 중복 확인 작업
        int checkBonusNumber = inputValidator.checkBonusNumberValidate(bonusNumber, checkWinningNumbers);

        Map<WinningStatistics, Integer> winningStatisticsIntegerMap = getPrizeLottoTicketsStatus(checkWinningNumbers, checkBonusNumber);

        getPrizeRateResult(purchasedPrice, winningStatisticsIntegerMap);

    }

    private void getPrizeRateResult(String purchasedPrice, Map<WinningStatistics, Integer> winningStatisticsIntegerMap) {
        // 당첨 통계 (2) - 확률 구하고 출력
        double lottoPrizeRate = calculator.lottoPrizeRateCalculate(Integer.parseInt(purchasedPrice), winningStatisticsIntegerMap);
        lottoOutputView.lottoWinningPrizeRatePrint(lottoPrizeRate);
    }

    private Map<WinningStatistics, Integer> getPrizeLottoTicketsStatus(List<Integer> checkWinningNumbers, int checkBonusNumber) {
        //당첨 통계 (1) - 각각 1등  2등 3등 ... 이 몇개 당첨됐는지 계산 후 출력
        List<Lotto> lottoTickets = lottoGame.getLottoTickets();
        Map<WinningStatistics, Integer> winningStatisticsIntegerMap;

        for (int index = 0; index < lottoTickets.size(); index++){
            calculator.lottoWinningCountingCalculate(checkWinningNumbers, lottoTickets.get(index).getLottoNumbers(), checkBonusNumber,lottoGameCalculator);
        }

        winningStatisticsIntegerMap = calculator.getTotalStatistics();

        lottoOutputView.lottoWinningPrizeResultPrint(winningStatisticsIntegerMap);
        return winningStatisticsIntegerMap;
    }

    private List<Integer> getCheckWinningNumbers(List<String> withSplitLottoNumbers) {
        //유효성 검사 진행된 당첨 번호 리스트
        List<Integer> checkWinningNumbers = inputValidator.checkWinningNumbersValidate(withSplitLottoNumbers);
        return checkWinningNumbers;
    }

    private List<String> getWinningNumbersAsString() {
        // 당첨 번호 입력 & 출력
        String notSplitWinningNumbers = lottoInputView.lottoWinningNumbersInput();
        lottoOutputView.winningNumbersPrint(notSplitWinningNumbers);
        List<String> withSplitLottoNumbers = getLottoNumbersAsString(notSplitWinningNumbers);
        return withSplitLottoNumbers;
    }

    private void getAllLottoTickets(int purchaseAmount) {
        //랜덤하게 로또 구매 가능 개수만큼 로또 번호 출력
        lottoOutputView.lottoTicketsPrint(lottoGame, purchaseAmount);
    }

    private int getPurchaseAmount(String purchasedPrice) {
        //로또 구매 가능 개수 출력
        int purchaseAmount = lottoGameCalculator.purchaseAmountCalculator(purchasedPrice);
        lottoOutputView.purchaseAmountPrint(purchaseAmount);
        lottoGame = new LottoGame(purchaseAmount);
        return purchaseAmount;
    }

    private String inputPurchasePrice() {
        //구입 금액 입력
        String purchasedPrice = lottoInputView.purchasePriceInput();
        lottoOutputView.purchasePricePrint(purchasedPrice);

        try {
            if (!inputValidator.isNumericValidation(purchasedPrice)){
                throw new InvalidInputException("[Error] 구매 금액은 숫자로만 입력 받아 주세요.");
            }
        }catch (InvalidInputException e){
            System.out.println("[ERROR]");
            return null;
        }
        return purchasedPrice;
    }


}
