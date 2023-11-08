package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoGame {
    private static final int PERCENTAGE = 100;
    public void playGame(){

        final int lottoAmount = 1000;
        int purchaseAmount = InputHandler.purchaseAmountInput();
        int purchaseNumber = purchaseAmount/lottoAmount;

        Lotto[] lottos = new Lotto[purchaseNumber];
        LottoResult lottoResult = new LottoResult();

        View.printPurchaseLottoNumber(purchaseNumber);

        purchaseAutoLotto(lottos,purchaseNumber);

        recordLottoResult(lottos,lottoResult,purchaseNumber);

        caculateRateOfReturn(lottoResult,purchaseAmount);

    }

    public static int compareNumbers(List<Integer> purchaseLotto,List<Integer> winningNumbers){
        int matchedCount = 0;
        for(int purchaseNumber : purchaseLotto){
            if(winningNumbers.contains(purchaseNumber)){
                matchedCount++;
            }
        }

        return matchedCount;
    }

    public static boolean compareBounusNumber(List<Integer> purchaseLotto,Integer bonusNumber){
        if(purchaseLotto.contains(bonusNumber)){
            return true;
        }
        else{
            return false;
        }
    }

    public static Lotto[] purchaseAutoLotto(Lotto[] lottos,int purchaseNumber){
        for(int i = 0; i < purchaseNumber; i++){
            List<Integer> autoLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(autoLotto);

            lottos[i] = new Lotto(autoLotto);
        }
        View.printAllLotto(lottos,purchaseNumber);

        return lottos;

    }

    public static void recordLottoResult(Lotto[] lottos,LottoResult lottoResult,int purchaseNumber){
        List<Integer> winningNumbers = InputHandler.winningNumberInput();
        int bonusNumber = InputHandler.bonusNumberInput();

        for(int i = 0; i < purchaseNumber; i ++){
            List<Integer> purchaseLotto = lottos[i].getLottoNumbers();
            int matchedCount = compareNumbers(purchaseLotto,winningNumbers);
            boolean matchBounus = compareBounusNumber(purchaseLotto,bonusNumber);

            Rank rank = Rank.getRank(matchedCount,matchBounus);
            lottoResult.addNumberOfMatch(rank);
        }
    }

    public  static void caculateRateOfReturn(LottoResult lottoResult,int purchaseAmount){
        int totalMoney = 0;

        View.printLottoResultBoard();

        for (Rank rank : Rank.values()) {
            if(rank.getWinningMoney() == 0){
                continue;
            }

            totalMoney += rank.getWinningMoney()*lottoResult.getLottoResultTable().get(rank);

            View.printNumberOfMatch(rank.getNumberOfMatch());

            if(rank.getWinningMoney() == 30000000 ){
                View.printBonusNumberOfMatch();
            }

            View.printLottoResult(rank.getWinningMoney(),lottoResult.getLottoResultTable().get(rank));
        }

        float rateOfReturn = (float)totalMoney/purchaseAmount*PERCENTAGE;
        View.printRateOfReturn(rateOfReturn);
    }
}
