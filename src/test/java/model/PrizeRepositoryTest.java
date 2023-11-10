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

    @DisplayName("로또 당첨 등수와 수량이 올바르게 저장되었는지 확인하는 테스트")
    @Test
    void getLottoPrize() {
        PrizeRepository prizeRepository = new PrizeRepository();
        prizeRepository.add(Prize.of(5,true));
        assertThat(prizeRepository.getPrizeRepository().get(Prize.of(5, true))).isEqualTo(1);
    }

    @DisplayName("하나의 등수에서 로또 수량만큼 얻을 수 있는 당첨금을 구하는 테스트")
    @Test
    void getPrizeByOneRank() {
        PrizeRepository prizeRepository = new PrizeRepository();
        prizeRepository.add(Prize.of(4,false));
        prizeRepository.add(Prize.of(4,false));

        assertThat(prizeRepository.calculateTotalReword()).isEqualTo(100000);
    }

    @DisplayName("전체 로또 당첨금을 구하는 테스트")
    @Test
    void getTotalPrize() {
        PrizeRepository prizeRepository = new PrizeRepository();
        prizeRepository.add(Prize.ND2);
        prizeRepository.add(Prize.ND2);
        prizeRepository.add(Prize.TH4);
        prizeRepository.add(Prize.TH4);
        prizeRepository.add(Prize.TH4);
        prizeRepository.add(Prize.TH4);
        assertThat(prizeRepository.calculateTotalReword()).isEqualTo(60200000);
    }
}
