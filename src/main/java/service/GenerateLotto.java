package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinningStatus;

public class GenerateLotto {

    private static PrintService printService = new PrintService();

    //사용자 구매 금액만큼 로또 번호 생성하기
    public List<Lotto> generateLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList();
        for(int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottoList.add(lotto);
        }
        printService.printLottoList(lottoList);
        return lottoList;
    }

    public List<Integer> generateNumbers(){
        List<Integer> random = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        random.sort(Comparator.naturalOrder());
        return random;
    }

    public Map<WinningStatus, Integer> winningStatistics(List<Lotto> lottoList, List<Integer> winnerLotto, int bonus){
        Map<WinningStatus, Integer> statistics = new HashMap<>();

        for (WinningStatus status : WinningStatus.values()) {
            statistics.put(status, 0);
        }

        for (Lotto lotto : lottoList) {
            List<Integer> matchresult = countMatchNumber(lotto, winnerLotto, bonus); // 일치하는 번호의 수

            if (matchresult.get(0) == 5 && matchresult.get(1) == 1) {
                statistics.put(WinningStatus.bonus, statistics.get(WinningStatus.bonus) + 1);
            }
            if (2 < matchresult.get(0) && matchresult.get(1) != 1) {
                for (WinningStatus status : WinningStatus.values()) {
                    if (status.getMatchNumberInfo() == matchresult.get(0)) {
                        statistics.put(status, statistics.get(status) + 1);
                        break;
                    }
                }
            }
        }

        printService.printWinningStatistics(statistics);
        return statistics;
    }

    public List<Integer> countMatchNumber(Lotto lotto, List<Integer> winnerLotto, int bonus){
        List<Integer> matchresult = new ArrayList<>();
        int matchCount = 0;
        int bonusMatch = 0;
        // 일치하는 번호의 수를 계산
        for (int number : lotto.getNumbers()) {
            if (winnerLotto.contains(number)) {
                matchCount++;
            }
            if (number == bonus) {
                bonusMatch = 1;
            }
        }
        matchresult.add(matchCount);
        matchresult.add(bonusMatch);
        return matchresult;
    }

    public void rateOfReturn(Map<WinningStatus, Integer> statistics, int purchaseAmount){
        long winningAmount = 0;
        for (Map.Entry<WinningStatus, Integer> entry : statistics.entrySet()) {
            WinningStatus status = entry.getKey();
            Integer count = entry.getValue();
            winningAmount += status.getIntWinningMoney() * count;
        }
        printService.printWinningAmount(winningAmount / purchaseAmount);
    }

}
