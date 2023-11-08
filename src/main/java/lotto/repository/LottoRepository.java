package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoRepository {

    private List<Lotto> userLottoList = new ArrayList<>();
    private Lotto winningLotto;

    private int bonusNum;

    private HashMap<Rank,Integer> resultMap = new HashMap<>();

    public void save(Lotto lotto) {
        userLottoList.add(lotto);
    }

    public void setWinningLotto(Lotto lotto) {
        winningLotto = lotto;
    }

    public void setBonusNum(int num) {
        bonusNum = num;
    }

    public List<Lotto> getUserLottoList() {
        return userLottoList;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void initMap(){
        for(Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void increaseResult(Rank result) {
        resultMap.replace(result, resultMap.get(result), resultMap.get(result) + 1);
    }

    public HashMap<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public int getProfit() {
        int profit = 0;
        for(Rank rank : resultMap.keySet()) {
             profit = profit + rank.getPrize() * resultMap.get(rank);
        }

        return profit;
    }
}
