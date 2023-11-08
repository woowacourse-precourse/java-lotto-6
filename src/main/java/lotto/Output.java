package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Output {

    // 로또 번호 출력
    public static List<Lotto> createLottoNumbers(int count) {
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomList);
            lotto.printNumber(randomList);
            list.add(lotto);
        }

        System.out.println();
        return list;
    }

    // 로또 번호 수 및 보너스 번호 체크하기
    public static List<Integer> checkList(List<Lotto> lottoList, List<Integer> winNumbers, int addNum) {
        // 횟수 count 위한 List 생성 및 초기화
        List<Integer> prizeCount = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            prizeCount.add(0);
        }

        for (int i = 0; i < lottoList.size(); i++){
            Lotto lotto = lottoList.get(i);
            int winNum = 0;
            int bonusNum = 0;
            for(int j = 0; j < lotto.getNumbers().size(); j++){
                if(winNumbers.contains(lotto.getNumbers().get(j))){
                    winNum++;
                }
            }
            if(lotto.getNumbers().contains(addNum)){
                bonusNum++;
            }
            if(winNum == 5 && bonusNum == 1){
                prizeCount.set(7, prizeCount.get(7) + 1);
                continue;
            }
            prizeCount.set(winNum, prizeCount.get(winNum) + 1);
        }
        return prizeCount;
    }

    // 당첨 내역 출력
    public static double prizeRate(List<Integer> prizeCount, int purchaseMoney) {
        System.out.println("3개 일치 (5,000원) - " + prizeCount.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount.get(6) + "개");

        long sum = 5000*prizeCount.get(3) + 50000*prizeCount.get(4) + 1500000*prizeCount.get(5) + 30000000*prizeCount.get(7) + 2000000000*prizeCount.get(6);

        double profitRate = (double)sum / purchaseMoney * 100.0;

        System.out.print("총 수익률은 " );
        System.out.print(Math.round(profitRate*10)/10.0);
        System.out.println("%입니다.");

        return profitRate;
    }
}
