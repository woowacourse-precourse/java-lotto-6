package lotto;

import controller.LottoController;
import model.LottoModel;
import view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoModel model = new LottoModel();
        LottoView view = new LottoView();
        LottoController controller = new LottoController(model, view);

        controller.run();
    }
}
