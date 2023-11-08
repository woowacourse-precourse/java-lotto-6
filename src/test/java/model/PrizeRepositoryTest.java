package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeRepositoryTest {

    @DisplayName("처음 당첨된 등수인지 확인하는 테스트")
    @Test
    void lottoPrizeFirstRank() {
        PrizeRepository prizeRepository = new PrizeRepository();
        assertThat(prizeRepository.hasContain(Prize.of(5, false))).isFalse(); //당첨 번호 5개를 맞추고, 보너스 번호를 못 맞춘 등수는 아직 없음
    }

    @DisplayName("당첨된 적이 있는 등수인지 확인하는 테스트")
    @Test
    void lottoPrizeDuplicationRank() {
        PrizeRepository prizeRepository = new PrizeRepository();
        prizeRepository.add(Prize.of(3,false));
        assertThat(prizeRepository.hasContain(Prize.of(3, false))).isTrue(); //당첨 번호 3개를 맞춘 로또가 존재함.
    }
}
