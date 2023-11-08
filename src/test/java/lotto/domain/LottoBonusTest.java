package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusTest {
    Lotto winningLotto;

    @BeforeEach
    void before() {
        winningLotto = new Lotto("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createLottoBonusByDuplicateNumber() {
        assertThatThrownBy(() -> new LottoBonus(winningLotto, "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createLottoBonusByGreaterNumber() {
        assertThatThrownBy(() -> new LottoBonus(winningLotto, "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createLottoBonusByLessNumber() {
        assertThatThrownBy(() -> new LottoBonus(winningLotto, "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("조건을 모두 만족하는 보너스 번호에 대해 결과가 잘 나오는지 확인한다.")
    @Test
    void createLottoBonusBy7() {
        assertThat(new LottoBonus(winningLotto, "7").getNumber()).isEqualTo(7);
    }

    @DisplayName("공백이 잘 제거되는지 확인한다.")
    @Test
    void createLottoBonusBy7WithSpaces() {
        assertThat(new LottoBonus(winningLotto, "   7").getNumber()).isEqualTo(7);
        assertThat(new LottoBonus(winningLotto, "7   ").getNumber()).isEqualTo(7);
        assertThat(new LottoBonus(winningLotto, "  7 ").getNumber()).isEqualTo(7);
    }
}
