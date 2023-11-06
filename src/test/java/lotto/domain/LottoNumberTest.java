package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 13, 43, 45})
    void createLottoNumber_success(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertNotNull(lottoNumber);
    }

    @DisplayName("로또 번호 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 49, 51})
    void createLottoNumber_fail_throw_IllegalArgumentException(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(number);
        });
    }
}