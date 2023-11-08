package lotto.Service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static lotto.domain.StatisticsUtilEnum.*;

public class StatisticsUtil {

    // 로또(리스트) 들과 당첨 번호, 보너스 번호 비교
    // 각 로또가 몇개 맞추었는지 반환
    // ex) [6, 3, 0, 7]
    // -> 6개일치, 3개일치, 0개일치, 5개+보너스일치
    public List<Integer> getMatchCount(List<Lotto> lottos, List<Integer> winningNum, Integer bonusNum) {
        List<Integer> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int duplicatedCount = getDuplicatedCount(winningNum, bonusNum, lotto);
            matchCount.add(duplicatedCount);
        }
        return matchCount;
    }

    // 하나의 로또와 당첨 번호, 보너스 번호 비교
    // 맞춘 개수 반환
    public int getDuplicatedCount(List<Integer> winningNum, Integer bonusNum, Lotto lotto) {
        int duplicatedCount = (int) lotto.getNumbers().stream().filter(old -> winningNum.stream()
                .anyMatch(Predicate.isEqual(old))).count();
        if (duplicatedCount == CHECK_2ND.getStatus()) {
            duplicatedCount = check2ndPlace(bonusNum, lotto, duplicatedCount);
        }
        return duplicatedCount;
    }

    // 5개를 맞출때만 들어오는 함수 - 보너스 번호 비교
    // 보너스 번호를 맞추면 7개 맞춘걸로 인식 -> 이후에 6과 7 자리 바꿈
    private int check2ndPlace(Integer bonusNum, Lotto lotto, int duplicatedCount) {
        if (lotto.getNumbers().contains(bonusNum)) {
            duplicatedCount += SECOND_PLACE_TO_LAST_PLACE.getStatus();
        }
        return duplicatedCount;
    }

    // 위의 getMatchCount()를 통해 만들어진 리스트 속 숫자들의 빈도수 반환
    // ex) [12, 8, 3, 5, 4, 2, 0, 1]
    // -> 1등: 1개, 2등: 0개, 3등: 2개, 4등: 4개, ... 0개 일치: 12개
    public List<Integer> matchCountFrequency(List<Integer> matchCount) {
        List<Integer> matchFrequency = new ArrayList<>();
        for (int i = 0; i < MATCH_SIZE.getStatus(); i++) {
            matchFrequency.add(Collections.frequency(matchCount, i));
        }
        Collections.swap(matchFrequency, CHANGE_LEFT.getStatus(), CHANGE_RIGHT.getStatus());
        return matchFrequency;
    }


    // 총 수익금 반환
    // ex) 60000
    public Integer getTotalReward(List<Integer> matchFrequency, List<String> reward) {
        int totalReward = 0;
        for (int i = 0; i < MATCH_SIZE.getStatus(); i++) {
            totalReward += matchFrequency.get(i) * Integer.parseInt(reward.get(i).replaceAll(",", ""));
        }
        return totalReward;
    }

    // 총 수익률 반환
    // ex) 200.0f
    // 이후에 print할때 소수점 둘째 자리에서 반올림
    public float getReturnRate(List<Integer> matchFrequency, float totalReward) {
        return totalReward / (matchFrequency.stream().mapToInt(Integer::intValue).sum() * LOTTO_PRICE.getStatus()) * 100;
    }
}
