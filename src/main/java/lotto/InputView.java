package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static String getUserInput() {
        return Console.readLine();
    }

    public static PurchasePrice inputPurchasePrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String userInput = getUserInput();
            return new PurchasePrice(inputToNumber(userInput));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputPurchasePrice();
        }
    }

    public static WinningNumber inputWinningNumber() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String userInput = Console.readLine();
            List<LottoNumber> lottoNumbers = new ArrayList<>();
            for (String userInputSeperated : userInput.split(",")) {
                LottoNumber lottoNumber = toLottoNumber(userInputSeperated);
                lottoNumbers.add(lottoNumber);
            }

            LottoNumber bonusLottoNumber = inputBonusNumber();
            return new WinningNumber(lottoNumbers, bonusLottoNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputWinningNumber();
        }
    }

    private static LottoNumber inputBonusNumber() {
        try {
            System.out.println("\n보너스 번호를 입력해주세요.");
            String userInputBonusNumber = Console.readLine();
            return toLottoNumber(userInputBonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static LottoNumber toLottoNumber(String userInputNumber) {
        int number = inputToNumber(userInputNumber);
        return new LottoNumber(number);
    }

    private static int inputToNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}