package lotto.controller.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.END_OF_COUNT;
import static lotto.model.constant.IntegerSymbolicConstantEnum.INDEX_FOCUS_NUMBER;
import static lotto.model.constant.IntegerSymbolicConstantEnum.MATH_ROUND_SETTER;
import static lotto.model.constant.IntegerSymbolicConstantEnum.MONEY_UNIT;
import static lotto.model.constant.StringSymbolicConstantEnum.INITIALIZE_FOR_BIG_INT;

import java.math.BigInteger;
import java.util.List;
import lotto.model.constant.LottoWinningCase;
import lotto.model.lotto.LottoTicketList;

public class LottoWinningProfitCalculator {

	public Double calculateLottoWinningProfit(LottoTicketList lottoTicketList, List<Integer> winningCaseCountList) {
		BigInteger sumOfWinningMoney = calculateSumOfWinningMoney(winningCaseCountList);
		Double purchaseMoneyValue = (double) (lottoTicketList.getLottoTicketList().size() * MONEY_UNIT.getValue());

		return finalProfitRateValue(sumOfWinningMoney, purchaseMoneyValue);
	}

	private Double finalProfitRateValue(BigInteger sumOfWinningMoney, Double purchaseMoneyValue) {
		int moneyUnit = MONEY_UNIT.getValue();
		int mathRoundSetter = MATH_ROUND_SETTER.getValue();
		double sum = sumOfWinningMoney.doubleValue();
		return Math.round((sum/ purchaseMoneyValue) * moneyUnit) / (double)moneyUnit * mathRoundSetter;
	}

	private BigInteger calculateSumOfWinningMoney(List<Integer> winningCaseCountList) {
		BigInteger sumOfWinningMoney = new BigInteger(INITIALIZE_FOR_BIG_INT.getValue());
		int counterForIterate = winningCaseCountList.size() - INDEX_FOCUS_NUMBER.getValue();
		while (END_OF_COUNT.getValue() < counterForIterate){
			LottoWinningCase lottoWinningCase = LottoWinningCase.values()[counterForIterate];
			BigInteger winningMoney = new BigInteger(Integer.toString(lottoWinningCase.getWinningMoney()));
			BigInteger winningCaseCount = new BigInteger(Integer.toString(winningCaseCountList.get(counterForIterate)));
			BigInteger winningMoneyAndCaseCountMultiply = winningMoney.multiply(winningCaseCount);
			sumOfWinningMoney = sumOfWinningMoney.add(winningMoneyAndCaseCountMultiply);
			counterForIterate--;
		}
		return sumOfWinningMoney;
	}
}
