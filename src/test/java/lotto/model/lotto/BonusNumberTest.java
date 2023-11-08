package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.exception.lotto.LottoDuplicateException;
import lotto.exception.lotto.LottoOutOfRangeException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    private WinningLotto winningLotto;
    @BeforeEach
    void setUp(){
        //given
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        winningLotto = new WinningLotto(numbers);
    }
    @DisplayName("보너스 넘버가 1미만 또는 45 초과면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,46})
    void createBonusNumberOutOfRange(int input){
        // when & then
        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(LottoOutOfRangeException.class);
    }

    @DisplayName("보너스 넘버가 당첨로또와 중복일 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void createBonusNumberDuplicateWithWinningNumbers(int input){
        // when & then
        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(LottoDuplicateException.class);
    }




}
