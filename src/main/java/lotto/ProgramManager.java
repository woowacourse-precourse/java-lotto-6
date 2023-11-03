package lotto;

import java.util.ArrayList;
import java.util.List;

public class ProgramManager {
	InputView inputView;
	OutputView outputView;
	ProgramManager() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	void startProgram() {

		int price = getPrice();
		showAmount(price);
		List<Lotto> lottoList = showBuyLotto(price);
		Customer customer = new Customer(price, lottoList);

		Lotto winningNumberLotto = getLottoNumber();
		int bonusNumber = getBonusNumber();
		LottoHost lottoHost = new LottoHost(winningNumberLotto, bonusNumber);
		showResult();
	}

	int getPrice() {
		return inputView.getPrice();
	}

	void showAmount(int price) {
		outputView.showAmount(price/1000);
	}

	List<Lotto> showBuyLotto(int price) {
		outputView.showAmount(price/1000);

		List<Lotto> lottoList = new ArrayList<>();
		LottoHost lottoHost = new LottoHost();

		List<Integer> numberList = lottoHost.makeRandomLottoNumber();
		Lotto lotto = new Lotto(numberList);
		lottoList.add(lotto);

		outputView.showBuyLottoNumber(lottoList);

		return lottoList;
	}

	Lotto getLottoNumber() {
		String number = inputView.getLottoNumber();
		String[] numberArray = number.split(",");
		List<Integer> numberList = new ArrayList<>();
		for(String num : numberArray) {
			numberList.add(Integer.parseInt(num));
		}

		Lotto lotto = new Lotto(numberList);

		return lotto;
	}

	int getBonusNumber() {
		int bonusNumber = inputView.getBonusNumber();
		return bonusNumber;
	}

	void showResult() {

	}
}
