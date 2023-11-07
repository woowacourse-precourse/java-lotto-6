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

    public int inputPrice() {
        return Integer.parseInt(Console.readLine());
    }

    public String inputWinningNumber() {
        return Console.readLine();
    }

    public void inputBonusNumber() {

    }
}
