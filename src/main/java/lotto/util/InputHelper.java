package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningNumbers;
import lotto.io.InputAdaptor;
import lotto.io.OutputAdaptor;

import java.util.List;

/**
 * 사용자 입력에 관련된 로직을 묶은 클래스.
 */
public class InputHelper {

    /**
     * 로또 구입 금액을 입력받는다.
     * 명세에 맞지 않는 입력을 받을 경우 에러 메시지를 출력하며 에러를 유발한 입력으로 돌아가 다시 입력받는다.
     * @return 로또 구입 금액. 1,000원 단위의 정수이다.
     */
    public static int numOfLottoToBuy() {
        try {
            return LottoGenerator.calculateNumOfLotto(inputPurchasePrice());
        } catch (IllegalArgumentException e) {
            OutputAdaptor.displayErrorMessage(e.getMessage());
            return numOfLottoToBuy();
        }
    }

    private static int inputPurchasePrice() {
        try {
            OutputAdaptor.displayMessageToPromptToInputPurchasePrice();
            return InputAdaptor.readPurchasePrice();
        } catch (IllegalArgumentException e) {
            OutputAdaptor.displayErrorMessage(e.getMessage());
            return inputPurchasePrice();
        }
    }

    /**
     * 당첨 번호를 입력받는다.
     * 명세에 맞지 않는 입력을 받을 경우 에러 메시지를 출력하며 에러를 유발한 입력으로 돌아가 다시 입력받는다.
     * @return 입력받은 당첨 번호를 담은 WinningNumbers 인스턴스.
     */
    public static WinningNumbers winningNumbers() {
        Lotto winningNumbers = getWinningNumbersWithoutBonusNumber();
        return getWinningNumbersWithBonusNumber(winningNumbers);
    }

    private static Lotto getWinningNumbersWithoutBonusNumber() {
        try {
            return new Lotto(inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            OutputAdaptor.displayErrorMessage(e.getMessage());
            return getWinningNumbersWithoutBonusNumber();
        }
    }

    private static List<Integer> inputWinningNumbers() {
        try {
            OutputAdaptor.displayMessageToPromptToInputWinningNumbers();
            return InputAdaptor.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputAdaptor.displayErrorMessage(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private static WinningNumbers getWinningNumbersWithBonusNumber(Lotto winningNumbers) {
        try {
            return new WinningNumbers(winningNumbers, inputBonusNumber());
        } catch (IllegalArgumentException e) {
            OutputAdaptor.displayErrorMessage(e.getMessage());
            return getWinningNumbersWithBonusNumber(winningNumbers);
        }
    }

    private static int inputBonusNumber() {
        try {
            OutputAdaptor.displayMessageToPromptToInputBonusNumber();
            return InputAdaptor.readBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputAdaptor.displayErrorMessage(e.getMessage());
            return inputBonusNumber();
        }
    }
}
