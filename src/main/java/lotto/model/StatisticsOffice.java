package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsOffice {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private StatisticsOffice(Lotto winningLotto, LottoNumber bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto winningLotto, LottoNumber bonusNumber){
        if(winningLotto.hasNumber(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public static StatisticsOffice registerWinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        return new StatisticsOffice(new Lotto(winningLotto), new LottoNumber(bonusNumber));
    }

    public Map<Rank, Integer> convertToRank(List<Lotto> lottoTicket) {
        Map<Rank, Integer> winningStatus = new HashMap<>();
        for (Lotto lotto : lottoTicket) {
            recordRank(winningStatus, lotto);
        }
        return winningStatus;
    }

    private void recordRank(Map<Rank, Integer> winningStatus, Lotto lotto) {
        int matchCont = winningLotto.matchCount(lotto);
        Rank rank = Rank.calculate(matchCont, lotto.hasNumber(bonusNumber));
        winningStatus.merge(rank, 1, Integer::sum);
    }

    public static String calculateProfitRate(Map<Rank, Integer> winningStatus, int money){
        double profit = 0.0;
        for (Rank rank : winningStatus.keySet()){
            profit += rank.getReward() * winningStatus.get(rank);
        }
        return String.format("%.1f", profit*100/money);
    }


}
