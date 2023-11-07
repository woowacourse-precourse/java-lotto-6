package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
	private final InputView inputView;

	private final OutputView outputView;

	private final LottoService lottoService;

	public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.lottoService = lottoService;
	}

	public void start() {
		int price = inputView.inputPrice();

		List<Lotto> lottos = lottoService.getLottos();
		outputView.printLottos(lottos);

		List<Integer> numbers = inputView.inputNumbers();
		int bonusNumber = inputView.inputBonusNumber();

		Map<Integer, Integer> results = getResults(lottos, numbers, bonusNumber);

		printResults(results);

		outputView.printReturnRate(lottoService.calculateReturnRate(results, price));
	}

	private Map<Integer, Integer> getResults(List<Lotto> lottos, List<Integer> numbers, int bonusNumber) {
		Map<Integer, Integer> results = new HashMap<>();

		for (Lotto lotto : lottos) {
			int result = lottoService.getResult(lotto, numbers, bonusNumber);

			results.put(result, results.getOrDefault(result, 0) + 1);
		}

		return results;
	}

	private void printResults(Map<Integer, Integer> results) {
		for (int i = 3; i < 6; i++) {
			outputView.printResult(i, results.getOrDefault(i, 0));
		}
		outputView.printBonusResult(results.getOrDefault(7, 0));
		outputView.printResult(6, results.getOrDefault(6, 0));
	}
}