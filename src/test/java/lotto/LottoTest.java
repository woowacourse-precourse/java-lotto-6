package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    @DisplayName("당첨 번호와 발행 번호 비교")
    @Test
    void calculateLottoNumbersTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.setBonus(7);
        int result = lotto.calculateNumbers(List.of(1, 2, 3, 7, 8, 9));
        assertThat(result).isEqualTo(3);
    }


    @DisplayName("당첨 번호 범위 예외처리 테스트입니다")
    @Test
    void unableRangeLottoNumberTest(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,66)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률 계산을 테스트합니다.")
    @Test
    void calculateReturnTest(){
        LottoView view = new LottoView();
        Map<Rank, Integer> ranking = new EnumMap<Rank,Integer>(Rank.class);
        ranking.put(Rank.FIFTH,3);
        ranking.put(Rank.FOURTH,1);
        float expected = view.calculateReturn(ranking, 40000);
        assertThat(expected).isEqualTo(162.5f);
    }


    /*
        단위테스트 조심할것들
        given(준비) : 어떠한 데이터가 준비되었을 때
        when(실행) : 어떠한 함수를 실행하면! (조건을 지정한다고 생각하면 된다.)
        then(검증) : 어떠한 결과가 나와한다.
        verify : 메서드가 호출된 횟수, 타임아웃 시간 체크를 검사할 때 사용 (부가적)
     */
}