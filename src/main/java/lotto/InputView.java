package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static String getUserInput() {
        return Console.readLine();
    }

    public static PurchasePrice inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String userInput = getUserInput();
            int userIntegerInput = Integer.parseInt(userInput);
            return new PurchasePrice(userIntegerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 정수로 입력해야 합니다.");
        }
    }

    public static WinningNumber inputWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String userInputSeperated : userInput.split(",")) {
            LottoNumber lottoNumber = toLottoNumber(userInputSeperated);
            lottoNumbers.add(lottoNumber);
        }

        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        String userInputBonusNumber = Console.readLine();
        LottoNumber bonusLottoNumber = toLottoNumber(userInputBonusNumber);
        return new WinningNumber(lottoNumbers, bonusLottoNumber);
    }

    private static LottoNumber toLottoNumber(String userInputNumber) {
        try {
            int number = Integer.parseInt(userInputNumber);
            return new LottoNumber(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}