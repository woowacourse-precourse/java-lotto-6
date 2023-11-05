package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    private final int lottoTrials;
    private final int bonusNumber;
    private final List<List<Integer>> randomNumbers;

    public Lotto(int lottoTrials, List<Integer> numbers, int bonusNumber) {
        Validation.validatePurchaseAmount(lottoTrials);
        this.lottoTrials = lottoTrials / 1000;
        
        this.randomNumbers = generateRandomLottoNumber(this.lottoTrials);
        LottoPrint.printLottos(this.randomNumbers, this.lottoTrials);
        
        Validation.validate(numbers);
        Validation.validateNumberRange(numbers);
        Validation.validateNumberDuplication(numbers);
        this.numbers = numbers;
        
        Validation.validateNumberRange(bonusNumber);
        Validation.validateNumberDuplication(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
	
	private List<List<Integer>> generateRandomLottoNumber(int lottoTrials) {
		List<List<Integer>> randomNumbers = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < lottoTrials; i++) {
			randomNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
		}
		
		return randomNumbers;
	}
	
	private int checkCorrectNumber(int index, List<Integer> numbers, List<List<Integer>> randomNumbers) {
		int correctNumbers = 0;
		
		for (int i = 0; i < 6; i++) {
			if (numbers.contains(randomNumbers.get(index).get(i))){
				correctNumbers++;
			}
		}
		
		return correctNumbers;
	}
	
	private int getPrize(int correctNumbers, int index, List<Integer> rankCount) {
		if (correctNumbers == 6) {
			rankCount.set(1, rankCount.get(1) + 1);
			return Rank.FIRST.prize();
		} else if (correctNumbers == 5 && randomNumbers.get(index).contains(bonusNumber)) {
			rankCount.set(2, rankCount.get(2) + 1);
			return Rank.SECOND.prize();
		} else if (correctNumbers == 5) {
			rankCount.set(3, rankCount.get(3) + 1);
			return Rank.THIRD.prize();
		} else if (correctNumbers == 4) {
			rankCount.set(4, rankCount.get(4) + 1);
			return Rank.FOURTH.prize();
		} else if (correctNumbers == 3) {
			rankCount.set(5, rankCount.get(5) + 1);
			return Rank.FIFTH.prize();
		}
		return 0;
	}
	
	private List<Integer> initializeCount(){
		List<Integer> rankCount = new ArrayList<Integer>();
		
		for (int i = 0; i < 6; i++) {
			rankCount.add(0);
		}
		
		return rankCount;
	}
	
	protected int calculatePrize(int lottoTrials, List<Integer> numbers, List<List<Integer>> randomNumbers) {
		int prize = 0;
		List<Integer> rankCount = initializeCount();
		
		for (int i = 0; i < lottoTrials; i++) {
			int correctNumbers = checkCorrectNumber(i, numbers, randomNumbers);
			prize += getPrize(correctNumbers, i, rankCount);
		}
		
		double ratio = calculateReturnRatio(prize, lottoTrials);
		LottoPrint.printResult(rankCount, ratio);
		
		return prize;
	}
	
	protected double calculateReturnRatio(int prize, int lottoTrials) {
		double ratio = Math.round(prize / lottoTrials) / 10.0;
		
		return ratio;
	}
	
	protected void lottoPlay() {
		calculatePrize(this.lottoTrials, this.numbers, this.randomNumbers);
	}
}
