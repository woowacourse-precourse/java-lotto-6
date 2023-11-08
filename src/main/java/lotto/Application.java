package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int price = getPrice();

            Lottos lottos = buyLottos(price);

            WinningLotto winningLotto = drawWinnerLotto();

            OutputConsole.printResult(lottos, winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getPrice() {
        OutputConsole.printMessage(Message.INPUT_PRICE_MESSAGE);
        return InputConsole.inputPrice();
    }

    public static List<Integer> getWinningNumbers() {
        OutputConsole.printMessage(Message.INPUT_WINNING_NUMBERS_MESSAGE);
        return InputConsole.inputWinningNumbers();
    }

    public static int getBonusNumber() {
        OutputConsole.printMessage(Message.INPUT_BONUS_NUMBER_MESSAGE);
        return InputConsole.inputBonusNumber();
    }

    public static Lottos buyLottos(int price) {
        Lottos lottos = new Lottos(price);
        OutputConsole.print(lottos);
        return lottos;
    }

    public static WinningLotto drawWinnerLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

}
