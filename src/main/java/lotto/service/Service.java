package lotto.service;

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
		System.out.println(); // 당첨번호 정상 입력 후 보너스 번호 입력 사이 빈줄
		int bonusNumber = getInputBonusNumberForRetry();
		lottoGame.setBonusNumber(bonusNumber);
	}

	public int getInputBonusNumberForRetry() {
		int bonusNumber;
		while(true) {
			try {
				bonusNumber = getInputBonusNumber();
				Validation.validateNumberNotInList(lottoGame.getWinningNumbers(), bonusNumber);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.CONTAIN_ALREADY.message());
			}
		}
		return bonusNumber;
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
		System.out.println();
	}
	
	public Lotto generateLotto() {
		List<Integer> numbers = Utils.generateUniqueNumberListInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_SIZE);
		Utils.sortListAscendingOrder(numbers);
		return new Lotto(numbers);
	}
	
	public int getInputAmount() {
		int paid;
		while(true) {  // 구입 가능 최대 금액 이상이면 재시도
			try {
				paid = validateDividableForRetry();
				Validation.validateBuyableAmount(paid, LIMITED_AMOUNT);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.TOO_MUCH.message());
			}
		}
		return paid;
	}

	public int validateDividableForRetry() {
		int paid;
		while(true) {  // 구매금액이 로또 가격 단위가 아니면 재시도
			try {
				String input = validateInputAmountNaturalNumberForRetry();
				paid = Integer.valueOf(input);
				Validation.validateDividablePaid(paid, LOTTO_PRICE);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.INDIVISIBLE.message());
			}
		}
		return paid;
	}

	public String validateInputAmountNaturalNumberForRetry() {
		String input;
		while(true) {  // 구매금액 입력값이 숫자가 아니면 재시도
			try {
				InputView.inputAmount();
				input = Console.readLine().trim();
				Validation.validateNaturalNumber(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.NOT_NUMBER.message());
			}
		}
		return input;
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
		while (true) {   //  당첨번호가 유효한 범위 안의 숫자가 아닐 경우 재시도
			try {
				String input = validateInputFormatForRetry();
				numbers = Utils.stringToIntegerList(input);
				Validation.validateListNumbersInRange(numbers, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.OUT_OF_RANGE.message());
			}
		}
		return numbers;
	}

	public String validateInputFormatForRetry() {
		String input;
		while (true) {  // 당첨번호의 입력값이 유효하지 않을 경우 재시도
			try {
				InputView.inputWinningNumbers();
				input = Console.readLine().trim();
				Validation.validateInputFormat(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.INVALID_FORMAT.message());
			}
		}
		return input;
	}
	
	public int getInputBonusNumber() {
		int bonusNumber;
		while(true) {  // 보너스 번호가 유효한 범위 안의 숫자가 아닐 경우 재시도
			try {
				String input = validateNaturalNumberForRetry();
				bonusNumber = Integer.valueOf(input);
				Validation.validateNumberInRange(bonusNumber, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.OUT_OF_RANGE.message());
			}
		}
		return bonusNumber;
	}

	public String validateNaturalNumberForRetry() {
		String input;
		while(true) {  // 보너스 번호의 입력값이 숫자가 아닐 경우 재시도
			try {
				InputView.inputBonusNumber();
				input = Console.readLine().trim();
				Validation.validateNaturalNumber(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorView.NOT_NUMBER.message());
			}
		}
		return input;
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
