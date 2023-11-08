package lotto.model;
import static org.junit.jupiter.api.Assertions.*;

import lotto.util.ErrorMessage;
import lotto.util.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.LOTTO_MUST_HAVE_SIX.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 5));
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.LOTTO_MUST_HAVE_NOT_DUPLICATED_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 1-45 범위를 초과하면 예외가 발생한다.")
    @Test
    void 올바르지_못한_로또_범위() {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 55));
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.LOTTO_MUST_HAVE_BETWEEN_1_AND_45.getMessage());
    }
}
