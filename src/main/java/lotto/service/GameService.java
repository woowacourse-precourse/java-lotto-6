package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {

    private int lottoCount;
    private Lotto playerLotto;
    private int bonusNumber;
    private List<Lotto> winningLottos;
    private Map<Rank, Integer> rankCountMap = new HashMap<>();

    public void initGame(int money) {
        lottoCount = money / Lotto.LOTTO_PRICE;
        winningLottos = generateWinningLottos();
        initRankCountMap();
    }

    private void initRankCountMap(){
        for(Rank rank : Rank.values()){
            rankCountMap.put(rank, 0);
        }
    }

    private List<Lotto> generateWinningLottos(){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MIN_NUMBER, Lotto.LOTTO_MAX_NUMBER, Lotto.LOTTO_SIZE)));
        }
        return lottos;
    }

    public void comparePlayerLottoWithWinningLottos() {
        for(Lotto lotto : winningLottos){
            Rank rank = lotto.getRank(playerLotto, bonusNumber);

            if(rankCountMap.containsKey(rank)){
                rankCountMap.put(rank, rankCountMap.get(rank) + 1);
            } else {
                rankCountMap.put(rank, 1);
            }
        }
    }

    public double calculateProfitRate() {
        double totalProfit = 0;
        for(Rank rank : Rank.values()){
            totalProfit += rank.getWinningMoney() * rankCountMap.get(rank);
        }

        return totalProfit / (lottoCount * Lotto.LOTTO_PRICE) * 100;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getWinningLottos() {
        return winningLottos;
    }

    public void setPlayerLotto(Lotto lotto) { playerLotto = lotto; }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> getRankCountMap() {
        return rankCountMap;
    }
}
