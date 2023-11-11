package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.dto.WinningNumDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    WinningNumDTO winningNum;

    @BeforeEach
    void beforeEach() {
        winningNum = WinningNumDTO.of("1,2,3,4,5,6", "7");
    }

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

    @DisplayName("view 에 전달할 로또 번호의 문자열 생성")
    @Test
    void generateStringForView() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        String selectedNumbers = lotto.writePurchasedLotto();
        // then
        Assertions.assertThat(selectedNumbers).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("[로또 결과] 당첨 번호와 동일한 수가 3개 있고, 보너스 번호는 맞지 않는 경우")
    @Test
    void checkResultTest1() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        // when
        Ranking ranking = lotto.checkResult(winningNum);
        Ranking expectedRanking = Ranking.of(3, false);
        // then
        Assertions.assertThat(ranking).isEqualTo(expectedRanking);
    }

    @DisplayName("[로또 결과] 당첨 번호와 동일한 수가 5개, 보너스 번호가 맞을 경우")
    @Test
    void checkResultTest2() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        // when
        Ranking ranking = lotto.checkResult(winningNum);
        Ranking expectedRanking = Ranking.of(5, true);
        // then
        Assertions.assertThat(ranking).isEqualTo(expectedRanking);
    }
}