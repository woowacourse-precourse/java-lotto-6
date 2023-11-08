package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.constant.Constant;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ProgramManager {
	InputView inputView;
	OutputView outputView;

	ProgramManager() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	/*
	 * 로또 프로그램 시작.
	 * 구매급액 입력 > 구매내역 출력 > 당첨번호/보너스번호 입력 > 결과출력
	 */
	void startProgram() {
		int price = getPrice();

		showAmount(price);
		List<Lotto> lottoList = showBuyLotto(price);
		Customer customer = new Customer(price, lottoList);

		Lotto winningNumberLotto = getLottoNumber();
		int bonusNumber = getBonusNumber(winningNumberLotto);
		setLottoHostInstance(winningNumberLotto, bonusNumber);

		showResult(LottoHost.getInstance(), customer);
	}

	int getPrice() {
		return inputView.getPrice();
	}

	void showAmount(int price) {
		outputView.showAmount(price / Constant.LOTTO_PRICE);
	}

	List<Lotto> showBuyLotto(int price) {
		List<Lotto> lottoList = new ArrayList<>();
		LottoHost lottoHost = LottoHost.getInstance();
		int numberOfBuyingLotto = price / Constant.LOTTO_PRICE;

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
		List<String> inputList = Arrays.asList(number.split(Constant.COMMA));
		return new Lotto(inputList.stream()
			.map(s -> Integer.parseInt(s))
			.collect(Collectors.toList()));
	}

	int getBonusNumber(Lotto winningLotto) {
		return inputView.getBonusNumber(winningLotto);
	}

	void setLottoHostInstance(Lotto winningNumberLotto, int bonusNumber) {
		LottoHost.getInstance().setWinningNumberLotto(winningNumberLotto);
		LottoHost.getInstance().setBonusNumber(bonusNumber);
	}

	void showResult(LottoHost lottoHost, Customer customer) {
		List<Integer> resultList = compareLotte(lottoHost, customer);
		outputView.printResult(resultList);
		outputView.printRate(calcRate(resultList, customer));
	}

	List<Integer> compareLotte(LottoHost lottoHost, Customer customer) {
		return lottoHost.compareLottoNumber(customer.getLottoList());
	}

	double calcRate(List<Integer> resultList, Customer customer) {
		int prizeMoney = calcPrizeMoney(resultList);
		int buyMoney = customer.getPrice();
		return ((double)prizeMoney / (double)buyMoney) * Constant.ONE_HUNDRED;
	}

	int calcPrizeMoney(List<Integer> resultList) {
		return resultList.get(0) * Constant.FIFTH_PRIZE_MONEY
			+ resultList.get(1) * Constant.FOURTH_PRIZE_MONEY
			+ resultList.get(2) * Constant.THIRD_PRIZE_MONEY
			+ resultList.get(3) * Constant.SECOND_PRIZE_MONEY
			+ resultList.get(4) * Constant.FIRST_PRIZE_MONEY;
	}
}
