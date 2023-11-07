package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGame {
    public void playGame(){
        final int lottoAmount = 1000;
        int purchaseNumber = InputHandler.purchaseAmountInput()/lottoAmount;

        Lotto[] lottos = new Lotto[purchaseNumber];

        for(int i = 0; i < purchaseNumber; i++){
            lottos[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lottos[i].getLottoNumbers());
        }

        List<Integer> winningNumbers = InputHandler.winningNumberInput();
        int bonusNumber = InputHandler.bonusNumberInput();

        LottoResult lottoResult = new LottoResult();
        for(int i = 0; i < purchaseNumber; i ++){
            List<Integer> purchaseLotto = lottos[i].getLottoNumbers();
            int matchedCount = compareNumbers(purchaseLotto,winningNumbers);
            boolean matchBounus = compareBounusNumber(purchaseLotto,bonusNumber);

            Rank rank = Rank.getRank(matchedCount,matchBounus);
            lottoResult.addNumberOfMatch(rank);
        }

        System.out.println("총 당첨 결과:");
        for (Rank rank : Rank.values()) {
            System.out.println(rank + " 당첨 횟수: " + lottoResult.getLottoResultTable().get(rank) + " 회");
        }

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
}
