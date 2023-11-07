package lotto;

import java.util.List;

public class Controller {

    public final InputView inputView;
    public final Service service;
    public final OutputView outputView;

    public Controller(InputView inputView, Service service, OutputView outputView) {
        this.inputView = inputView;
        this.service = service;
        this.outputView = outputView;
    }

    public void start() {
        InputDTO inputDTO = inputView.getUserInput();
        List<Lotto> lottos = service.publishLotto(inputDTO);
        outputView.printLottos(lottos);
        List<Integer> results = service.start(lottos);
        outputView.printResult(results);
    }
}
