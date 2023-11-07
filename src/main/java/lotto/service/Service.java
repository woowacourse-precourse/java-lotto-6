package lotto.service;

import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Service {
	
	private static final int LOTTO_RANGE_MIN = 1;
	private static final int LOTTO_RANGE_MAX = 45;
	private static final int LOTTO_SIZE = 6;
	private static final int LOTTO_PRICE = 1_000;
	private static final int LIMITED_AMOUNT = 100_000;
	private static final long NOT_WINNING_PRIZE = 0;
	
	Buyer buyer;
	LottoGame lottoGame;
	
	public void goLottoGame() {
		lottoGame = new LottoGame(getInputWinningNumbers());
		int bonusNumber = getInputBonusNumber();
		Validation.validateNumberNotInList(lottoGame.getWinningNumbers(), bonusNumber);
		lottoGame.setBonusNumber(bonusNumber);
	}
	
	public void initBuyer() {
		buyer = new Buyer(getInputAmount());
	}
	
	public void buyOneLotto() {
		Lotto lotto = generateLotto();
		buyer.buyLotto(lotto);
	}
	
	public void buyLotteries() {
		int count = buyer.getPurchaseAmount() / LOTTO_PRICE;
		for (int i = 0; i < count; i++) {
			buyOneLotto();
		}
	}
	
	public void showBuyingResult() {
		OutputView.printCountOfLotto(buyer.getPurchaseAmount() / LOTTO_PRICE);
		for(Lotto lotto : buyer.getPurchasedLotteries()) {
			OutputView.printNumbersOfLotto(lotto.getNumbers());
		}
	}
	
	public Lotto generateLotto() {
		List<Integer> numbers = Utils.generateUniqueNumberListInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_SIZE);
		Utils.sortListAscendingOrder(numbers);
		return new Lotto(numbers);
	}
	
	public int getInputAmount() {
		InputView.inputAmount();
		String input = Console.readLine().trim();
		Validation.validateNaturalNumber(input);
		int paid = Integer.valueOf(input);
		Validation.validateDividablePaid(paid, LOTTO_PRICE);
		Validation.validateBuyableAmount(paid, LIMITED_AMOUNT);
		return paid;
	}
	
	public List<Integer> getInputWinningNumbers() {
		InputView.inputWinningNumbers();
		String input = Console.readLine().trim();
		Validation.validateInputFormat(input);
		List<Integer> numbers = Utils.stringToIntegerList(input);
		Validation.validateListNumbersInRange(numbers, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
		return numbers;
	}
	
	public int getInputBonusNumber() {
		InputView.inputBonusNumber();
		String input = Console.readLine().trim();
		Validation.validateNaturalNumber(input);
		int bonusNumber = Integer.valueOf(input);
		Validation.validateNumberInRange(bonusNumber, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
		return bonusNumber;
	}
	
	public int countCorrectLottoNumber(Lotto lotto) {
		return Utils.countSameNumbers(lotto.getNumbers(), lottoGame.getWinningNumbers());
	}
	
	public boolean isBonusNumberCorrect(Lotto lotto) {
		return lotto.getNumbers().contains(lottoGame.getBonusNumber());
	}
	
	public Rank checkLottoRank(Lotto lotto) {
		int correctCount = countCorrectLottoNumber(lotto);
		boolean isbonus = isBonusNumberCorrect(lotto);
		return Rank.ranking(correctCount, isbonus);
	}
	
	public void countEachRank() {
		buyer.initLottoResult();
		Map<Rank, Integer> lottoResults = buyer.getLottoResult();
		for (Lotto lotto : buyer.getPurchasedLotteries()) {
			int count = (int)lottoResults.get(checkLottoRank(lotto));
			count++;
			lottoResults.put(checkLottoRank(lotto), count);
		}
	}
	
	public void showResultStats() {
		OutputView.printResultIntro();
		showAllRankResult(buyer.getLottoResult());
		OutputView.printYieldRate(buyer.getProfitRate());
	}
	
	public void showAllRankResult(Map<Rank, Integer> map) {
		for(Rank rank : Rank.values()) {
			showOneRankResult(rank, map);
		}
	}
	
	public void showOneRankResult(Rank rank, Map<Rank, Integer> map) {
		if (rank.getPrize() == NOT_WINNING_PRIZE) {
			return;
		}
		if (rank.equals(Rank.SECOND)) {
			OutputView.printSecondRankResult(rank.getCount(), rank.getPrizeText(), map.get(rank));
			return;
		}
		OutputView.printOneRankResult(rank.getCount(), rank.getPrizeText(), buyer.getLottoResult().get(rank));
	}

}
