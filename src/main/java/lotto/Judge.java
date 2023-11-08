package lotto;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Judge {

    public Result calculateResult(Player player, Lottos lottos){
        Result result = calculateWinning(player,lottos);
        String earningRate = calculateEarningRate(result, lottos.getLottos().size());
        result.setEarningRate(earningRate);
        return result;
    }

    public Result calculateWinning(Player player, Lottos lottos){
        Result result = new Result();
        Lotto winningNumber = player.getWinningNumber();
        int bonusNumber = player.getBonusNumber();

        for (Lotto lotto : lottos.getLottos()){
            int matchingCount = checkMatchingNumbers(winningNumber, lotto);
            boolean matchBonus = false;
            if(matchingCount == Reward.SECOND.getMatchCount()){
                matchBonus = checkBonus(bonusNumber,lotto);
            }
            Reward reward = findReward(matchingCount, matchBonus);
            result.addResult(reward);
        }

        return result;
    }

    public String calculateEarningRate(Result result, int lottoCount){
        long totalPrize = calculateTotalPrize(result);
        int buyPrice = lottoCount * 1000;
        float earningRate = ((float) totalPrize /buyPrice) * 100;

        return String.format("%.1f", earningRate);
    }

    private int checkMatchingNumbers(Lotto player, Lotto computer){
        int result = 0;
        List<Integer> playerNumbers = player.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
        result = (int) playerNumbers.stream()
                .filter(o -> computerNumbers.stream().anyMatch(Predicate.isEqual(o)))
                .count();
        return result;
    }

    private boolean checkBonus(int bonus, Lotto lotto){
        return lotto.getNumbers().contains(bonus);
    }

    private Reward findReward(int matchingNumber, boolean bonus){
        Reward reward = Reward.FAIL;
        reward = reward.getReward(matchingNumber,bonus);
        return reward;
    }

    private long calculateTotalPrize(Result result){
        long totalPrize = 0;
        Map<Reward, Integer> finalResult =  result.getResult();
        for(Map.Entry<Reward, Integer> entry : finalResult.entrySet()){
            Reward reward = entry.getKey();
            int count = entry.getValue();
            if(count !=0){
                totalPrize += (long) reward.getPrize() *count;
            }

        }
        return totalPrize;
    }

}
