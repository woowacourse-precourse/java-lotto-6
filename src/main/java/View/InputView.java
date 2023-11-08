package View;

import Controller.ExceptionSentence;
import Controller.ModelHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final ModelHandler MODEL = ModelHandler.getInstance();

    private InputView() {
    }

    private class Singleton {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return Singleton.INSTANCE;
    }

    public void inputPrice() {
        try {
            System.out.println(ViewString.INPUT_PRICE_NOTIFICATION.getSentence());
            int price = Integer.parseInt(Console.readLine());
            MODEL.setPrice(price);
        } catch (NumberFormatException e) {
            System.out.println(ExceptionSentence.TYPE_ERROR.getMessage());
        }
    }

    public void inputWinningNumber() {
        System.out.println(ViewString.INPUT_WINNING_NUMBER_NOTIFICATION.getSentence());
        String winningNumber = Console.readLine();
        MODEL.setWinningNumber(winningNumber);
    }

    public void inputBonusNumber() {
        System.out.println(ViewString.INPUT_BONUS_NUMBER_NOTIFICATION.getSentence());
        int bonusNumber = Integer.parseInt(Console.readLine());
        MODEL.setBonusNumber(bonusNumber);
    }
}
