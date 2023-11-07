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

    private Result calculateWinning(Player player, Lottos lottos){

        Result result = new Result();
        Lotto winningNumber = player.getWinningNumber();

        for (Lotto lotto : lottos.getLottos()){
            int matchingNumber = checkMatchingNumbers(winningNumber, lotto);
            boolean bonus = false;
            if(matchingNumber == 5){
                bonus = checkBonus(player.getBonusNumber(),lotto);
            }
            result.addResult(findReward(matchingNumber, bonus));
        }

        return result;
    }

    private String calculateEarningRate(Result result, int lottoCount){
        long totalPrize = calculateTotalPrize(result);
        int buyPrice = lottoCount * 1000;
        float earningRate = ((float) totalPrize /buyPrice) * 100;

        return String.format("%.1f", earningRate);
    }

    private int checkMatchingNumbers(Lotto player, Lotto computer){
        int result = 0;
        List<Integer> a = player.getNumbers();
        List<Integer> b = computer.getNumbers();
        result = (int) a.stream().filter(o -> b.stream()
                .anyMatch(Predicate.isEqual(o))).count();

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
