package service;

import domain.LottoSystem;
import domain.Lottos;
import java.util.Arrays;
import java.util.List;
import view.constant.ConstantMoney;

public class LottoService {
    private static int MINIMUM_NUMBER_OF_WINNINGS = 3;
    private static int LOTTO_PRICE = 1000;
    public int[] revealLottery(Lottos lottos, LottoSystem lottoSystem){
        int[] winningResult = {0,0,0,0,0};

        for(int i=0; i< lottos.getLottosSize(); i++){
            int count = countCommonNumbers(lottos.getLotto(i), lottoSystem);
            if(count >= MINIMUM_NUMBER_OF_WINNINGS)
                winningResult[count - MINIMUM_NUMBER_OF_WINNINGS]++;
        }

        return winningResult;
    }
    private int countCommonNumbers(List<Integer> MyLottoNumbers,LottoSystem lottoSystem){
        int count = (int) lottoSystem.getWinningLotto().stream()
                .filter(MyLottoNumbers::contains)
                .count();

       return JudgeOfNumbers(count, MyLottoNumbers, lottoSystem.getBonusNumber());
    }
    private int JudgeOfNumbers(int count, List<Integer> MyLottoNumbers, int BonusNumber){
        if(count == 6){
            return count + 1;
        }
        if(count == 5) {
            return count + countBonusNumber(MyLottoNumbers, BonusNumber);
        }
        return count;
    }
    private int countBonusNumber(List<Integer> MyLottoNumbers, int bonusNumber){
        if(MyLottoNumbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }
    public double getEarningRate(int[] lottoResult, Lottos lottos){
        return getTotalWinningMoney(lottoResult) / getTotalMYMoney(lottos);
    }
    private double getTotalMYMoney(Lottos lottos){
        return lottos.getLottosSize() * LOTTO_PRICE;
    }
    private double getTotalWinningMoney(int[] lottoResult){
        double totalMyMoney = 0;
        for(int i=0; i<lottoResult.length; i++){
            totalMyMoney += lottoResult[i] * ConstantMoney.getLottoResultMoney(i);
        }
        return totalMyMoney;
    }
}
