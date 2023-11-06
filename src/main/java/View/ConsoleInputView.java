package View;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public String inputPuchasePrice() {
        String userInput = Console.readLine();
        validateUnderThousand(userInput);
        validateMulitpleOfThousand(userInput);
        return userInput;
    }

    @Override
    public String inputPrizeNumbers() {
        String userInput = Console.readLine();
        return userInput;
    }

    @Override
    public String inputBonusNumber() {
        String userInput = Console.readLine();
        return userInput;
    }

    private void validateUnderThousand(String userInput) {
        if (Integer.parseInt(userInput) < 1000) {
            throw new IllegalArgumentException("최소 구매가능 금액은 1000원 입니다.");
        }
    }

    private void validateMulitpleOfThousand(String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException("구매금액은 1,000단위로 입력하여야 합니다.");
        }
    }

}
