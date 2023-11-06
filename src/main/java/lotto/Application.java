package lotto;

import lotto.controller.Controller;
import lotto.domain.RandomNumberGenerator;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoServiceImpl(new RandomNumberGenerator());
        View view = new View();
        Controller controller = new Controller(lottoService, view);
        controller.play();
    }
}
