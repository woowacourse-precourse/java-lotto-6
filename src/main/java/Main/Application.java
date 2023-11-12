package Main;

import Controller.ControllerFacade;
import Controller.ControllerFacade;
import View.BoardView;
import View.Concrete.BoardTextView;
import View.Concrete.InputTextView;
import View.Concrete.LottoTextView;
import View.InputView;
import View.LottoView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputTextView();
        BoardView boardView = new BoardTextView();
        LottoView lottoView = new LottoTextView();

        ControllerFacade lottoGame = new ControllerFacade(inputView, boardView, lottoView);
        lottoGame.run();
    }
}