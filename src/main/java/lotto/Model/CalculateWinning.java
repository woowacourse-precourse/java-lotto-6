package lotto.Model;

import java.util.List;
public class CalculateWinning {
    int[] rankings = new int[8];

    int totalPrizeSum = 0;
    double rate;
    final int BONUS = 7;

    public void setRankings(List<User> lottos){
        for(User user : lottos){
            int ranking = user.getUserLotto().size();
            rankings[ranking]++;
            if(ranking == 5 && user.getHasBonus()){
                rankings[ranking]--;
                rankings[BONUS]++;
            }
        }
    }

    public int[] getRankings(){
        return rankings;
    }

    public void thirdPrize(int correctCount){
        totalPrizeSum += (5000 * correctCount);
    }
    public void fourthPrize(int correctCount){
        totalPrizeSum += (50000 * correctCount);
    }
    public void fifthPrize(int correctCount){
        totalPrizeSum += (1500000 * correctCount);
    }
    public void fifthBonusPrize(int correctCount){
        totalPrizeSum += (30000000 * correctCount);
    }
    public void sixPrize(int correctCount){
        totalPrizeSum += (2000000000 * correctCount);
    }

    public void setRatingReturn(int price){
    rate = ((double)totalPrizeSum/price)*100;
    }
    public double getRate(){
        return rate;
    }
}
