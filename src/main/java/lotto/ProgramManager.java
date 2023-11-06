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
		// 구매 금액 입력
		int price = getPrice();

		// 구매내역 출력
		showAmount(price);
		List<Lotto> lottoList = showBuyLotto(price);
		Customer customer = new Customer(price, lottoList);

		// 당첨 번호 입력
		Lotto winningNumberLotto = getLottoNumber();
		int bonusNumber = getBonusNumber(winningNumberLotto);
		LottoHost.getInstance().setWinningNumberLotto(winningNumberLotto);
		LottoHost.getInstance().setBonusNumber(bonusNumber);
		showResult(LottoHost.getInstance(), customer);
	}

	int getPrice() {
		return inputView.getPrice();
	}

	void showAmount(int price) {
		outputView.showAmount(price/1000);
	}

	List<Lotto> showBuyLotto(int price) {
		List<Lotto> lottoList = new ArrayList<>();
		LottoHost lottoHost = LottoHost.getInstance();
		int numberOfBuyingLotto = price/1000;

		while (numberOfBuyingLotto > 0) {
			List<Integer> numberList = lottoHost.makeRandomLottoNumber();
			Lotto lotto = new Lotto(numberList);
			lottoList.add(lotto);
			numberOfBuyingLotto--;
		}

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

	int getBonusNumber(Lotto winningLotto) {
		int bonusNumber = inputView.getBonusNumber(winningLotto);
		return bonusNumber;
	}

	void showResult(LottoHost lottoHost, Customer customer) {
		// 결과 생성
		List<Integer> resultList = compareLotte(lottoHost, customer);
		// 결과 출력
		outputView.printResult(resultList);
		// 수익률 계산 출력
		outputView.printRate(calcRate(resultList, customer));
	}

	List<Integer> compareLotte(LottoHost lottoHost, Customer customer) {
		List<Integer> resultList = lottoHost.compareLottoNumber(customer.getLottoList());
		return resultList;
	}

	double calcRate(List<Integer> resultList, Customer customer) {
		int prizeMoney = calcPrizeMoney(resultList);
		int buyMoney = customer.getPrice();

		return ((double)prizeMoney / (double)buyMoney) * 100;
	}

	int calcPrizeMoney(List<Integer> resultList) {
		return (resultList.get(0)*5000
			+ resultList.get(1)*50000
			+ resultList.get(2)*1500000
			+ resultList.get(3)*30000000
			+ resultList.get(4)*2000000000);
	}
}
