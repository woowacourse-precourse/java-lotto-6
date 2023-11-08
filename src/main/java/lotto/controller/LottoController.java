package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        long purchaseAmount = inputPurchaseAmount();
        List<LottoTicket> tickets = purchaseTickets(purchaseAmount);
        printTickets(tickets);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);

        WinningResult winningResult = checkWinning(tickets, winningNumbersObject, purchaseAmount);
        printResult(winningResult);
    }

    private long inputPurchaseAmount() {
        while (true) {
            try {
                long purchaseAmount = InputView.inputLottoPurchaseAmount();
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        while (true) {
            if (purchaseAmount <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1 이상의 정수여야 합니다.");
            }
            if (purchaseAmount % LottoTicket.PRICE != 0) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 한 장의 가격은 " + LottoTicket.PRICE + "원 입니다. 구입 금액을 다시 입력해 주세요.");
            }
            if (purchaseAmount > Integer.MAX_VALUE * (long) LottoTicket.PRICE) {
                throw new IllegalArgumentException(
                        "[ERROR] 구입 금액은 " + Integer.MAX_VALUE * LottoTicket.PRICE + " 이하의 값이어야 합니다.");
            }
            break;
        }
    }

    private List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = InputView.inputWinningNumbers();
                validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = InputView.inputBonusNumber();
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        while (true) {
            if (numbers.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호가 비어 있습니다.");
            }

            if (numbers.size() != WinningNumbers.WINNING_NUMBER_COUNT) {
                throw new IllegalArgumentException(
                        "[ERROR] 당첨 번호는 " + WinningNumbers.WINNING_NUMBER_COUNT + "개 입력해야 합니다.");
            }

            Set<Integer> uniqueNumbers = new HashSet<>();
            for (Integer number : numbers) {
                if (number < LottoMachine.LOTTO_MIN_NUMBER || number > LottoMachine.LOTTO_MAX_NUMBER) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 수이어야 합니다.");
                }

                if (uniqueNumbers.contains(number)) {
                    throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
                }

                uniqueNumbers.add(number);
            }
            break;
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        while (true) {
            String bonusNumberString = String.valueOf(bonusNumber).trim();
            if (bonusNumberString.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
            }

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 수이어야 합니다.");
            }

            if (bonusNumberString.length() != 1 && bonusNumberString.length() != 2) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개만 입력해야 합니다.");
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            break;
        }
    }

    private void printTickets(List<LottoTicket> tickets) {
        OutputView.printTickets(tickets);
    }

    private void printResult(WinningResult winningResult) {
        OutputView.printResult(winningResult);
    }

    private List<LottoTicket> purchaseTickets(long purchaseAmount) {
        long ticketCount = purchaseAmount / LottoTicket.PRICE;
        return IntStream.range(0, (int) ticketCount)
                .mapToObj(i -> lottoMachine.issueTicket())
                .collect(Collectors.toList());
    }

    private WinningResult checkWinning(List<LottoTicket> tickets, WinningNumbers winningNumbers, long purchaseAmount) {
        WinningResult winningResult = new WinningResult(purchaseAmount);
        for (LottoTicket ticket : tickets) {
            int matchCount = winningNumbers.calculateMatchCount(ticket.getLotto());
            boolean matchBonus = winningNumbers.isMatchBonus(ticket.getLotto());
            Prize prize = Prize.valueOf(matchCount, matchBonus);
            winningResult.incrementPrizeCount(prize);
        }
        return winningResult;
    }
}