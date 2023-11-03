package lotto;

import controller.InputMan;
import controller.MainController;
import model.ProfitCalculator;
import validation.ValidationMan;
import view.Mainview;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        MainController controller = new MainController(new Mainview(), new ValidationMan(), new ProfitCalculator());
        controller.turnOn();
    }
}
