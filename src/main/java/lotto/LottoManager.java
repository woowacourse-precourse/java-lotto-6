package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    // 당첨 번호 리스트
    int[] lotto_winnerNumbers = new int[7];
    // 당첨 등수 기록 리스트
    int[] winning_rank = new int[5];
    double profitAmount = 0;

    public void setLottoWinnerNumber(String[] lottoNumbers, int bonusNumber) {
        for(int i = 0; i < lottoNumbers.length; i++) {
            lotto_winnerNumbers[i] = Integer.parseInt(lottoNumbers[i]);
        }
        lotto_winnerNumbers[6] = bonusNumber;
    }

    public void checkWining(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            compareNumber(lotto);
        }
    }

    public void compareNumber(Lotto lotto) {
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

    public void showWiningStatics(int purchaseAmount) {
        System.out.print("당첨 통계\n---\n");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winning_rank[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", winning_rank[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winning_rank[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winning_rank[1]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winning_rank[0]);

        String profit = calculateProfit(purchaseAmount, profitAmount);
        System.out.printf("총 수익률은 %s%%입니다.", profit);

    }
    public String calculateProfit(int purchaseAmount, double profitAmount) {
        double profit = (profitAmount / purchaseAmount) * 100;
        String result = String.format("%.1f", profit);
        return result;
    }
    public List<Lotto> publishLotto(int money) {
        int lottopaperNumbers = money / 1000;

        List<Lotto> lotto_list = new ArrayList<>();

        for(int i = 0; i < lottopaperNumbers; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto_list.add(lotto);
        }

        System.out.printf("%d개를 구매했습니다.\n", lottopaperNumbers);
        return lotto_list;
    }
}
