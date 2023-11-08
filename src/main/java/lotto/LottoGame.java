package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    int[] prizeCount=new int[6];
    long totalProfit=0;
    int payMoney=0;
    int lottoCount=0;

    public void setPayMoney(int payMoney){
        this.payMoney=payMoney;
    }

    public void setLottoCount(){
        lottoCount=payMoney/1000;
    }

    public List<Lotto> generateLottos(int gameNumber){
        List<Lotto> ret=new ArrayList<>();
        for(int i=0;i<gameNumber;i++){
            ret.add(new Lotto(generateLottoNumbers()));
        }
        return ret;
    }

    public List<Integer> generateLottoNumbers(){
        List<Integer> eachLottoList=Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(eachLottoList);
        return eachLottoList;
    }

    public void checkWinningCombination(List<Lotto> lottoList, List<Integer> winningList, int bonusNumber){
        for(Lotto lotto: lottoList){
            checkHowManyMatch(lotto,winningList,bonusNumber);
        }
    }

    public void checkHowManyMatch(Lotto lotto, List<Integer> winningList, int bonusNumber){

        int duplicatedCount=getDuplicatedCount(lotto.getLottoNumbers(),winningList);
        if (checkFirstPrize(duplicatedCount)) {
            return;
        } if (checkSecondPrize(duplicatedCount, lotto.getLottoNumbers(), bonusNumber)) {
            return;
        } if (checkThirdPrize(duplicatedCount)) {
            return;
        }  if (checkFourthPrize(duplicatedCount)) {
            return;
        }  if (checkFifthPrize(duplicatedCount)) {
            return;
        }
    }

    public int getDuplicatedCount(List<Integer> userLotto, List<Integer> winningLotto){
        int ret = 0;

        for (int number : userLotto) {
            if (winningLotto.contains(number)) {
                ret++;
            }
        }
        return ret;
    }

    public boolean checkFirstPrize(int count) {
        if(count==6){
            prizeCount[1]++;
            totalProfit+=2000000000;
            return true;
        }
        return false;
    }

    public boolean checkSecondPrize(int count, List<Integer>userLotto, int bonusBall) {

        if (count == 5 && userLotto.contains(bonusBall)) {
            prizeCount[2]++;
            totalProfit+=30000000;
            return true;
        }
        return false;
    }

    public boolean checkThirdPrize(int count) {

        if (count == 5) {
            prizeCount[3]++;
            totalProfit+=1500000;
            return true;
        }
        return false;
    }

    public boolean checkFourthPrize(int count) {


        if (count == 4) {
            prizeCount[4]++;
            totalProfit+=50000;
            return true;
        }

       return false;
    }

    public boolean checkFifthPrize(int count) {
        if (count == 3) {
            prizeCount[5]++;
            totalProfit+=5000;
            return true;
        }
        return false;
    }

    public int[] getPrizeCount(){
        System.out.println();
        return prizeCount;
    }

    public double getStats(){
        return (double)totalProfit / payMoney * 100;
    }
}
