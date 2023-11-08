package lotto.utils;

import lotto.model.WinningLotto;

import java.util.List;

public class Calculator {

    public static int calculatingRank(WinningLotto winningLotto, List<Integer> purchaseLotto){
        List<Integer> numbers = winningLotto.getNumbers();
        Integer bonusNumber = winningLotto.getBonusNumber();
        int rank = conversionRank(numbers,bonusNumber,purchaseLotto);
        return rank;
    }

    public static boolean checkBonusNumber(Integer bonusNumber, List<Integer> purchaseLotto){
        for(Integer element : purchaseLotto){
            if(element == bonusNumber){
                return true;
            }
        }
        return false;
    }

    public static int sameCount(List<Integer> WinningLotto, List<Integer> PurchaseLotto){
        int count = 0;
        for(Integer element : PurchaseLotto){
            if(WinningLotto.contains(element)){
                count ++;
            }
        }
        return count;
    }

    private static int conversionRank(List<Integer> numbers, Integer bonusNumber, List<Integer> purchaseLotto){
        int sameNumber = sameCount(numbers,purchaseLotto);
        if(sameNumber == 3){
            return 5;
        }
        if(sameNumber == 4){
            return 4;
        }
        if(sameNumber == 5){
            if(checkBonusNumber(bonusNumber,purchaseLotto)){
                return 2;
            }
            return 3;
        }
        if(sameNumber == 6){
            return 1;
        }
        return 6;
    }

    public static int rankCount(int number, List<Integer> ranks){
        int count = 0;
        for (Integer rank : ranks){
            if(rank == number){
                ++count;
            }
        }
        return count;
    }

    public static double calculateEarningRate(int amount, List<Integer> ranks){
        int totalProfit = calculateTotalProfit(ranks);
        double earningRate = ((double)totalProfit / (double)amount)*100;
        return earningRate;
    }

    private static int calculateTotalProfit(List<Integer> ranks){
        int totalProfit = 0;
        for(Integer rank : ranks){
            totalProfit+=calculateProfit(rank);
        }
        return totalProfit;
    }

    private static int calculateProfit(Integer rank){
        if(rank == 5){return 5000;}
        if(rank == 4){return 50000;}
        if(rank == 3){return 1500000;}
        if(rank == 2){return 30000000;}
        if(rank == 1){return 2000000000;}
        return 0;
    }

}
