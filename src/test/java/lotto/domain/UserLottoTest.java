package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.argument.CalculateRankArgumentsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class UserLottoTest {

    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복인 경우 예외 발생")
    void lottoAndBonusNumberDuplicateTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(6);

        // expected
        assertThrows(IllegalArgumentException.class, () -> UserLotto.from(lotto, bonusLottoNumber));
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복되지 않은 경우 정상 생성")
    void userLottoCreateTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(7);

        // expected
        assertDoesNotThrow(() -> UserLotto.from(lotto, bonusLottoNumber));
    }

    @ParameterizedTest(name = "로또 번호 : {0}, 보너스 번호 : {1}, 예상 결과 : {2}")
    @ArgumentsSource(CalculateRankArgumentsProvider.class)
    @DisplayName("두 로또와 보너스 번호를 비교하는 테스트")
    void calculateRankTest(final List<Integer> lottoNumber, final int bonusNumber, final Rank expected) {
        // given
        Lotto lotto = new Lotto(lottoNumber);
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
        UserLotto userLotto = UserLotto.from(lotto, bonusLottoNumber);
        Lotto other = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Rank actual = userLotto.calculateRank(other);

        // then
        assertEquals(expected, actual);
    }
}