package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoValidatorTest {
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"0",
            "2450",
            "3500"})
    void 로또_구매할_금액_테스트(String amount) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.amountInputValidator(amount)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"sf",
            "rpr2",
            "4000z"})
    void 로또_구매할_금액_숫자_테스트(String amount) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.amountInputValidator(amount)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5",
            "50,1,2,3,4,60",
            "10,2,3,4,5,46"})
    void 당첨_로또_번호_범위_테스트(String lotto) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.amountInputValidator(lotto)
        );
    }
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7",
            "10,2,4,5,6,7,8,9",
            "10"})
    void 당첨_로또_번호_갯수_테스트(String lotto) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.winningLottoValidator(lotto)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,f,5",
            "a,b,c,d,e,f",
            "a,1,2,f,4,b"})
    void 당첨_로또_번호_숫자_테스트(String amount) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.amountInputValidator(amount)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"0",
            "46",
            "110"})
    void 당첨_보너스_범위_테스트(String amount) {
        List<Integer> lotto = new ArrayList<>();

        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.inputWinningBonusValidator(lotto,amount)
        );
    }
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"a",
            "b",
            "c"})
    void 당첨_보너스_숫자_테스트(String bonus) {
        List<Integer> lotto = new ArrayList<>();
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.inputWinningBonusValidator(lotto, bonus)
        );
    }
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"1",
            "2",
            "3"})
    void 당첨_보너스_로또_중복_테스트(String bonus) {
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);

        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.inputWinningBonusValidator(lotto ,bonus)
        );
    }
}
