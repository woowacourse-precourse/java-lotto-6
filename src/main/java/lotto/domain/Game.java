package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_LEN = 6;

    /**
     * 2. 구매 가능한 로또 개수만큼 로또 자동 발급기능
     */
    public List<Lotto> generateLottoList(int lottoCount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            //랜덤 값 자동 생성 및 세팅
            list.add(new Lotto(getRandomNumList()));
        }
        return list;
    }

    private List<Integer> getRandomNumList() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LEN);
        return sort(list);
    }

    private List<Integer> sort(List<Integer> list) {
        // ApplicationTest 에서 테스트할 때 immutable list 를 넘겨줄 때가 있어서 mutable list 로 만들어줌
        List<Integer> copiedList = new ArrayList<>(list);
        Collections.sort(copiedList);
        return copiedList;
    }


    /**
     * 6. 당첨에 대한 통계 기능
     */
    public void judgePrizeLotto(WinLotto winLotto, List<Lotto> lottoList, WinLottoResult winLottoResult) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < lottoList.size(); i++) {
            int count = countWithNum(lottoList.get(i), winLotto);
            boolean flag = isBunus(lottoList.get(i), winLotto.getBonus_num());

            if (count == 3) {
                map.put("three", map.getOrDefault("three", 0) + 1);
            }
            if (count == 4) {
                map.put("four", map.getOrDefault("four", 0) + 1);
            }
            if (count == 5 && !flag) {
                map.put("five", map.getOrDefault("five", 0) + 1);
            }
            if (count == 5 && flag) {
                map.put("five_bonus", map.getOrDefault("five_bonus", 0) + 1);
            }
            if (count == 6) {
                map.put("six", map.getOrDefault("six", 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            for (WinLottoResult cur : winLottoResult.values()) {
                if (cur.getName().equals(key)) {
                    cur.setCount(map.get(key));
                }
            }
        }
    }

    private boolean isBunus(Lotto lotto, int bonus) {
        List<Integer> list = lotto.getNumbers();
        if (list.contains(bonus)) {
            return true;
        }

        return false;
    }

    //각 리스트별 카운팅 개수 리턴해서
    private int countWithNum(Lotto lotto, WinLotto winLotto) {
        List<String> lotto_num = lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        List<String> winLotto_list = winLotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        lotto_num.retainAll(winLotto_list);//중복되는 것만 남게

        return lotto_num.size();
    }


    /**
     * 수익률 계산 기능
     */
    public int getLottoPrizePrice(WinLottoResult winLottoResult) {
        int lottoPrizePrice = 0;
        for (WinLottoResult cur : winLottoResult.values()) {
            if (cur.getName().equals("three")) {
                lottoPrizePrice += (5000) * cur.getCount();
            }
            if (cur.getName().equals("four")) {
                lottoPrizePrice += (50000) * cur.getCount();
            }
            if (cur.getName().equals("five")) {
                lottoPrizePrice += (1500000) * cur.getCount();
            }
            if (cur.getName().equals("five_bonus")) {
                lottoPrizePrice += (30000000) * cur.getCount();
            }
            if (cur.getName().equals("six")) {
                lottoPrizePrice += (2000000000) * cur.getCount();
            }
        }
        return lottoPrizePrice;
    }

    public double getPercentPrize(int inPrice, int outPrice) {
        double inVal = inPrice + 0.0;
        double outVal = outPrice + 0.0;

        double result = outVal / inVal * 100;
        result = Math.round(result * 100) / 100.0; //소수점 둘째 자리에서 반올림하고,
        return result;
    }
}
