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
                userInputException.lottoPriceInputValidate(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return Console.readLine();
    }

    public String lottoWinningNumberInput() {
        return Console.readLine();
    }

    public String bonusNumberInput() {
        return Console.readLine();
    }
}
