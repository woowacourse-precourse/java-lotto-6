package View;

import Controller.ModelHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private ModelHandler moder = ModelHandler.getInstance();

    private InputView() {}

    private class Singleton {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return Singleton.INSTANCE;
    }

    public void inputPrice() {
        int price = Integer.parseInt(Console.readLine());
    }

    public void inputWinningNumber() {

    }

    public void inputBonusNumber() {

    }
}
