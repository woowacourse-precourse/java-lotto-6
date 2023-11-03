package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameRule {

    LottoCounter lottoCounter = new LottoCounter();

    public List<Integer> calculateResult(Cpu cpuLottos, Player playerLotto) {
        List<Integer> resultList = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        List<Lotto> cpuSixNumbers = cpuLottos.getSixLottoNumbers();
        List<Integer> cpuBonusNumbers = cpuLottos.getBonusNumbers();

        for (int index = 0; index < cpuLottos.getTickets(); index++) {
            int result = lottoCounter.countElement(cpuSixNumbers
                            .get(index)
                            .getNumbers(),
                    playerLotto
                            .getSixNumbers()
                            .getNumbers());
            lottoCounter.hitThree(resultList, result);
            lottoCounter.hitFour(resultList, result);
            lottoCounter.hitFive(resultList, result, cpuBonusNumbers.get(index), playerLotto.getBonusNumber());
            lottoCounter.hitFiveBonus(resultList, result, cpuBonusNumbers.get(index), playerLotto.getBonusNumber());
            lottoCounter.hitSix(resultList, result);
        }
        return resultList;
    }

    public String calculateProfit(int inputMoney, List<Integer> gameResult) {
        int income = 0;
        PrizeMoney[] prizeMonies = PrizeMoney.values();
        for (int index = 0; index < gameResult.size(); index++) {
            income += gameResult.get(index) * prizeMonies[index].getMoney();
        }
        double result = (double) income * 100 / inputMoney;
        return String.format("%.1f", result);
    }


}
