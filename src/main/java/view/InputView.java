package view;
import utility.UserInputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    UserInputException userInputException = new UserInputException();

    public String lottoPriceInput() {
        int input = 0;
        while (input == 0) {
            try {
                input = Integer.parseInt(Console.readLine());
                userInputException.lottoPriceValidate(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구입시 천원 단위의 숫자가 입력되어야 합니다.");
            }
        }
        return Console.readLine();
    }

    public String lottoWinningNumberInput() {
        String input = null;
        while (input == null) {
            try {
                input = Console.readLine();
                userInputException.winningNumberValidate(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 당첨 번호는 중복 없는 6자리 입니다.");
            }
        }
        return input;
    }

    public String bonusNumberInput() {
        return Console.readLine();
    }
}
