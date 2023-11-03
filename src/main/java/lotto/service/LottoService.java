package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTicket;
import lotto.exception.BonusNumberExceptionMessage;
import lotto.exception.PurchaseExceptionMessage;
import lotto.exception.WinningNumberExceptionMessage;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoTicket lottoTicket = new LottoTicket();

    public int displayPurchase() {
        InputView.printPurchasePrompt();

        while (true) {
            try {
                return parseAndValidatePurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidatePurchaseAmount() {
        String purchaseAmountView = InputView.getPurchaseAmountView();
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
        InputView.printWinningNumberPrompt();

        while (true) {
            try {
                String winningNumberView = InputView.getWinningNumberView();
                return parseAndValidateWinningNumbers(winningNumberView);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseAndValidateWinningNumbers(String winningNumberView) {
        validateLottoNumberFormat(winningNumberView);

        List<Integer> winningNumbers = changeInputToString(winningNumberView);
        validateWinningNumber(winningNumbers);

        return winningNumbers;
    }

    private void validateLottoNumberFormat(String input) {
        WinningNumberExceptionMessage.validateLottoNumberFormat(input);
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        WinningNumberExceptionMessage.validateWinningNumberLength(winningNumbers);
        WinningNumberExceptionMessage.validateDuplicateWinningNumber(winningNumbers);
        WinningNumberExceptionMessage.validateBoundaryWinningNumber(winningNumbers);
    }

    public int displayBonusNumber(List<Integer> winningNumbers) {
        InputView.printBonusNumberPrompt();

        while (true) {
            try {
                return parseAndValidateBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidateBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberStr = InputView.getBonusNumber();
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


    public LottoTicket getLottoTicket(int amount) {
        return lottoTicket.buy(amount);
    }

    public WinningLottoTicket makeWinningLottoTicket(List<Integer> winningNumber, int bonusNumber) {
        return new WinningLottoTicket(winningNumber, bonusNumber);
    }

    public Map<Rank, Integer> getStatistics(LottoTicket lottoTicket, WinningLottoTicket winningLottoTicket) {
        Map<Rank, Integer> statistics = new HashMap<>();

        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto lotto : lottoTicket.getLottoTickets()) {
            Rank rank = winningLottoTicket.match(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private List<Integer> changeInputToString(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
