package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.exception.lotto.LottoOutOfRangeException;

import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.WinningLotto;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    private WinningLotto winningLotto;
    @BeforeEach
    void setUp(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        winningLotto = new WinningLotto(numbers);
    }
    @DisplayName("보너스 넘버가 1미만 또는 45 초과면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,46})
    void createBonusNumberOutOfRange(int input){
        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(LottoOutOfRangeException.class);
    }




}
