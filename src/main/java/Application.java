import controller.LottoController;
import service.LottoMachine;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine();

        LottoController lottoController = new LottoController(inputView, resultView, lottoMachine);

        lottoController.play();
    }
}
