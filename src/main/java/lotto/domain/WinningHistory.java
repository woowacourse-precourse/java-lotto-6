package lotto.domain;

import java.util.HashMap;

public class WinningHistory {
    private LottoGame lottoGame;
    private PurchaseLotto purchaseLotto;
    private HashMap<Ranking, Integer> winningResult;
    private double totalPrizeMoney;

    public WinningHistory(LottoGame lottoGame, PurchaseLotto purchaseLotto){
        this.lottoGame = lottoGame;
        this.purchaseLotto = purchaseLotto;
        this.winningResult = initResult();
        this.totalPrizeMoney = 0;
    }

    private HashMap<Ranking, Integer> initResult(){
        HashMap<Ranking, Integer> result = new HashMap<>();
        for (Ranking ranking : Ranking.values()) {
            result.put(ranking, 0);
        }
        return result;
    }

    public HashMap<Ranking, Integer> getWinningResult(){
        for(Lotto lotto : purchaseLotto.getPurchasedLottos()){
            setWinningResult(getRanking(lotto));
        }
        return winningResult;
    }

    private void setWinningResult(Ranking ranking){
        winningResult.put(ranking, winningResult.get(ranking) + 1);
        totalPrizeMoney += ranking.getPrizeMoney();
    }

    private Ranking getRanking(Lotto lotto){
        int countOfMatch =  countMatchingNumbers(lotto, lottoGame.getWinningNumber());
        boolean containsBonus = containsBonusNumber(lotto, lottoGame.getBonusNumber());
        return Ranking.valueOf(countOfMatch, containsBonus);
    }

    private boolean containsBonusNumber(Lotto lotto, int bonusNumber ){
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningNumber){
        return (int) lotto.getNumbers().stream()
                .filter(winningNumber.getNumbers() :: contains)
                .count();
    }
    public String getRateOfReturn(){
        totalPrizeMoney *= 1.0;
        return roundTwoDecimalPlaces((totalPrizeMoney / purchaseLotto.getPurchaseMoney()) * 100);
    }

    private String roundTwoDecimalPlaces(double rate){
        return String.format("%.1f", rate);
    }

}
