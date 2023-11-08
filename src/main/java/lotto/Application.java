package lotto;

import lotto.controller.GameController;
import lotto.domain.LottoRepository;
import lotto.domain.LottoService;
import lotto.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService model = new LottoService(new LottoRepository());
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        controller.run();

    }
}
