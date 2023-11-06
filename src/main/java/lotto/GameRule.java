package lotto;

import static lotto.LottoCounter.countElement;
import static lotto.LottoCounter.getResultList;
import static lotto.Utils.calculatePercentage;

import java.util.ArrayList;
import java.util.List;
import lotto.Constants.PrizeMoney;

public class GameRule {

    public List<Integer> calculateResult(Cpu cpuLottos, Player playerLotto) {
        List<Integer> resultList = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        List<Lotto> cpuSixNumbers = cpuLottos.getSixLottoNumbers();

        for (int index = 0; index < cpuLottos.getTickets(); index++) {
            Lotto cpuSixNumber = cpuSixNumbers.get(index);
            Lotto playerNumber = playerLotto.getSixNumbers();
            int result = countElement(cpuSixNumber.getNumbers(), playerNumber.getNumbers());
            getResultList(resultList, result, cpuSixNumber, playerLotto);
        }
        return resultList;
    }

    public String calculateProfit(int inputMoney, List<Integer> gameResult) {
        int income = 0;
        PrizeMoney[] prizeMonies = PrizeMoney.values();
        for (int index = 0; index < gameResult.size(); index++) {
            income += gameResult.get(index) * prizeMonies[index].getMoney();
        }
        double result = calculatePercentage(income, inputMoney);
        return String.format("%.1f", result);
    }
}
