package lotto;

import lotto.controller.Input;
import lotto.controller.LottoController;
import lotto.service.Calculation;
import lotto.service.LottoService;
import lotto.start.LottoGame;
import lotto.view.Exception;
import lotto.view.ExceptionView;
import lotto.view.LottoView;
import lotto.view.LottoViewV2;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Output view = new LottoView();
        Exception exception = new ExceptionView();
        Calculation lottoService = new LottoService();

        // DI를 적용해서 친근한 버전의 view를 만들어 생성자의 매개변수만 바꾸면 적용되는 코드를 제작했습니다.
//        Output viewFriendly = new LottoViewV2();
//        Input controller = new LottoController(viewFriendly,exception,lottoService);

        Input controller = new LottoController(view,exception,lottoService);
        LottoGame lottoGame = new LottoGame(controller);

        lottoGame.run();
    }
}
