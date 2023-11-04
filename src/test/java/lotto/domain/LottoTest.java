package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 테스트")
class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void testOverSizeLottoValidation() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.from(1));
        lottoNumbers.add(LottoNumber.from(2));
        lottoNumbers.add(LottoNumber.from(3));
        lottoNumbers.add(LottoNumber.from(4));
        lottoNumbers.add(LottoNumber.from(5));
        lottoNumbers.add(LottoNumber.from(6));
        lottoNumbers.add(LottoNumber.from(7));

        assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_LENGTH.getErrorMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void testDuplicatedLottoValidation() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.from(1));
        lottoNumbers.add(LottoNumber.from(2));
        lottoNumbers.add(LottoNumber.from(3));
        lottoNumbers.add(LottoNumber.from(4));
        lottoNumbers.add(LottoNumber.from(5));
        lottoNumbers.add(LottoNumber.from(5));

        assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_LOTTO.getErrorMessage());
    }

    @DisplayName("조건에 맞는 로또는 검증을 통과한다.")
    @Test
    void testCreateLottoWithProperValues() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.from(1));
        lottoNumbers.add(LottoNumber.from(2));
        lottoNumbers.add(LottoNumber.from(3));
        lottoNumbers.add(LottoNumber.from(4));
        lottoNumbers.add(LottoNumber.from(5));
        lottoNumbers.add(LottoNumber.from(6));

        assertThatNoException().isThrownBy(() -> Lotto.from(lottoNumbers));
    }
}