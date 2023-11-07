package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또_번호의_범위가_잘못된_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 11, 13, 15, 18, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void 로또_번호가_오름차순으로_정렬되는지_테스트() {

        List<Integer> lottoNumbers = new ArrayList<>(List.of(6, 4, 5, 1, 2, 3));
        List<Integer> sortedLottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.getLotto()).isEqualTo(sortedLottoNumbers);
    }

    @Test
    void 당첨_번호가_중복된_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 13, 15, 18, 43)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NUMBER.getMessage());
    }

    @Test
    void 당첨_번호가_6개가_아닌_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 13, 15, 18, 43, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_LOTTO_SIZE.getMessage());
    }

}
