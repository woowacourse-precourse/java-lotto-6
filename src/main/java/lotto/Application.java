package lotto;

import lotto.controller.LottoController;
import lotto.dto.LottoDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoDto lottoDto = new LottoDto();
        LottoController lottoController = new LottoController(inputView, outputView, lottoDto);
        lottoController.play();
    }
}
