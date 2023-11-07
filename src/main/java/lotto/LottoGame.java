package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoGame {
    private static final int PERCENTAGE = 100;
    public void playGame(){

        final int lottoAmount = 1000;
        int purchaseAmount = InputHandler.purchaseAmountInput();
        int purchaseNumber = purchaseAmount/lottoAmount;

        Lotto[] lottos = new Lotto[purchaseNumber];

        System.out.println(purchaseNumber+"개를 구매했습니다.");
        for(int i = 0; i < purchaseNumber; i++){
            List<Integer> autoLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos[i] = new Lotto(autoLotto);
            System.out.println(lottos[i].getLottoNumbers());
        }
        System.out.println();

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

        System.out.println("당첨통계");
        System.out.println("---");
        int totalMoney = 0;
        for (Rank rank : Rank.values()) {
            if(rank.getWinningMoney() == 0){
                continue;
            }

            totalMoney += rank.getWinningMoney()*lottoResult.getLottoResultTable().get(rank);

            System.out.print(rank.getNumberOfMatch() + "개 일치");
            if(rank.getWinningMoney() == 30000000 ){
                System.out.print(", 보너스 볼 일치");
            }
            System.out.println(" ("+ String.format("%,d",rank.getWinningMoney())+ "원) - "+ lottoResult.getLottoResultTable().get(rank) + "개");
        }

        float rateOfReturn = (float)totalMoney/purchaseAmount*PERCENTAGE;
        System.out.println("총 수익률은 "+ String.format("%.1f", rateOfReturn)+"%입니다.");

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
