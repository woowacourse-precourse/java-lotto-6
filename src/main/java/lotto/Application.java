package lotto;

import lotto.utils.converterStringToInteger;
import lotto.utils.sperateByComma;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new converterStringToInteger(),new sperateByComma());
        controller.tempInputOutputController();
    }
}
