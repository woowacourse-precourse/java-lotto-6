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
            Collections.sort(randomList);
            Lotto lotto = new Lotto(randomList);
            lotto.printNumber(randomList);
            list.add(lotto);
        }

        System.out.println();
        return list;
    }

    public static List<Integer> checkList(List<Lotto> lottoList, List<Integer> winNumbers, int addNum) {
        for (int i = 0; i < lottoList.size(); i++){
            Lotto lotto = lottoList.get(i);

            int winNum = 0;

            for(int j = 0; j < lotto.getNumbers().size(); j++){
                if(winNumbers.contains(lotto.getNumbers().get(j))){
                    winNum++;
                }
            }
            System.out.println(winNum);
            System.out.println();
        }
        return null;
    }

    // 당첨 내역 출력 :
    public static List<Lotto> prizeList(int count) {
        System.out.print("3개 일치 (5,000원) - ");
        System.out.print("4개 일치 (50,000원) - ");
        System.out.print("5개 일치 (1,500,000원) - ");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.print("6개 일치 (2,000,000,000원) - ");

        List<Lotto> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomList);
            Lotto lotto = new Lotto(randomList);
            lotto.printNumber(randomList);
            list.add(lotto);
        }

        System.out.println();
        return list;
    }
}
