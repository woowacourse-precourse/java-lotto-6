package lotto;

import lotto.Lotto.entity.Lotto;
import lotto.LottoPlayer.service.LottoPlayerService;
import lotto.LottoPlayer.service.UIService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("입력된 로또 번호를 오름차순으로 정렬한다.")
    @Test
    void readLottoNumbers() {
        //given
        LottoPlayerService service = new LottoPlayerService();

        List<Lotto> issued_lotto = new ArrayList<>();
        issued_lotto.add(new Lotto(new ArrayList<>(List.of(41, 42, 43, 8, 21, 23))));
        issued_lotto.add(new Lotto(new ArrayList<>(List.of(38, 32, 11, 5, 16, 3))));
        issued_lotto.add(new Lotto(new ArrayList<>(List.of(35, 44, 7, 16, 11, 36))));
        issued_lotto.add(new Lotto(new ArrayList<>(List.of(42, 41, 11, 8, 31, 1))));
        issued_lotto.add(new Lotto(new ArrayList<>(List.of(22, 45, 5, 14, 1, 3))));
        issued_lotto.add(new Lotto(new ArrayList<>(List.of(41, 42, 43, 8, 21, 23))));
        issued_lotto.add(new Lotto(new ArrayList<>(List.of(11, 40, 43, 30, 42, 7))));
        issued_lotto.add(new Lotto(new ArrayList<>(List.of(38, 45, 32, 13, 2, 22))));


        //when
        List<Lotto> sortedLotto = service.sortIssuedLottoAscending(issued_lotto);

        //then
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(List.of(8, 21, 23, 41, 42, 43));
        expectedOutput.add(List.of(3, 5, 11, 16, 32, 38));
        expectedOutput.add(List.of(7, 11, 16, 35, 36, 44));
        expectedOutput.add(List.of(1, 8, 11, 31, 41, 42));
        expectedOutput.add(List.of(1, 3, 5, 14, 22, 45));
        expectedOutput.add(List.of(8, 21, 23, 41, 42, 43));
        expectedOutput.add(List.of(7, 11, 30, 40, 42, 43));
        expectedOutput.add(List.of(2, 13, 22, 32, 38, 45));

        List<List<Integer>> actualOutput = new ArrayList<>();
        for (Lotto lotto : sortedLotto) {
            actualOutput.add(lotto.getNumbers());
        }

        assertEquals(expectedOutput, actualOutput);

    }


}