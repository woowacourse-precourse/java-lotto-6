package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputResolver {
    private final InputValidator inputValidator = new InputValidator();
    public int inputLottoBuy() {
        do {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return inputValidator.validateAndReturnLottoInput(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] " + e);
            }
        } while (true);
    }

    public List<Integer> inputWinningNumber() {
        do {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                return inputValidator.validateAndReturnWinningNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] " + e);
            }
        } while (true);
    }


}
