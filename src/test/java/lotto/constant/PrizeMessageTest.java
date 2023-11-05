package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeMessageTest {

    @DisplayName("1등 메세지 출력 테스트")
    @Test
    void printFirstPrize() {
        assertThat(PrizeMessage.FIRST.getMessage()).isEqualTo("6개 일치 (2,000,000,000원) - ");
    }

    @DisplayName("2등 메세지 출력 테스트")
    @Test
    void printSecondPrize() {
        assertThat(PrizeMessage.SECOND.getMessage()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
    }

    @DisplayName("3등 메세지 출력 테스트")
    @Test
    void printThirdPrize() {
        assertThat(PrizeMessage.THIRD.getMessage()).isEqualTo("5개 일치 (1,500,000원) - ");
    }

    @DisplayName("4등 메세지 출력 테스트")
    @Test
    void printFourthPrize() {
        assertThat(PrizeMessage.FOURTH.getMessage()).isEqualTo("4개 일치 (50,000원) - ");
    }

    @DisplayName("5등 메세지 출력 테스트")
    @Test
    void printFifthPrize() {
        assertThat(PrizeMessage.FIFTH.getMessage()).isEqualTo("3개 일치 (5,000원) - ");
    }

}