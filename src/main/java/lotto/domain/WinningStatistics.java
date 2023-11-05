package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private Map<WinningResult, Integer> winningStatistics = new HashMap<>();
    private BigDecimal revenueRate = BigDecimal.ZERO;

    private WinningStatistics(Lottos userLottos, WinningLotto winningLotto){
        setWinningStatistics(userLottos, winningLotto);
        setRevenueRate(userLottos, winningLotto);
    }

    public static WinningStatistics from(Lottos userLottos, WinningLotto winningLotto){
        return new WinningStatistics(userLottos, winningLotto);
    }

    private void setWinningStatistics(Lottos userLottos, WinningLotto winningLotto){
        for(Lotto userLotto : userLottos.getLottos()){
            WinningResult winningResult = createWinningResult(userLotto.getNumbers(), winningLotto);
            updateWinningStatistics(winningResult);
        }
    }

    private WinningResult createWinningResult(List<Integer> userLottoNumbers, WinningLotto winningLotto){
        int matchesCount = getEachMatchesCount(userLottoNumbers, winningLotto.getLotto().getNumbers());
        boolean isBonus = getHasBonus(userLottoNumbers, winningLotto.getBonus());
        return WinningResult.from(matchesCount, isBonus);
    }

    private int getEachMatchesCount(List<Integer> userLottoNumbers, List<Integer> winNumbers){
        return (int) userLottoNumbers.stream()
                .filter(winNumbers::contains).count();
    }

    private void updateWinningStatistics(WinningResult winningResult){
        winningStatistics.put(winningResult, winningStatistics.getOrDefault(winningResult, 1));
    }

    private boolean getHasBonus(List<Integer> userLottoNumbers, Bonus bonus){
        return userLottoNumbers.contains(bonus.getBonus());
    }

    private void setRevenueRate(Lottos userLottos, WinningLotto winningLotto){

    }
}
