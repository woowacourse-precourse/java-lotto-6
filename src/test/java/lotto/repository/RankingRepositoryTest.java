package lotto.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankingRepositoryTest {

    private RankingRepository rankingRepository;

    @BeforeEach
    void setUp() {
        rankingRepository = RankingRepository.getInstance();
        rankingRepository.clear();
    }

    @Test
    @DisplayName("increaseNumberOfRanking() 동작 테스트")
    void testIncreaseNumberOfRanking() {
        // Given
        Integer ranking = 1;

        // When
        rankingRepository.increaseNumberOfRanking(ranking);
        rankingRepository.increaseNumberOfRanking(ranking);
        rankingRepository.increaseNumberOfRanking(ranking);

        // Then
        assertEquals(3, rankingRepository.findNumberOfRankingByRanking(ranking));
    }

    @Test
    @DisplayName("findTotalRewards() 동작 테스트")
    void testFindTotalRewards() {
        // Given
        rankingRepository.increaseNumberOfRanking(1);
        rankingRepository.increaseNumberOfRanking(2);
        rankingRepository.increaseNumberOfRanking(3);
        rankingRepository.increaseNumberOfRanking(4);
        rankingRepository.increaseNumberOfRanking(5);

        // When
        Long totalRewards = rankingRepository.findTotalRewards();

        // Then
        assertEquals(2031555000, totalRewards);
    }
}
