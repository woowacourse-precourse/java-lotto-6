package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final InputValidator inputValidator = new InputValidator();

    @BeforeEach()
    void setEach() {
        System.setOut(new PrintStream(out));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000000"})
    void 음수인_금액_입력_테스트(String negativeNumber) {

        assertThatThrownBy(() -> inputValidator.amountValidator(negativeNumber)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1100", "500", "12005"})
    void 천원_단위가_아닌_금액_입력_테스트(String notNumber) {

        assertThatThrownBy(() -> inputValidator.amountValidator(notNumber)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"notNumber", "<>", "-="})
    void 숫자가_아닌_금액_입력_테스트(String notNumber) {

        assertThatThrownBy(() -> inputValidator.amountValidator(notNumber)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "10,9,45,1,45"})
    void 중복된_로또_번호_입력_테스트(String overlapNumber) {

        assertThatThrownBy(() -> inputValidator.lottoValidator(overlapNumber)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"100,2,3,4,5,6", "10,9,45,1,0"})
    void 범위를_벗어난_로또_번호_입력_테스트(String overRangeNumber) {

        assertThatThrownBy(() -> inputValidator.lottoValidator(overRangeNumber)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"notNumber,2,3,4,5,6", "10,9,45,1,-=", "1,2,3,,4,5"})
    void 숫자가_아닌_로또_번호_입력_테스트(String notNumber) {

        assertThatThrownBy(() -> inputValidator.lottoValidator(notNumber)).isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"notNumber", "-=", ""})
    void 숫자가_아닌_보너스_번호_입력_테스트(String notNumber) {

        List<Integer> lottoNumbers = List.of(5, 10, 15, 20, 25, 30);

        assertThatThrownBy(() -> inputValidator.bonusValidator(lottoNumbers, notNumber)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "0"})
    void 범위를_벗어난_보너스_번호_입력_테스트(String notNumber) {

        List<Integer> lottoNumbers = List.of(5, 10, 15, 20, 25, 30);

        assertThatThrownBy(() -> inputValidator.bonusValidator(lottoNumbers, notNumber)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"10", "30"})
    void 중복된_보너스_번호_입력_테스트(String notNumber) {

        List<Integer> lottoNumbers = List.of(5, 10, 15, 20, 25, 30);

        assertThatThrownBy(() -> inputValidator.bonusValidator(lottoNumbers, notNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }
}