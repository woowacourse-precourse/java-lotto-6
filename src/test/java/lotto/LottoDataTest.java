package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.LottoData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoDataTest {

    @Test
    @DisplayName("당첨_번호_입력_검증_통과")
    void 당첨_번호_입력_검증_통과() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThatNoException().isThrownBy(() -> new LottoData(input, bonusNumber));
    }

    @Test
    @DisplayName("당첨_번호_입력_검증_실패_중복_숫자")
    void 당첨_번호_입력_검증_실패_중복_숫자() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new LottoData(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값은 앞서 입력한 값들과 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("당첨_번호_입력_검증_실패_숫자_범위_초과")
    void 당첨_번호_입력_검증_실패_숫자_범위_초과() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new LottoData(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값의 범위는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨_번호_입력_검증_실패_숫자_범위_미만")
    void 당첨_번호_입력_검증_실패_숫자_범위_미만() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 0);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new LottoData(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값의 범위는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨_번호_입력_검증_실패_보너스_번호_중복")
    void 당첨_번호_입력_검증_실패_보너스_번호_중복() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new LottoData(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값은 앞서 입력한 값들과 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("당첨_번호_입력_검증_실패_보너스_번호_범위_초과")
    void 당첨_번호_입력_검증_실패_보너스_번호_범위_초과() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;

        assertThatThrownBy(() -> new LottoData(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값의 범위는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨_번호_입력_검증_실패_보너스_번호_범위_미만")
    void 당첨_번호_입력_검증_실패_보너스_번호_범위_미만() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 0;

        assertThatThrownBy(() -> new LottoData(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값의 범위는 1부터 45 사이의 숫자여야 합니다.");
    }

}
