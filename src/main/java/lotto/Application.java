package lotto;


import lotto.controller.Controller;
import lotto.view.Input;
import lotto.view.Output;

public class Application {


    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        Controller controller = new Controller(input, output);

        controller.lottoGame();
    }


}
