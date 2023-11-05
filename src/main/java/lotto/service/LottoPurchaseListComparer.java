package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseListComparer {
    private List<Integer> resultList = new ArrayList<>();

    // 매치값 초기화
    public LottoPurchaseListComparer() {
        for (int i = 0; i < 5; i++) {
            resultList.add(0);
        }
    }

    public List<Integer> getResultList() {
        return resultList;
    }

    // 구매 로또 묶음이랑 입력 당첨번호(+보너스번호)끼리 비교
    public void compareBundle(List<List<Integer>> purchase, List<Integer> lotto, int bonus) {
        for (List<Integer> purchaseUnit : purchase) {
            int match = compareUnitNumber(purchaseUnit, lotto, bonus);

            // match 값에 따라 resultList의 해당 인덱스를 업데이트
            if (match >= 3 && match <= 7) {
                resultList.set(match - 3, resultList.get(match - 3) + 1);
            }
        }
    }

    // 구매 로또 단위랑 입력 당첨번호(+보너스번호)끼리 비교(prize가 내가 산 거)
    public int compareUnitNumber(List<Integer> purchaseUnit, List<Integer> lotto, int bonus) {
        int match = 0;
        for (Integer number : purchaseUnit) {
            if (lotto.contains(number)) {
                match++;
            }
        }
        // 이건 보너스 번호 일치하는 2등 케이스
        if (match == 5 && purchaseUnit.contains(bonus)) {
            return match + 1;
        }
        // 이건 전부 다 일치하는 1등 케이스
        if (match == 6) {
            return match + 1;
        }
        // 어차피 1개 일치하나 2개 일치하나 무슨 상관이야. 3개 이상으로 리턴
        if (match >= 3) {
            return match;
        }
        return 0;
    }

}
