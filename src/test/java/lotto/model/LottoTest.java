package lotto.model;

import static lotto.constant.Constant.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void createLotto() {
        lotto = Lotto.createLotto();
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 6개이다.")
    @Test
    void lottoSizeMustBeSix_Test() {
        //then
        assertEquals(LOTTO_SIZE, lotto.getNumbers().size());
    }

    @DisplayName("로또는 서로 중복된 숫자가 없다.")
    @Test
    void no_DuplicateNumber_In_Lotto_Test() {
        //then
        long count = lotto.getNumbers().stream().distinct().count();

        assertEquals(LOTTO_SIZE, count);
    }
}