package lotto.model.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @DisplayName("로또 당첨 보상 객체 생성을 테스트한다.")
    @Test
    public void createPrize() {
        Prize prize = Prize.valueOf(3, false);
        assertThat(prize).isNotNull();
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또 당첨 보상 문구 변환을 테스트한다.")
    @Test
    public void formatMessage() {
        Prize prize = Prize.valueOf(3, false);
        String message = prize.formatMessage(1);
        assertThat(message).isEqualTo("3개 일치 (5,000원) - 1개");
    }

    @DisplayName("로또에 따라 갱신된 로또 당첨 보상 객체를 테스트한다.")
    @Test
    public void getPrize() {
        List<Prize> prizes = Prize.getPrize();
        assertThat(prizes).isNotNull();
        assertThat(prizes).hasSize(5);

        assertThat(Prize.FIFTH).isEqualTo(prizes.get(0));
        assertThat(Prize.FOURTH).isEqualTo(prizes.get(1));
        assertThat(Prize.THIRD).isEqualTo(prizes.get(2));
        assertThat(Prize.SECOND).isEqualTo(prizes.get(3));
        assertThat(Prize.FIRST).isEqualTo(prizes.get(4));
    }
}