package lotto.domain;

import lotto.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 43, 45)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }



    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 5)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto();
        assertThatThrownBy(() -> lotto.isValidDuplication(lottoNumbers)) // 인스턴스를 통해 메서드 호출
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("중복되지 않은 6개의 숫자가 있다면 올바르게 로또가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 23, 30, 36, 41, 45})
    void createCorrectLotto(int value) {
        List<LottoNumber> lottoNumbers = Arrays.asList(3, 23, 30, 36, 41, 45)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        assertThat(lottoNumbers.contains(new LottoNumber(value))).isTrue();
    }



}
