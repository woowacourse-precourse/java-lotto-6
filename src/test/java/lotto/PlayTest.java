package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayTest {
    private Play play;

    @BeforeEach
    void setPlay() {
        play = new Play();
    }

    @DisplayName("1000원 단위가 아니면 예외 발생.")
    @Test
    void 천원_단위_테스트() {
        assertThatThrownBy(() -> play.handleNonThousandUnit("10100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니면 예외 발생.")
    @Test
    void 금액이_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> play.handleNonThousandUnit("1000ㄹ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니면 예외 발생.")
    @Test
    void 당첨_번호가_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> play.handleInvalidNumberCount("1000ㄹ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호가 6개가 아니면 예외 발생.")
    @Test
    void 당첨_번호가_6개가_아니면_예외_발생() {
        assertThatThrownBy(() -> play.handleInvalidNumberCount("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호가 1~45의 범위를 벗어나면 예외 발생.")
    @Test
    void 당첨_번호의_숫자_범위를_넘으면_예외_발생() {
        assertThatThrownBy(() -> play.handleInvalidNumberCount("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니면 예외 발생.")
    @Test
    void 보너스_번호가_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> play.handleInvalidNumberCount("1,2,3,4,5,ㅋ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스번호가 1~45의 범위를 벗어나면 예외 발생.")
    @Test
    void 보너스_번호가_숫자_범위를_넘으면_예외_발생() {
        assertThatThrownBy(() -> play.handleInvalidNumberInput("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 번호가 중복이면 예외 발생.")
    @Test
    void 당첨_번호가_중복이면_예외_발생() {
        assertThatThrownBy(() -> play.handleDuplicateNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
