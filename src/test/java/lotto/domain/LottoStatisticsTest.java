package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsTest {

    private LinkedHashMap<Rank, Integer> rankHashMap;
    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        rankHashMap = new LinkedHashMap<>();
        lottoStatistics = new LottoStatistics(rankHashMap);
    }

    public LinkedHashMap<Rank, Integer> allocateHashMap() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 10,11,12);
        int bonusNumber = 13;
        rankHashMap = lottoStatistics.getRankResult(lotto, winningNumbers, bonusNumber);
        return rankHashMap;
    }

    @Test
    @DisplayName("5등일 때 로또 정보와 해당 횟수가 올바르게 LinkedHashMap에 저장되는지 테스트")
    void when_second_prize_save_correctly_in_hashMap() {
        LinkedHashMap<Rank, Integer> map = allocateHashMap();
        for (Rank rank : rankHashMap.keySet()) {
            assertEquals(rank.getPrize(), 5000);
        }

        for (Integer value : rankHashMap.values()) {
            assertEquals(value, 1);
        }
    }



}