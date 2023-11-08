package lotto.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.Model.LottoEarningCalculator;
import lotto.Model.LottoPrizeCalculator;
import lotto.Model.LottoPurchaseCalculator;
import lotto.Model.LottoTicket;
import lotto.validation.AmountValidator;
import lotto.validation.BonusNumberValidator;
import lotto.validation.WinningNumberValidator;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {

    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    int lottoPrice = LottoPurchaseCalculator.LOTTO_PRICE;

    public LottoController(LottoInput lottoInput, LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void run() {
        int numberOfTickets = getValidPurchaseAmount();
        List<LottoTicket> purchasedTickets = purchaseLottoTickets(numberOfTickets);
        showPurchasedTickets(purchasedTickets);

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);

        showStatistics(purchasedTickets, winningNumbers, bonusNumber, numberOfTickets);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println(lottoOutput.requestAmountMessage());
                String amountStr = lottoInput.getAmount();
                int amount = AmountValidator.validateAmount(amountStr);
                return LottoPurchaseCalculator.calculateNumberOfTickets(amount);
            } catch (IllegalArgumentException exception) {
                System.out.println(lottoOutput.getErrorMessage(exception.getMessage()));
            }
        }
    }

    private List<LottoTicket> purchaseLottoTickets(int numberOfTickets) {
        List<LottoTicket> purchasedTickets = new ArrayList<>();
        System.out.println(lottoOutput.printNumberOfTicketsMessage(numberOfTickets));
        for (int i = 0; i < numberOfTickets; i++) {
            LottoTicket lottoTicket = new LottoTicket();
            purchasedTickets.add(lottoTicket);
        }
        return purchasedTickets;
    }

    private void showPurchasedTickets(List<LottoTicket> purchasedTickets) {
        for (LottoTicket ticket : purchasedTickets) {
            System.out.println(lottoOutput.getLottoNumbersMessage(ticket.getNumbers()));
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                System.out.println(lottoOutput.requestWinningNumber());
                String winningNumbersInput = lottoInput.getWinningNumber();
                return WinningNumberValidator.validateWinningNumbers(winningNumbersInput);

            } catch (IllegalArgumentException exception) {
                System.out.println(lottoOutput.getErrorMessage(exception.getMessage()));
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println(lottoOutput.requestBonusNumber());
                String bonusNumberInput = lottoInput.getBonusNumber();
                int bonusNumber = BonusNumberValidator.validateBonusNumber(bonusNumberInput, winningNumbers); // 입력 값을 int로 변환
                BonusNumberValidator.validateBonusNumber(bonusNumberInput, winningNumbers); // 변환된 int 값을 검증
                return bonusNumber; // 검증 후 변환된 값을 반환
            } catch (IllegalArgumentException exception) {
                System.out.println(lottoOutput.getErrorMessage(exception.getMessage())); // 에러 메시지를 출력
            }
        }
    }

    private void showStatistics(List<LottoTicket> purchasedTickets, List<Integer> winningNumbers, int bonusNumber, int numberOfTickets) {
        LottoPrizeCalculator prizeCalculator = new LottoPrizeCalculator(winningNumbers, bonusNumber);
        prizeCalculator.calculateStatistics(purchasedTickets);

        Map<Integer, Integer> prizeCountMap = prizeCalculator.getPrizeCountMap();
        List<String> statisticsLines = prepareStatisticsLines(prizeCountMap);

        lottoOutput.printPrizeStatistics(statisticsLines);

        long totalPrizeMoney = prizeCalculator.getTotalPrizeMoney();
        BigDecimal earningsRate = LottoEarningCalculator.calculateEarningsRate(totalPrizeMoney, numberOfTickets, lottoPrice);

        lottoOutput.printEarningsRate(earningsRate);
    }

    private List<String> prepareStatisticsLines(Map<Integer, Integer> prizeCountMap) {
        List<String> statisticsLines = new ArrayList<>();
        new TreeMap<>(prizeCountMap).forEach((prize, count) -> {
            String prizeDescription = LottoPrizeCalculator.getPrizeDescription(prize);
            if (prizeDescription != null) {
                statisticsLines.add(prizeDescription + " - " + count + "개");
            }
        });
        return statisticsLines;
    }
}



