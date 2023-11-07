package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        LottoMaker lottoMaker = new LottoMaker();
        MatchingMachine machine = new MatchingMachine();
        Calculator calculator = new Calculator();
        int volume = user.getMoney();
        List<Lotto> allLotto = lottoMaker.getLottoAsMuchAsVolume(volume);
        lottoMaker.getAllLottoAsConsole(allLotto);
        Lotto winningLotto = user.getWinningLotto();
        int bonusNum = user.getBonusNumber(winningLotto);
        List<MatchingCount> matchingCounts = machine.countAllLottoMatchingNumbers(allLotto,winningLotto,bonusNum);
        machine.getResultAsConsole(matchingCounts);
        int sumPrize = calculator.getProfitMoney(matchingCounts);
        double profitPercentage = calculator.getProfitPercentage(sumPrize, volume);
        System.out.println("총 수익률은 " +profitPercentage + "%입니다.");
    }
}
