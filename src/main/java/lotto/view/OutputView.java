package lotto.view;

import java.util.Map;
import lotto.constant.LottoGrade;
import lotto.constant.Prize;
import lotto.model.Lottos;
import lotto.model.MoneyToBuy;

public class OutputView {

    public void printNumberOfBoughtLottos(Integer number) {
        System.out.printf(OutputMessage.BUY_LOTTO_RESULT.getMessage(), number);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printPrizeResults(Map<LottoGrade, Integer> grades) {
        System.out.printf(OutputMessage.LOTTO_GRADE_RESULT.getMessage(),
                grades.getOrDefault(LottoGrade.THREE_MATCH, 0),
                grades.getOrDefault(LottoGrade.FOUR_MATCH, 0),
                grades.getOrDefault(LottoGrade.FIVE_MATCH, 0),
                grades.getOrDefault(LottoGrade.FIVE_AND_BONUS_MATCH, 0),
                grades.getOrDefault(LottoGrade.SIX_MATCH, 0)
        );
    }

    public void printRateOfReturn(Map<LottoGrade, Integer> grades, MoneyToBuy moneyToBuy) {
        Integer totalIncome = 0;

        totalIncome += grades.getOrDefault(LottoGrade.THREE_MATCH, 0) * Prize.THREE_MATCH.getPrice();
        totalIncome += grades.getOrDefault(LottoGrade.FOUR_MATCH, 0) * Prize.FOUR_MATCH.getPrice();
        totalIncome += grades.getOrDefault(LottoGrade.FIVE_MATCH, 0) * Prize.FIVE_MATCH.getPrice();
        totalIncome += grades.getOrDefault(LottoGrade.FIVE_AND_BONUS_MATCH, 0) * Prize.FIVE_AND_BONUS_MATCH.getPrice();
        totalIncome += grades.getOrDefault(LottoGrade.SIX_MATCH, 0) * Prize.SIX_MATCH.getPrice();

        Double rateOfReturn = totalIncome.doubleValue() / moneyToBuy.getValue() * 100;
        System.out.printf(OutputMessage.RATE_OF_RETURN.getMessage(), String.format("%.1f", rateOfReturn));
    }
}
