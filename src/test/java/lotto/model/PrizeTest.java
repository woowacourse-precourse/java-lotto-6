package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @DisplayName("로또 당첨 랭킹 객체 생성을 테스트한다.")
    @Test
    public void createRank() {
        Prize prize = Prize.valueOf(3, false);
        assertThat(prize).isNotNull();
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또 당첨 랭킹 문구 변환을 테스트한다.")
    @Test
    public void formatMessage() {
        Prize prize = Prize.valueOf(3, false);
        String message = prize.formatMessage(1);
        assertThat(message).isEqualTo("3개 일치 (5,000원) - 1개");
    }
}