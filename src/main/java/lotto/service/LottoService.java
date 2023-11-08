package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoReward;
import lotto.domain.WinningLotto;

public class LottoService {
    public LottoList createLottoList(int count) {
        LottoList lottoList = new LottoList();
        for(int i=0; i<count; i++){
            lottoList.insertLotto(createRandomLotto());
        }
        return lottoList;
    }

    private Lotto createRandomLotto() {
        List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        randomLotto = sortLottoList(randomLotto);
        Lotto lotto = new Lotto(randomLotto);
        return lotto;
    }

    private List<Integer> sortLottoList(List<Integer> randomLotto) {
        Integer[] lottoArray = randomLotto.toArray(new Integer[0]);
        Arrays.sort(lottoArray);
        return Arrays.asList(lottoArray);
    }

    public void printAllLottoNumber(LottoList lottoList) {
        for (Lotto lotto : lottoList.getAllLotto()) {
            System.out.println(lotto);
        }
    }

    public void judgeLotto(LottoList lottoList, WinningLotto winningLotto) {
        List<Integer> winningNumbers = extractList(winningLotto);
        List<Lotto> allLotto = lottoList.getAllLotto();
        for (Lotto lotto : allLotto) {
            List<Integer> randomNumbers = lotto.getNumbers();
            int matchSize = judge(randomNumbers, winningNumbers);
            boolean matchBonusNumber = matchBonus(winningLotto.getBonusNumber(), randomNumbers);
            if (3 <= matchSize && matchSize <=6){
                judgeReward(matchSize,matchBonusNumber);
            }
        }
    }

    private int judge(List<Integer> randomLotto, List<Integer> winningLotto) {
        int matchSize=0;
        for (Integer oneWinningNumber : winningLotto) {
            if (randomLotto.contains(oneWinningNumber)) {
                matchSize++;
            }
        }
        return matchSize;
    }

    private void judgeReward(int size, boolean matchBonusNumber) {
        if (size == 3){
            LottoReward.FIFTH.winningReward();
        }
        if (size == 4){
            LottoReward.FOURTH.winningReward();
        }
        if(size ==5){
            if (matchBonusNumber){
                LottoReward.SECOND.winningReward();
            }
            LottoReward.THIRD.winningReward();
        }
        if(size == 6){
            LottoReward.FIRST.winningReward();
        }
    }

    private boolean matchBonus(int bonusNumber, List<Integer> randomLotto) {
        if (randomLotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private List<Integer> extractList(WinningLotto winningLotto) {
        Lotto winningNumber = winningLotto.getWinningNumber();
        return winningNumber.getNumbers();
    }

    public void printResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + LottoReward.FIFTH.getCount() +"개");
        System.out.println("4개 일치 (50,000원) - " + LottoReward.FOURTH.getCount() +"개");
        System.out.println("5개 일치 (1,500,000원) - " + LottoReward.THIRD.getCount() +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoReward.SECOND.getCount() +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + LottoReward.FIRST.getCount() +"개");
    }

    public void calculateEarningRate(int money){
        int totalReward = 0;
        for (LottoReward lottoReward : LottoReward.values()) {
            totalReward += lottoReward.totalReward();
        }
        double rate = (double)totalReward / money;
        double earningRate = Math.round(rate*10000)/100.0;
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
