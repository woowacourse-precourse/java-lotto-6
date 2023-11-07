package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTarget;
import lotto.model.ResultStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTargetTest {

    @DisplayName("grading 함수 로직 체크")
    @Test
    void checkResultByLottoTargetAndLotto() {
        Lotto myLotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto myLotto_2 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto myLotto_3 = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        Lotto myLotto_4 = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Lotto myLotto_5 = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        Lotto myLotto_6 = new Lotto(List.of(30, 31, 32, 33, 34, 35));

        LottoTarget lottoTarget = new LottoTarget(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , 10);

        ResultStatus grading_1 = lottoTarget.grading(myLotto_1);
        assertThat(grading_1).isEqualTo(ResultStatus.SIX);

        ResultStatus grading_2 = lottoTarget.grading(myLotto_2);
        assertThat(grading_2).isEqualTo(ResultStatus.BONUS);

        ResultStatus grading_3 = lottoTarget.grading(myLotto_3);
        assertThat(grading_3).isEqualTo(ResultStatus.FIVE);

        ResultStatus grading_4 = lottoTarget.grading(myLotto_4);
        assertThat(grading_4).isEqualTo(ResultStatus.FOUR);

        ResultStatus grading_5 = lottoTarget.grading(myLotto_5);
        assertThat(grading_5).isEqualTo(ResultStatus.THREE);

        ResultStatus grading_6 = lottoTarget.grading(myLotto_6);
        assertThat(grading_6).isEqualTo(ResultStatus.NONE);
    }

}