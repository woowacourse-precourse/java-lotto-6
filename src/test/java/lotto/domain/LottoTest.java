package lotto.domain;

import lotto.exception.LottoException;
import lotto.vo.BonusNumber;
import lotto.vo.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    List<Integer> validLottoNumbers;
    Lotto lotto;

    @BeforeEach
    void beforeEach() {
        validLottoNumbers = Arrays.asList(6, 5, 3, 4, 2, 1);
        lotto = new Lotto(validLottoNumbers);
    }

    @Test
    @DisplayName("로또는 오름차순으로 정렬되어야 한다.")
    public void lottoTest() throws LottoException {
        List<LottoNumber> expectedNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        assertThat(expectedNumbers).isEqualTo(lotto.getNumbers());
    }

    @Test
    @DisplayName("lotto 는 불변하고, 다른 Lotto 와 내부 값(로또 번호들)이 같으면 동등하다")
    void lotto_동등성_비교() {
        Lotto newLotto = new Lotto(Arrays.asList(6, 5, 3, 4, 2, 1));

        Assertions.assertThat(newLotto).isEqualTo(lotto);
    }

    @Test
    @DisplayName("lotto 는 불변하고, 다른 Lotto 와 내부 값(로또 번호들)이 같아도 동일하지 않다.")
    void lotto_동일성_비교() {
        Lotto newLotto = new Lotto(Arrays.asList(6, 5, 3, 4, 2, 1));

        Assertions.assertThat(newLotto).isNotSameAs(lotto);
    }

    @Test
    @DisplayName("로또 숫자 개수가 6개가 아니면 LottoException 를 뱉는다.")
    void validateTest() {
        List<Integer> errorLottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertThatThrownBy(() -> new Lotto(errorLottoNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage("""
                        [ERROR] 1부터 45 사이의 중복되지 않는 숫자 6개를 입력해주세요.
                        양식: "1,7,13,24,42,45"
                        """);
    }

    @Test
    @DisplayName("보너스 번호가 현재 로또 번호와 겹치는지 검증한다. 만약 겹치면 LottoException 를 뱉는다.")
    public void validateAndThrowIfBonusNumberExistsTest() throws LottoException {
        BonusNumber bonusNumber = new BonusNumber(6);

        assertThrows(LottoException.class, () -> lotto.validateAndThrowIfBonusNumberExists(bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호가 현재 로또 번호와 겹치는지 검사한다. 같으면 ture 반환한다.")
    void containsBonusNumberFalseTest() {
        BonusNumber bonusNumber = new BonusNumber(6);

        Assertions.assertThat(lotto.containsBonusNumber(bonusNumber)).isTrue();
    }


    @ParameterizedTest
    @ValueSource(ints = {8, 24, 45})
    @DisplayName("보너스 번호가 현재 로또 번호와 겹치는지 검사한다. 다르면 false 를 반환한다.")
    void containsBonusNumberTrueTest(int number) {
        BonusNumber bonusNumber = new BonusNumber(number);

        Assertions.assertThat(lotto.containsBonusNumber(bonusNumber)).isFalse();
    }

    @Test
    @DisplayName("로또 번호를 출력하면 [1, 2, 3, 4, 5, 6] 형태로 출력해야 한다.")
    void toStringTest() {
        Assertions.assertThat(lotto.toString()).hasToString("""
                [1, 2, 3, 4, 5, 6]""");
    }
}