package lotto;

import java.util.List;

public class Lottoresult {
    public int lottoresult(List<Lotto> lottos, int[] winnumber){
        int count=0;
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            List<Integer> lottoNumbers = lotto.getNumbers();
            count = processLottoNumbers(lottoNumbers,winnumber);
        }
        return count;
    }
public void lottoprint(int count, int bouns) {
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count5Bonus = 0;
    int count6 = 0;
    int matchCount = count;
    int bounsnum = bouns;
    switch (matchCount) {
        case 3:
            count3++;
            break;
        case 4:
            count4++;
            break;
        case 5:
            if (bounsnum == 1) {
                count5Bonus++;
            }
            count5++;
            break;
        case 6:
            count6++;
            break;
    }
    System.out.println("3개 일치 (5,000원) - " + count3 + "개");
    System.out.println("4개 일치 (50,000원) - " + count4 + "개");
    System.out.println("5개 일치 (1,500,000원) - " + count5 + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count5Bonus + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + count6 + "개");
}
    private int processLottoNumbers(List<Integer> lottoNumbers, int[] winnumber) {
        int count=0;
        for (int j = 0; j < lottoNumbers.size(); j++) {
            for (int k = 0; k < winnumber.length; k++) {
                if (lottoNumbers.get(j) == winnumber[k]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public int bounsresult(List<Lotto> lottos, int bouns){
        int bounscount=0;
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            List<Integer> lottoNumbers = lotto.getNumbers();
            if (lottoNumbers.get(i)==bouns){
                bounscount++;
            }
        }
        return bounscount;
    }



}

