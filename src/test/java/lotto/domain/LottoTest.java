package lotto.domain;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LottoTest {

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

    @DisplayName("올바른 로또 번호로 로또가 정상적으로 생성된다.")
    @Test
    void createLottoByValidLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertNotNull(lotto);
    }

    @DisplayName("로또의 로또 번호들을 정상적으로 반환한다.")
    @Test
    void getLottoNumbers() {
        List<LottoNumber> expectedLottoNumbers = new ArrayList<>(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<LottoNumber> actualLottoNumbers = lotto.getLottoNumbers();

        assertEquals(expectedLottoNumbers.size(), actualLottoNumbers.size());
        for (int index = 0; index < expectedLottoNumbers.size(); index++) {
            assertEquals(expectedLottoNumbers.get(index).getLottoNumber(),
                actualLottoNumbers.get(index).getLottoNumber());
        }
    }

    @DisplayName("로또가 특정 로또 번호를 포함하고 있는지 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "7,false"})
    void lottoContainsParticularLottoNumber(int number, boolean expectedContains) {
        LottoNumber lottoNumber = new LottoNumber(number);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(expectedContains, lotto.contains(lottoNumber));
    }
}