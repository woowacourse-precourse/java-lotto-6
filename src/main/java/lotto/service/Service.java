package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.*;

public class Service {
	
	public static final int LOTTO_PRICE = 1_000;
	public static final int LIMITED_AMOUNT = 100_000;
	private static final long NOT_WINNING_PRIZE = 0;
	
	Buyer buyer;
	LottoGame lottoGame;
	
	public void goLottoGame() {
		InputWinningNumbers();
		System.out.println();
		int bonusNumber = getInputBonusNumber();
		lottoGame.setBonusNumber(bonusNumber);
	}

	public int getInputBonusNumber() {
		int bonusNumber;
		while(true) {
			try {  // 입력된 보너스 번호값이 적절하지 않은 경우 재시도 
				InputView.inputBonusNumber();
				String input = Console.readLine().trim();
				bonusNumber = LottoGame.validateBonusNumber(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.BONUS_NUMBER_ERROR.message());
			}
		}
		return bonusNumber;
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
		System.out.println();
	}
	
	public Lotto generateLotto() {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers = Utils.generateUniqueNumberListInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.SIZE);
		Utils.sortListAscendingOrder(numbers);
		return new Lotto(numbers);
	}
	
	public void initBuyer() {
		buyer = new Buyer(getInputAmount());
	}
	
	public int getInputAmount() {
		int paid;
		while(true) {  // 구입금액이 적절하지 않은 경우 재시도
			try {
				InputView.inputAmount();
				String input = Console.readLine().trim();
				paid = Validation.validateNaturalNumber(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.AMOUNT_ERROR.message());
			}
		}
		return paid;
	}

	
	public void InputWinningNumbers() {
		while(true) { // 로또 생성자 검증을 통해 유효한 형식이 아닐 경우 재시도
			try {
				InputView.inputWinningNumbers();
				String input = Console.readLine().trim();
				List<Integer> numbers = Utils.stringToIntegerList(input);
				lottoGame = new LottoGame(numbers);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.NOT_LOTTO.message());
			}
		}
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
		OutputView.printYieldRate(buyer.getYield());
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
