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
                String purchaseAmountView = InputView.getPurchaseAmountView();
                PurchaseExceptionMessage.validateIsNumeric(purchaseAmountView);

                int price = Integer.parseInt(purchaseAmountView);
                PurchaseExceptionMessage.validatePurchaseAmount(price);

                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> displayWinningNumber() {
        InputView.printWinningNumberPrompt();

        while (true) {
            try {
                String winningNumberView = InputView.getWinningNumberView();
                WinningNumberExceptionMessage.validateLottoNumberFormat(winningNumberView);

                List<Integer> winningNumbers = changeInputToString(winningNumberView);
                WinningNumberExceptionMessage.validateWinningNumberLength(winningNumbers);

                WinningNumberExceptionMessage.validateDuplicateWinningNumber(winningNumbers);
                WinningNumberExceptionMessage.validateBoundaryWinningNumber(winningNumbers);

                return winningNumbers;  // 모든 검증이 통과되면 winningNumbers 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int displayBonusNumber(List<Integer> winningNumbers) {
        InputView.printBonusNumberPrompt();

        while (true) {
            try {
                String bonusNumberStr = InputView.getBonusNumber();
                BonusNumberExceptionMessage.validateBonusNumberFormat(bonusNumberStr);

                int bonusNumber = Integer.parseInt(bonusNumberStr);
                BonusNumberExceptionMessage.validateBoundaryBonusNumber(bonusNumber);
                BonusNumberExceptionMessage.validateBonusNumber(winningNumbers, bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
