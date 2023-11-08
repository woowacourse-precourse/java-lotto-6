package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameHandler {

    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 5000;
    private static final int LOTTO_PRICE = 1000;

    //로또 발행기능
    public void createLotto() {

    }

    //당첨로또 발행기능
    public WinningTicket createWinningTicket(List<Integer> winningNum, int bonumNum) {
        return new WinningTicket(winningNum, bonumNum);

    }

    //당첨통계 계산기능
    public List<Integer> checkWinningResult(List<Lotto> lottos, WinningTicket winningTicket) {
        List<Integer> winningRank = new ArrayList<>(Collections.nCopies(5, 0));
        List<Integer> winningNums = winningTicket.getWinningNumbers();
        int bonusNum = winningTicket.getBonusNumber();

        for(int i=0; i< lottos.size(); i++) {
            List<Integer> lottoNum = lottos.get(i).getNumbers();
            int equalNum = 0;

            for(int j=0; j< lottoNum.size(); j++) {
                if(winningNums.contains(lottoNum.get(j))) {
                    equalNum++;
                }
            }

            if(equalNum == 6) {
                int oneRank = winningRank.get(0);
                winningRank.set(0, oneRank + 1);
            }
            if(equalNum == 5 && lottoNum.contains(bonusNum)) {
                int twoRank = winningRank.get(1);
                winningRank.set(1, twoRank + 1);
            }
            if(equalNum == 5) {
                int threeRank = winningRank.get(2);
                winningRank.set(2, threeRank + 1);
            }
            if(equalNum == 4) {
                int fourRank = winningRank.get(3);
                winningRank.set(3, fourRank + 1);
            }
            if(equalNum == 3) {
                int fiveRank = winningRank.get(4);
                winningRank.set(4, fiveRank + 1);
            }
        }
        return winningRank;
    }

    //우승상금 수익률 계산하는 기능
    public float calculatePrizes(int purchaseQuantity, List<Integer> rankResult) {
        int purchaseAmount = purchaseQuantity * LOTTO_PRICE;
        int winningPrize = 0;

        for(int i=0; i<rankResult.size(); i++) {
            if(i == 0) {
                winningPrize += rankResult.get(i) * FIRST_PRIZE;
            }
            if(i == 1) {
                winningPrize += rankResult.get(i) * SECOND_PRIZE;
            }
            if(i == 2) {
                winningPrize += rankResult.get(i) * THIRD_PRIZE;
            }
            if(i == 3) {
                winningPrize += rankResult.get(i) * FOURTH_PRIZE;
            }
            if(i == 4) {
                winningPrize += rankResult.get(i) * FIFTH_PRIZE;
            }
        }

        float rateOfReturn1 =  (((float)(winningPrize - purchaseAmount) / purchaseAmount) * 100) + 100f;

        float rateOfReturn2 = (float) (Math.round(rateOfReturn1 * 100.0) / 100.0);





        return rateOfReturn2;
    }


}
