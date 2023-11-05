package lotto;

import Controller.InputManager;
import Controller.LottoController;
import Model.InputModel;
import VIew.InputView;
import VIew.LottoView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현\
        InputView inputView = new InputView();
        InputModel inputModel = new InputModel();
        InputManager inputManger = new InputManager(inputView);

        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(inputManger, inputModel, lottoView);
        lottoController.run();
    }
}
