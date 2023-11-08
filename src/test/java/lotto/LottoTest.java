package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호에 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotNumber() {
        assertThatThrownBy(() -> Lotto.createLotto("1,2,3,4,a,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testWinCheck() {
        Record expectedOutput = new LottoRecord(4, false);
        Lotto lotto = Lotto.createLotto("1,2,3,4,5,6");
        Lotto winLotto = Lotto.createLotto("1,2,3,4,15,16");
        assertThat(lotto.winCheck(winLotto, 45)).isEqualTo(expectedOutput);

        expectedOutput = new LottoRecord(4, true);
        lotto = Lotto.createLotto("1,2,3,4,5,6");
        winLotto = Lotto.createLotto("1,2,3,4,15,45");
        assertThat(lotto.winCheck(winLotto, 6)).isEqualTo(expectedOutput);

        expectedOutput = new LottoRecord(0, false);
        lotto = Lotto.createLotto("11,22,31,45,15,36");
        winLotto = Lotto.createLotto("1,2,3,4,5,6");
        assertThat(lotto.winCheck(winLotto, 26)).isEqualTo(expectedOutput);

    }

    @Test
    void testCreateLotto() {
        Lotto expectedOutput = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(Lotto.createLotto("1,2,3,4, 5,6").getLottoNumbers())
                .isEqualTo(expectedOutput.getLottoNumbers());
        assertThat(Lotto.createLotto("1,2,3,4, 5,6").getClass()).isEqualTo(expectedOutput.getClass());

    }

    @Test
    void createBonusNumber() {
        int expectedOutput = 10;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.createBonusNumber("10")).isEqualTo(expectedOutput);

        //문자 입력시 예외가 잘 나는가
        assertThatThrownBy(() -> lotto.createBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}