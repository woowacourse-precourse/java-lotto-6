package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.domain.WinLottoResult;

public class GameService {

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

    static private List<Integer> getRandomNumList() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortRandomNumList(list); //정렬 시키기
        return list;
    }

    static private void sortRandomNumList(List<Integer> list) {
        Collections.sort(list);
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

}
