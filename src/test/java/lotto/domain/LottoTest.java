package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("정상적으로 로또 번호가 생성된다.")
    void createLottoTest() {
        Assertions.assertDoesNotThrow(() -> {
            new Lotto(List.of(1, 42, 23, 32, 8, 9));
        });
    }

    @Test
    @DisplayName("로또 번호가 6자리 이하일 경우 에러반환.")
    void lottoNumberSizeValidTest() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 42, 23, 32, 8)));
        assertThat(e.getMessage()).isEqualTo(Lotto.LENGTH_VALID_LOG);
    }


    @Test
    @DisplayName("로또 번호가 중복일 경우 에러반환.")
    void lottoNumberDuplicateTest() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 42, 23, 32, 8, 8)));
        assertThat(e.getMessage()).isEqualTo(Lotto.DUPLICATE_VALID_LOG);
    }

    @Test
    @DisplayName("로또 번호가 1 ~ 45 사이의 수가 아닐경우 에러반환.")
    void lottoNumberRangeValidTest() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 47, 100, 32, 8, 8)));
        assertThat(e.getMessage()).isEqualTo(Lotto.DUPLICATE_VALID_LOG);
    }


}