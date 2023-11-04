package lotto;

import Controller.InputManger;
import Controller.LottoController;
import Model.InputModel;
import VIew.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현\
        InputView inputView = new InputView();
        InputModel inputModel = new InputModel();
        InputManger inputManger = new InputManger(inputView);
        LottoController lottoController = new LottoController(inputManger, inputModel);
        lottoController.run();
    }
}
