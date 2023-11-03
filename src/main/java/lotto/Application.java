package lotto;

import lotto.controller.LottoGameController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // 설정
        OutputView outputView = new OutputView();
        LottoGameController controller = new LottoGameController(outputView);
        // 실행
        controller.run();
    }
}
