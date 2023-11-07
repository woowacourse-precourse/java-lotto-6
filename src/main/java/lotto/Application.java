package lotto;

import Controller.InputManager;
import Controller.LottoController;
import VIew.InputView;
import VIew.LottoView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현\
        InputManager inputManger = new InputManager();
        LottoController lottoController = new LottoController(inputManger);
        lottoController.run();
    }
}
