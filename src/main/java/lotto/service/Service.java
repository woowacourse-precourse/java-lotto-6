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
	
	public static final int LOTTO_RANGE_MIN = 1;
	public static final int LOTTO_RANGE_MAX = 45;
	public static final int LOTTO_SIZE = 6;
	public static final int LOTTO_PRICE = 1_000;
	public static final int LIMITED_AMOUNT = 100_000;
	private static final long NOT_WINNING_PRIZE = 0;
	
	Buyer buyer;
	LottoGame lottoGame;
	
	public void goLottoGame() {
		lottoGame = new LottoGame(getInputWinningNumbers());
		System.out.println();
		int bonusNumber = getInputBonusNumberForRetry();
		lottoGame.setBonusNumber(bonusNumber);
	}

	public int getInputBonusNumberForRetry() {
		int bonusNumber;
		while(true) {
			try {  // 입력된 보너스 번호값이 적절하지 않은 경우 재시도 
				InputView.inputBonusNumber();
				String input = Console.readLine().trim();
				bonusNumber = validateBonusNumber(input);
				Validation.validateNumberNotInList(lottoGame.getWinningNumbers(), bonusNumber);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.BONUS_NUMBER_ERROR.message());
			}
		}
		return bonusNumber;
	}
	
	public void initBuyer() {
		buyer = new Buyer(getInputAmount());
		buyer.initLottoResult();
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
		numbers = Utils.generateUniqueNumberListInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_SIZE);
		Utils.sortListAscendingOrder(numbers);
		return new Lotto(numbers);
	}
	
	public int getInputAmount() {
		int paid;
		while(true) {  // 구입금액이 적절하지 않은 경우 재시도
			try {
				InputView.inputAmount();
				String input = Console.readLine().trim();
				paid = validateInputAmount(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.AMOUNT_ERROR.message());
			}
		}
		return paid;
	}

	public int validateInputAmount(String input) {
		int paid;
		Validation.validateNaturalNumber(input);
		paid = Integer.valueOf(input);
		Validation.validateDividablePaid(paid, LOTTO_PRICE);
		Validation.validateBuyableAmount(paid, LIMITED_AMOUNT);
		return paid;
	}
	
	public List<Integer> getInputWinningNumbers() {
		Lotto lotto;
		while(true) { // 로또 클래스 생성자 검증을 통해 유효한 당첨번호 형식이 아닐 경우 재시도
			try {
				lotto = new Lotto(validateNumbersRangeForRetry());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.NOT_LOTTO.message());
			}
		}
		return lotto.getNumbers();
	}

	public List<Integer> validateNumbersRangeForRetry() {
		List<Integer> numbers;
		while (true) {   //  당첨번호가 유효한 입력값이 아닐 경우 재시도
			try {
				InputView.inputWinningNumbers();
				String input = Console.readLine().trim();
				numbers = validateInputWinningNumbers(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.INVALID_FORMAT.message());
			}
		}
		return numbers;
	}

	public List<Integer> validateInputWinningNumbers(String input) {
		List<Integer> numbers;
		Validation.validateInputFormat(input);
		numbers = Utils.stringToIntegerList(input);
		Validation.validateListNumbersInRange(numbers, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
		return numbers;
	}

	public int validateBonusNumber(String input) {
		int bonusNumber;
		Validation.validateNaturalNumber(input);
		bonusNumber = Integer.valueOf(input);
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
