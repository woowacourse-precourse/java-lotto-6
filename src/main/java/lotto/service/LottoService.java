package lotto.service;

import lotto.domain.LottoTicket;
import lotto.exception.PurchaseExceptionMessage;
import lotto.exception.WinningNumberExceptionMessage;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoTicket lottoTicket = new LottoTicket();

    public int displayPurchase() {
        InputView.printPurchasePrompt();

        while (true) {
            try {
                String purchaseAmountView = InputView.getPurchaseAmountView();

                // 숫자인지 검증
                PurchaseExceptionMessage.validateIsNumeric(purchaseAmountView);

                int price = Integer.parseInt(purchaseAmountView);

                // 1,000단위인지 검증
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

                // 로또 번호 형식 검사
                WinningNumberExceptionMessage.validateLottoNumberFormat(winningNumberView);

                // ','를 기준으로 분리하고 숫자로 변환
                List<Integer> winningNumbers = changeInputToString(winningNumberView);

                // 로또 번호 길이 검사
                WinningNumberExceptionMessage.validateWinningNumberLength(winningNumbers);

                // 중복된 로또 번호 검사
                WinningNumberExceptionMessage.validateDuplicateWinningNumber(winningNumbers);

                // 로또 번호 범위 검사
                WinningNumberExceptionMessage.validateBoundaryWinningNumber(winningNumbers);

                return winningNumbers;  // 모든 검증이 통과되면 winningNumbers 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> changeInputToString(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)  // 공백 제거
                .map(Integer::parseInt)  // String을 int로 변환
                .collect(Collectors.toList());  // List로 변환
    }
}
