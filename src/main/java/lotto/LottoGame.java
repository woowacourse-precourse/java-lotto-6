package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    int firstPrize=0;
    int secondPrize=0;
    int thirdPrize=0;
    int forthPrize=0;
    int fifthPrize=0;
    int[] prizeCount=new int[6];

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
        List<Integer> userLotto=lotto.getLottoNumbers();
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
        return;
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
            firstPrize++;
            prizeCount[1]++;
            return true;
        }
        return false;
    }

    public boolean checkSecondPrize(int count, List<Integer>userLotto, int bonusBall) {

        if (count == 5 && userLotto.contains(bonusBall)) {
            secondPrize++;
            prizeCount[2]++;
            return true;
        }
        return false;
    }

    public boolean checkThirdPrize(int count) {

        if (count == 5) {
            thirdPrize++;
            prizeCount[3]++;
            return true;
        }
        return false;
    }

    public boolean checkFourthPrize(int count) {


        if (count == 4) {
            forthPrize++;
            prizeCount[4]++;
            return true;
        }

       return true;
    }

    public boolean checkFifthPrize(int count) {

        if (count == 3) {
            fifthPrize++;
            prizeCount[5]++;
            return true;
        }
        return true;
    }

    public int[] getPrizeCount(){
        return prizeCount;
    }
}
