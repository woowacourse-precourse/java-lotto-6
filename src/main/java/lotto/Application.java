package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int price = getPrice();

            Lottos lottos = new Lottos(price);
            OutputConsole.print(lottos);

            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            OutputConsole.printResult(lottos, winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int getPrice() {
        OutputConsole.printMessage(OutputConsole.INPUT_PRICE_MESSAGE);
        return InputConsole.inputPrice();
    }

    public static List<Integer> getWinningNumbers() {
        OutputConsole.printMessage(OutputConsole.INPUT_WINNING_NUMBERS_MESSAGE);
        return InputConsole.inputWinningNumbers();
    }

    public static int getBonusNumber() {
        OutputConsole.printMessage(OutputConsole.INPUT_BONUS_NUMBER_MESSAGE);
        return InputConsole.inputBonusNumber();
    }

}
