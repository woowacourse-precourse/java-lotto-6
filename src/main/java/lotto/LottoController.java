package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    Validator validator = new Validator();
    static final String INPUT_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    int getInput() {
        int parsedInput;

        String input = Console.readLine();

        while (true) {
            try {
                parsedInput = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }

        return parsedInput;
    }

    // 구입금액 입력받아서 정수형으로 변환 후 반환
    int getCash() {
        int cash;
        int validCash;

        cash = getInput();

        while (true) {
            try {
                validCash = validator.validateCash(cash);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액은 1000원 단위이여야 합니다.");
            }
        }

        return validCash;
    }

    void purchaseLotto(int purchaseAmount) {
        System.out.printf("%d개를 구매했습니다.", purchaseAmount);

    }
}
