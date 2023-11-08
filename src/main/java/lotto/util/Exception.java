package lotto.util;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.UserRequestService;

public class Exception {
    public static int lottoCostException(String input) {
        try {
            Validation.validatePrice(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return UserRequestService.requestLottoCostWithException();
        }
    }

    public static Lotto winningLottoException(List<Integer> winningNumbers) {
        try {
            Validation.validateLottoNumbers(winningNumbers);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return UserRequestService.requestWinningLottoWithException();
        }
    }

    public static int bonusNumberException(int bonusNumber, List<Integer> winningNumbers) {
        try {
            Validation.validateBonusNumber(String.valueOf(bonusNumber), winningNumbers);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return UserRequestService.requestBonusNumberWithException(winningNumbers);
        }
    }
}
