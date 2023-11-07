package lotto.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import lotto.rule.UserRule;
import lotto.model.Lotto;
import lotto.model.LottoCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCreatorTest {

    @Test
    void LottoMaker는_입력없이_랜덤로또를_생성한다() {
        Lotto autoLotto = LottoCreator.createRandomLotto();

        assertThat(autoLotto).isInstanceOf(Lotto.class);
    }

    @Test
    void LottoMaker가_생성한_당첨로또에는_입력된_숫자들이_들어있다() {
        String inputWinningNumbers = "1,2,3,4,5,6";
        List<Integer> numbers = Arrays.stream(inputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.getValue()))
                .map(Integer::parseInt)
                .toList();

        Lotto manualLotto = LottoCreator.createWinningLotto(numbers);

        assertThat(manualLotto.showNumbers()).contains("1","2","3","4","5","6");
    }

    @ValueSource(strings = {"1,", "1,2,3,4,5,6,7"})
    @ParameterizedTest
    void 당첨로또의_숫자_개수가_6개가_아니면_예외를_발생시킨다(String inputWinningNumbers) {
        List<Integer> numbers = Arrays.stream(inputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.getValue()))
                .map(Integer::parseInt)
                .toList();

        assertThatThrownBy(() -> LottoCreator.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨로또에_중복된_숫자가_있으면_예외를_발생시킨다() {
        String inputWinningNumbers = "1,1,2,3,4,5";
        List<Integer> numbers = Arrays.stream(inputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.getValue()))
                .map(Integer::parseInt)
                .toList();

        assertThatThrownBy(() -> LottoCreator.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}