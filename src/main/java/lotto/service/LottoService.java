package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Numbers;
import lotto.constant.Ranking;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Integer> initLottoNumber(){
        int initNumber = Numbers.INIT_NUMBER_START.getNumber();
        int endNumber = Numbers.INIT_NUMBER_END.getNumber();
        int countNumber = Numbers.INIT_NUMBER_COUNT.getNumber();

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(initNumber,endNumber,countNumber);

        return numbers;
    }

    public List<Integer> splitWinningNumber(String input){
        String [] splitString = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();

        for(int i = 0 ; i <splitString.length; i++){
            winningNumber.add(Integer.parseInt(splitString[i]));
        }

        return winningNumber;
    }

    public List<Integer> calcWinningResult(Lotto winningNumber,List<Lotto> lottos){
        List<Integer> countWinNumbers = new ArrayList<>();
        int countNumber = 0;

        for(Lotto lotto : lottos){
            countNumber = countWinningNumber(winningNumber, lotto);
            countWinNumbers.add(countNumber);
        }

        return countWinNumbers;
    }

    public int countWinningNumber(Lotto winningLott, Lotto purchaseLotto){
        List<Integer> winningNumber = winningLott.getNumbers();
        List<Integer> purchaseNumber = purchaseLotto.getNumbers();
        int count = 0;

        for(int i = 0; i < winningNumber.size(); i++){
            if(purchaseNumber.contains(winningNumber.get(i))){
                count += 1;
            }
        }

        return count;
    }

    public int[] calcRanking(List<Integer> countWinningNum, Lotto winningNumber, Bonus bonus){

        int rankNum = Numbers.RANK_NUMBER.getNumber();
        int[] winingRanking = new int[rankNum];
        int index;

        for(int i = 0; i < countWinningNum.size(); i++){
            if(countWinningNum.get(i) < 3){
                continue;
            }
            index = calcIndex(countWinningNum.get(i),winningNumber, bonus);
            winingRanking[index] += 1;
        }

        return winingRanking;
    }

    public int calcIndex(int countNum, Lotto winningNumber, Bonus bonus){
        int winIndex = -1;
        boolean isBonus =  winningNumber.getNumbers().contains(bonus.getBonusNumber());

        for(Ranking ranking : Ranking.values()){
            if(countNum == Ranking.SECOND.getWinNum() && isBonus){
                return Ranking.SECOND.getIndex();
            }
            if(ranking.getWinNum() == countNum){
                winIndex = ranking.getIndex();
            }
        }

        return winIndex;
    }

    public String calcWinningRate(int[] winResult, PurchaseAmount purchaseAmount){
        int sumPrize = 0;
        double rate;

        for(int i = 0; i < winResult.length; i++){
            sumPrize = sumPrize + (getPrize(i) * winResult[i]);
        }

        rate = ((double)sumPrize / (double) purchaseAmount.getAmount()) * 100;

        return String.format("%.1f", rate);
    }

    public int getPrize(int index){
        int prize = 0;

        for(Ranking ranking : Ranking.values()){
            if(index == ranking.getIndex()){
                prize =  ranking.getPrize();
            }
        }

        return prize;
    }
}
