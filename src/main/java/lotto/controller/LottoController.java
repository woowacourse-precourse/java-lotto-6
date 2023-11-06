package lotto.controller;

import static lotto.util.Constants.ZERO;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.model.BundleGenerator;
import lotto.model.LottoBundle;
import lotto.model.LottoDTO;
import lotto.model.ProfitCalculator;
import lotto.util.enums.LottoResult;
import lotto.util.exception.parental.InputValidationException;
import lotto.util.exception.parental.MathOperationException;
import lotto.model.BonusNumber;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;
    private static final Long LONG_ZERO = 0L;

    boolean validInput = FALSE;

    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    BundleGenerator bundleGenerator;
    LottoBundle lottoBundle;
    PurchaseAmount amount;

    public void winningResult() {
        // 몇 개 구매 했는지
        purchaseLottoTickets();
        // 구매 개수에 맞게 로또 번호 출력
        generateLottoBundle();
        // 정답, 보너스 번호 입력
        setWinningNumbers();
        setBonusNumber();
        // 당첨 통계 출력
        displayProfitReport();
    }

    private void purchaseLottoTickets() {
        validInput = FALSE;
        while (!validInput) {
            try {
                InputView.getAmount();
                amount = new PurchaseAmount(Console.readLine());
                bundleGenerator = new BundleGenerator(amount);
                OutputView.getPurchase(amount);
                validInput = TRUE;
            } catch (MathOperationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateLottoBundle() {
        lottoBundle = new LottoBundle(bundleGenerator.generateLotto());
        List<LottoDTO> lottoDTO = lottoBundle.generateLottoTicketReport();
        for (LottoDTO dto : lottoDTO) {
            OutputView.getLottoNumbers(dto);
        }
    }

    private void setWinningNumbers() {
        validInput = FALSE;
        while(!validInput) {
            try {
                InputView.getWinningNumbers();
                winningNumbers = new WinningNumbers(Console.readLine());
                validInput = TRUE;
            } catch (InputValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setBonusNumber() {
        validInput = FALSE;
        while(!validInput) {
            try {
                InputView.getBonusNumber();
                bonusNumber = new BonusNumber(Console.readLine(), winningNumbers);
                validInput = TRUE;
            } catch (InputValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<String, Integer> displayStatisticReport() {
        OutputView.winningStatistics();
        OutputView.separator();
        Map<String, Integer> compareResult = lottoComparator();
        compareResult.forEach(OutputView::getResult);
        return compareResult;
    }

    private Map<String, Integer> lottoComparator() {
        return lottoBundle.compareLotto(winningNumbers, bonusNumber);
    }

    private void displayProfitReport() {
        Map<String, Integer> compareResult = displayStatisticReport();
        long totalPrize = calculateTotalPrize(compareResult);
        double profit = calculateProfit(totalPrize);
        OutputView.getProfit(profit);
    }

    private long calculateTotalPrize(Map<String, Integer> compareResult) {
        return compareResult.entrySet().stream()
                .filter(this::shouldIncludeEntry)
                .mapToLong(this::calculatePrizeForEntry)
                .sum();
    }

    private boolean shouldIncludeEntry(Map.Entry<String, Integer> entry) {
        Optional<LottoResult> result = LottoResult.fromDescription(entry.getKey());
        return result.isPresent() && entry.getValue() > ZERO;
    }

    private long calculatePrizeForEntry(Map.Entry<String, Integer> entry) {
        Optional<LottoResult> result = LottoResult.fromDescription(entry.getKey());
        return result.map(lottoResult -> (long) lottoResult.getPrize() * entry.getValue()).orElse(LONG_ZERO);
    }

    private double calculateProfit(long totalPrize) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculateProfit(totalPrize, amount);
    }
}
