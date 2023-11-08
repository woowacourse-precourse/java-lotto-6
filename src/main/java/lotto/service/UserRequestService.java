package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.Converter;
import lotto.util.Exception;
import lotto.view.InputView;
import lotto.view.OutputView;

// 유저로부터 입력값을 받아 예외를 처리해주는 클래스
// 1. 로또 금액에 대해 입력 받고 예외를 불러와 검증을 시작하는 메서드
// 2. 당첨 로또 번호를 입력 받고 예외를 불러와 검증을 시작하는 메서드
// 3. 당첨 보너스 번호를 입력 받고 예외를 불러와 검증을 시작하는 메서드

public class UserRequestService {
    public static int requestLottoCostWithException() {
        OutputView.printRequestLottoPrice();
        String input = InputView.requestPrice();
        return Exception.lottoCostException(input);
    }

    public static Lotto requestWinningLottoWithException() {
        OutputView.printRequestWinningNumbers();
        List<Integer> winningNumbers = Converter.toIntegerList(InputView.requestWinningNumber());
        return Exception.winningLottoException(winningNumbers);
    }

    public static int requestBonusNumberWithException(List<Integer> winningNumbers) {
        OutputView.printRequestBonusNumber();
        int bonusNumber = InputView.requestWinningBonusNumber();
        return Exception.bonusNumberException(bonusNumber, winningNumbers);
    }
}
