package lotto;

import java.util.List;

public class LottoManager {
    int[] lotto_winnerNumbers = new int[7];
    // 당첨 여부 리스트
    int[] winning_rank = new int[5];
    int profitAmount = 0;

    public LottoManager(String[] lottoNumbers, String bonusNumber) {
        for(int i = 0; i < lottoNumbers.length; i++) {
            lotto_winnerNumbers[i] = Integer.parseInt(lottoNumbers[i]);
        }
        lotto_winnerNumbers[6] = Integer.parseInt(bonusNumber);
    }

    public void checkWining(List<Lotto> lottoList) {

        for(Lotto lotto : lottoList) {
            int count = 0;
            boolean bonusCorrect = false;
            for(int number : lotto_winnerNumbers) {
                if(lotto.getNumbers().contains(number)) {
                    count += 1;
                }
                if(lotto.getNumbers().contains(lotto_winnerNumbers[6])) {
                    bonusCorrect = true;
                }
            }
            if(count == 6) {
                //1등
                winning_rank[0] += 1;
                profitAmount += 2000000000;
            }else if(count == 5 && bonusCorrect == true) {
                //2등
                winning_rank[1] += 1;
                profitAmount += 30000000;
            }else if(count == 5) {
                //3등
                winning_rank[2] += 1;
                profitAmount += 1500000;
            }else if(count == 4) {
                //4등
                winning_rank[3] += 1;
                profitAmount += 50000;
            }else if(count == 3) {
                // 5등
                winning_rank[4] += 1;
                profitAmount += 5000;
            }

        }
    }
    public void showWiningStatics() {
        System.out.print("당첨 통계\n---\n");
        System.out.printf("3개 일치 (5,000원) - %d\n", winning_rank[0]);
        System.out.printf("4개 일치 (50,000원) - %d\n", winning_rank[1]);
        System.out.printf("5개 일치 (1,500,000원) %d\n", winning_rank[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d\n", winning_rank[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d\n", winning_rank[4]);

        System.out.printf("총 수익률은 %d%입니다", profitAmount);
    }
}
