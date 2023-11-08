package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
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

    @DisplayName("빈 칸이 입력으로 들어왔을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void 입력값_빈칸인_경우(String input) {
        assertThatThrownBy(() -> Validator.checkNullValue(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 형식에 올바르지 않게 들어왔을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,false,4,5"})
    void 보너스번호_입력형태_잘못된_경우(String input) {
        assertThatThrownBy(() -> Validator.checkBonusNumberForm(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또 번호 6개가 일치하는데 보너스번호가 일치하지 않으면 1등에 해당한다.")
    @Test
    void 보너스번호_미포함_6개_일치하면_1등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.FIRST));
    }

    @DisplayName("로또 번호 6개가 일치하는데 보너스 일치하면 2등에 해당한다.")
    @Test
    void 보너스번호_포함_6개_일치하면_2등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNum = 6;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.SECOND));
    }

    @DisplayName("보너스번호 포함하여 로또 번호 5개가 일치하는데 2등에 해당한다.")
    @Test
    void 보너스번호_포함_5개_일치하면_3등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 45, 44);
        int bonusNum = 5;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.THIRD));
    }

    @DisplayName("보너스번호 미포함하여 로또 번호 5개가 일치하는데 2등에 해당한다.")
    @Test
    void 보너스번호_미포함_5개_일치하면_3등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNum = 44;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.THIRD));
    }

    @DisplayName("보너스번호 미포함하여 로또 번호 4개가 일치하는데 2등에 해당한다.")
    @Test
    void 보너스번호_미포함_4개_일치하면_4등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 45, 44);
        int bonusNum = 43;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.FOURTH));
    }

    @DisplayName("보너스번호 미포함하여 로또 번호 4개가 일치하는데 2등에 해당한다.")
    @Test
    void 보너스번호_포함_4개_일치하면_4등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 45, 44, 43);
        int bonusNum = 4;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.FOURTH));
    }

}