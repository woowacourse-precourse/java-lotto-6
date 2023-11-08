package View;

import Controller.ModelHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private ModelHandler model = ModelHandler.getInstance();

    private InputView() {
    }

    private class Singleton {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return Singleton.INSTANCE;
    }

    public void inputPrice() {
        System.out.println(ViewString.INPUT_PRICE_NOTIFICATION);
        int price = Integer.parseInt(Console.readLine());
        model.setPrice(price);
    }

    public String inputWinningNumber() {
        System.out.println(ViewString.INPUT_WINNING_NUMBER_NOTIFICATION);
        return Console.readLine();
    }

    public int inputBonusNumber() {
        System.out.println(ViewString.INPUT_BONUS_NUMBER_NOTIFICATION);
        return Integer.parseInt(Console.readLine());
    }
}
