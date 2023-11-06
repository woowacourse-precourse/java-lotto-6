package dto;

import java.util.List;

import model.BonusNumber;
import model.Lotto;

public class BuyLottoBonusDto {

	private final static int FIRST_CLASS = 6;
	private final static int SECOND_CLASS = 5;
	private final static int THIRD_CLASS = 4;
	private final static int FOUR_CLASS = 3;
	private final static int THREE_MATCH_PRICE = 5000;
	private final static int FOUR_MATCH_PRICE = 50000;
	private final static int FIVE_MATCH_PRICE = 150000;
	private final static int FIVE_BONUS_MATCH_PRICE = 30000000;
	private final static int SIX_MATCH_PRICE = 2000000000;
	
	private BuyLottoDto buyLottoDto;
	private Lotto lotto;
	private BonusNumber bonus;
	private int threeMatch;
	private int fourMatch;
	private int fiveMatchAndBonus;
	private int fiveMatch;
	private int sixMatch;
	private int income;
	private double rateOfProfit;
	
	public BuyLottoBonusDto(Lotto lotto, BonusNumber bonus, BuyLottoDto buyLottoDto) {
		this.lotto = lotto;
		this.bonus = bonus;
		this.buyLottoDto = buyLottoDto;
	}

	public BuyLottoDto getBuyLottoDto() {
		return buyLottoDto;
	}

	public Lotto getLotto() {
		return lotto;
	}

	public BonusNumber getBonus() {
		return bonus;
	}

	public int getThreeMatch() {
		return threeMatch;
	}

	public int getFourMatch() {
		return fourMatch;
	}

	public int getFiveMatchAndBonus() {
		return fiveMatchAndBonus;
	}

	public int getFiveMatch() {
		return fiveMatch;
	}

	public int getSixMatch() {
		return sixMatch;
	}
	
	public double getRateOfProfit() {
		return rateOfProfit;
	}

	public void WinStats() {
		for(int i = 0; i < buyLottoDto.getNumberList().size(); i++) {
			List<Integer> numbers = buyLottoDto.getNumberList().get(i).getNumbers();
			int matchNumber = 0;
			for(int j = 0; j < numbers.size(); j++) {
				matchNumber = overLap(numbers.get(j), matchNumber);
				System.out.println(matchNumber);
			}
			boolean isBonus = bonusMatch(i);
			
			threeMatch(matchNumber);
			fourMatch(matchNumber);
			fiveMatch(matchNumber, isBonus);
			sixMatch(matchNumber);
		}
	}

	private int overLap(int number, int matchNumber) {
		for(int lottoNumber : lotto.getNumbers()) {
			if(lottoNumber == number) {
				matchNumber++;
			}
		}
		return matchNumber;
	}
	
	private boolean bonusMatch(int i) {
		List<Integer> numbers = buyLottoDto.getNumberList().get(i).getNumbers();
		for(int j = 0; j < numbers.size(); j++) {
			if(bonus.getBonusNumber() == numbers.get(j)) {
				return true;
			}
		}
		return false;
	}
	
	private void threeMatch(int matchNumber) {
		if(matchNumber == FOUR_CLASS) {
			threeMatch++;
			this.income += THREE_MATCH_PRICE;
		}
	}

	private void fourMatch(int matchNumber) {
		if(matchNumber == THIRD_CLASS) {
			fourMatch++;
			this.income += FOUR_MATCH_PRICE;
		}
	}

	private void fiveMatch(int matchNumber, boolean isBonus) {
		if(matchNumber == SECOND_CLASS) {
			if(isBonus) {
				fiveMatchAndBonus++;
				this.income += FIVE_BONUS_MATCH_PRICE;
				return;
			}
			fiveMatch++;
			this.income += FIVE_MATCH_PRICE;
		}
	}

	private void sixMatch(int matchNumber) {
		if(matchNumber == FIRST_CLASS) {
			sixMatch++;
			this.income += SIX_MATCH_PRICE;
		}
	}
	
	public void getRate() {
		if(this.income == 0) {
			this.rateOfProfit = 0;
			return;
		}
		double amount = this.buyLottoDto.getAmount();
		double income =  this.income;
		changePercent(amount, income);
	}

	private void changePercent(double amount, double income) {
		double rateOfProfit = (income/amount)*100;
		this.rateOfProfit = rateOfProfit;
	}
}
