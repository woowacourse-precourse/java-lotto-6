package lotto.Model;

import static lotto.Utils.LottoResultCalculator.countElement;
import static lotto.Utils.LottoResultCalculator.getResultList;
import static lotto.Utils.Utils.calculatePercentage;

import java.util.ArrayList;
import java.util.List;
import lotto.Constants.IntConstants;
import lotto.Constants.PrizeMoney;

public class GameRule {
    private static final List<Integer> INITIAL_RESULT = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    public List<Integer> calculateResult(Cpu cpuLottos, Player playerLotto) {
        List<Integer> Lottoresult = INITIAL_RESULT;
        List<Lotto> cpuSixNumbers = cpuLottos.getSixLottoNumbers();

        for (int index = 0; index < cpuLottos.getTickets(); index++) {
            Lotto cpuSixNumber = cpuSixNumbers.get(index);
            Lotto playerNumber = playerLotto.getSixNumbers();
            int result = countElement(cpuSixNumber.getNumbers(), playerNumber.getNumbers());
            getResultList(Lottoresult, result, cpuSixNumber, playerLotto);
        }
        return Lottoresult;
    }

    public String calculateProfit(int inputMoney, List<Integer> gameResult) {
        int income = IntConstants.INITIAL_INCOME.getValue();
        PrizeMoney[] prizeMonies = PrizeMoney.values();
        for (int index = 0; index < gameResult.size(); index++) {
            income += gameResult.get(index) * prizeMonies[index].getMoney();
        }
        double result = calculatePercentage(income, inputMoney);
        return String.format("%.1f", result);
    }
}
