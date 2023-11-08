package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.ConstantNum.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private List<Integer> lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + WINNING_NUMBER_CNT.getNum(); i++) {
            lottoNumber.add(i);
        }
    }


    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자가 범위를 넘어갈 경우 예외 발생")
    @Test
    void Should_ThrowException_When_LottoNumberIsOutOfRange() {
        // given
        List<Integer> wrongLottoNumber = new ArrayList<>(lottoNumber);
        wrongLottoNumber.set(wrongLottoNumber.size() - 1, LOTTO_NUMBER_MAX.getNum() + 1);

        // when & then
        assertThatThrownBy(() -> new Lotto(wrongLottoNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}