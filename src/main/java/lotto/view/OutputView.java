package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    public void purchaseLottoNumbersDisplay(List<Lotto> lottos){
        int lottoQuantity = lottos.size();
        System.out.println("");
        System.out.println(lottoQuantity+"개를 구매했습니다.");
        for (int quantity = 1 ; quantity <= lottoQuantity ; quantity++){
            lottos.get(quantity-1).lottoNumberDisplay();
        }
        System.out.println("");
    }

    public void lottoWinningResultDisplay(List<Lotto> lottos ,List<Integer> winningNumber, int bonusNumber){
        int totalWinningAmount = 0;
        double totalReturnRate = 0.0;
        int lottoQuantity = lottos.size();
        double totalLottoPurchase = 1000 * lottoQuantity;

        int threeMatches = 0;
        int fourMatches = 0;
        int fiveMatches = 0;
        int fiveBonusMatches = 0;
        int sixMatches = 0;

        for (int quantity = 0 ; quantity < lottoQuantity ; quantity ++){

            int winningAmount = lottoWinningAmount(lottos.get(quantity).getNumbers(), winningNumber, bonusNumber);
            totalWinningAmount += winningAmount;

            if(winningAmount == 5000){
                threeMatches++;
            }

            if(winningAmount == 50000){
                fourMatches++;
            }

            if(winningAmount == 1500000){
                fiveMatches++;
            }

            if(winningAmount == 30000000){
                fiveBonusMatches++;
            }

            if(winningAmount == 200000000){
                sixMatches++;
            }

        }

        totalReturnRate = (totalWinningAmount/totalLottoPurchase)*100;
        String totalRate = String.format("%.1f",totalReturnRate);

        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeMatches+"개");
        System.out.println("4개 일치 (50,000원) - " + fourMatches+"개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatches+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusMatches+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatches+"개");
        System.out.println("총 수익률은 "+ totalRate +"%입니다.");
    }

    private int lottoWinningAmount(List<Integer> lotto ,List<Integer> winningNumber, int bonusNumber){
        int matchCount = 0;
        for(int i = 0 ; i < winningNumber.size() ; i++){
            if(lotto.contains(winningNumber.get(i))){
                matchCount++;
            }
        }

        if(matchCount == 3){
            return 5000;
        }
        if(matchCount == 4){
            return 50000;
        }
        if(matchCount == 5){
            if(lotto.contains(bonusNumber)){
                return 30000000;
            }
            return 1500000;
        }
        if(matchCount == 6){
            return 200000000;
        }
        return 0;
    }
}
