package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.domain.Result;

import java.util.List;
import java.util.function.Predicate;

public class Judge {

    public Result calculateWinning(Player player, Lottos lottos){
        Result result = new Result();
        Lotto winningNumber = player.getWinningNumber();

        for (Lotto lotto : lottos.getLottos()){
            int matchingNumber = checkMatchingNumbers(winningNumber, lotto);
            boolean bonus = false;
            if(matchingNumber == 5){
                bonus = checkBonus(player.getBonusNumber(),lotto);
            }
            addReward(result, matchingNumber, bonus);
        }

        return result;
    }

    public String calculateEarningRate(Result result, int number){
        long reward = calculateTotalResult(result);
        int buyPrice = number * 1000;
        float earningRate = ((float) reward /buyPrice) * 100;

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

    private void addReward(Result result, int matchingNumber, boolean bonus){
        if(matchingNumber == 3)
            result.addThree();
        else if(matchingNumber == 4)
            result.addFour();
        else if(matchingNumber == 5 && !bonus)
            result.addFive();
        else if(matchingNumber == 5)
            result.addFivenBonus();
        else if(matchingNumber == 6)
            result.addSix();
    }

    private long calculateTotalResult(Result result){
        return 5000L *result.getThree() + 50000L *result.getFour() + 1500000L *result.getFive() + 30000000L *result.getFiveNBonus() + result.getSix();
    }



}
