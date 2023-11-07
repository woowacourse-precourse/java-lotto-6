package lotto;

import camp.nextstep.edu.missionutils.Console;

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

    public void inputWinningNumber() {}
}
