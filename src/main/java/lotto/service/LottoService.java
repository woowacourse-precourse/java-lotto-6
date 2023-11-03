package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTicket;
import lotto.exception.BonusNumberException;
import lotto.exception.PurchaseValidationException;
import lotto.exception.WinningNumberValidationException;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    public int getPurchaseAmount() {
        InputView.promptPurchaseAmount();

        while (true) {
            try {
                return parseAndValidatePurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidatePurchaseAmount() {
        String purchaseAmountView = InputView.readPurchaseAmount();
        validateIsNumeric(purchaseAmountView);

        int price = Integer.parseInt(purchaseAmountView);
        validatePurchaseAmount(price);

        return price;
    }

    private void validateIsNumeric(String input) {
        PurchaseValidationException.checkIsNumeric(input);
    }

    private void validatePurchaseAmount(int price) {
        PurchaseValidationException.checkValidPurchaseAmount(price);
    }

    public List<Integer> getWinningNumbers() {
        InputView.promptWinningNumbers();

        while (true) {
            try {
                String winningNumberView = InputView.readWinningNumbers();
                return parseAndValidateWinningNumbers(winningNumberView);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseAndValidateWinningNumbers(String winningNumberView) {
        validateLottoNumberFormat(winningNumberView);

        List<Integer> winningNumbers = convertInputToNumbers(winningNumberView);
        validateWinningNumber(winningNumbers);

        return winningNumbers;
    }

    private void validateLottoNumberFormat(String input) {
        WinningNumberValidationException.checkLottoNumberFormat(input);
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        WinningNumberValidationException.checkWinningNumberLength(winningNumbers);
        WinningNumberValidationException.checkDuplicateWinningNumbers(winningNumbers);
        WinningNumberValidationException.checkBoundaryOfWinningNumbers(winningNumbers);
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        InputView.promptBonusNumber();

        while (true) {
            try {
                return parseAndValidateBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidateBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberStr = InputView.readBonusNumber();
        validateBonusNumberFormat(bonusNumberStr);

        int bonusNumber = Integer.parseInt(bonusNumberStr);
        validateBoundaryAndDuplicateBonusNumber(bonusNumber, winningNumbers);

        return bonusNumber;
    }

    private void validateBonusNumberFormat(String input) {
        BonusNumberException.ensureValidFormat(input);
    }

    private void validateBoundaryAndDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        BonusNumberException.ensureWithinValidRange(bonusNumber);
        BonusNumberException.ensureNotDuplicatedWithWinningNumbers(winningNumbers, bonusNumber);
    }


    public LottoTickets purchaseLottoTicket(int amount) {
        return LottoTickets.buy(amount);
    }

    public WinningLottoTicket createWinningLottoTicket(List<Integer> winningNumber, int bonusNumber) {
        return new WinningLottoTicket(winningNumber, bonusNumber);
    }

    public Map<Rank, Integer> calculateStatistics(LottoTickets lottoTicket, WinningLottoTicket winningLottoTicket) {
        Map<Rank, Integer> statistics = initializeStatistics();

        for (Lotto lotto : lottoTicket.getLottoTickets()) {
            Rank rank = winningLottoTicket.match(lotto);
            incrementStatistic(statistics, rank);
        }

        return statistics;
    }

    private Map<Rank, Integer> initializeStatistics() {
        Map<Rank, Integer> statistics = new HashMap<>();
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
        return statistics;
    }

    private void incrementStatistic(Map<Rank, Integer> statistics, Rank rank) {
        statistics.put(rank, statistics.get(rank) + 1);
    }

    private List<Integer> convertInputToNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
