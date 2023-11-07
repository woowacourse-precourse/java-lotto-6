package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
	public static void main(String[] args) {
		OutputView outputView = new OutputView();
		InputView inputView = new InputView(outputView);
		LottoRepository lottoRepository = new LottoRepository();
		LottoService lottoService = new LottoService(lottoRepository);
		LottoController lottoController = new LottoController(inputView, outputView, lottoService);

		lottoController.start();
	}
}