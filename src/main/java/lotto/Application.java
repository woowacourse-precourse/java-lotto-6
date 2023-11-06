package lotto;

import lotto.controller.LottoGameController;
import lotto.view.ErrorView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // 설정
        OutputView outputView = new OutputView();
        ErrorView errorView = new ErrorView();
        LottoGameController controller = new LottoGameController(outputView, errorView);
        // 실행
        controller.run();
    }
}
