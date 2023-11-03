package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTicket;
import lotto.exception.BonusNumberExceptionMessage;
import lotto.exception.PurchaseExceptionMessage;
import lotto.exception.WinningNumberValidator;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoTicket lottoTicket = new LottoTicket();

    public int displayPurchase() {
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
        PurchaseExceptionMessage.validateIsNumeric(input);
    }

    private void validatePurchaseAmount(int price) {
        PurchaseExceptionMessage.validatePurchaseAmount(price);
    }

    public List<Integer> displayWinningNumber() {
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
        WinningNumberValidator.validateLottoNumberFormat(input);
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        WinningNumberValidator.validateWinningNumberLength(winningNumbers);
        WinningNumberValidator.validateDuplicateWinningNumber(winningNumbers);
        WinningNumberValidator.validateBoundaryWinningNumber(winningNumbers);
    }

    public int displayBonusNumber(List<Integer> winningNumbers) {
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
        BonusNumberExceptionMessage.validateBonusNumberFormat(input);
    }

    private void validateBoundaryAndDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        BonusNumberExceptionMessage.validateBoundaryBonusNumber(bonusNumber);
        BonusNumberExceptionMessage.validateBonusNumber(winningNumbers, bonusNumber);
    }


    public LottoTicket purchaseLottoTicket(int amount) {
        return lottoTicket.buy(amount);
    }

    public WinningLottoTicket createWinningLottoTicket(List<Integer> winningNumber, int bonusNumber) {
        return new WinningLottoTicket(winningNumber, bonusNumber);
    }

    public Map<Rank, Integer> calculateStatistics(LottoTicket lottoTicket, WinningLottoTicket winningLottoTicket) {
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
