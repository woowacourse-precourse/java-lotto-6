package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.MockNumberGenerator;
import lotto.domain.LottoMachine;
import lotto.domain.user.LottoCount;
import lotto.domain.user.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest extends NsTest {
    @DisplayName("userLotto정보를 올바르게 출력하는지 확인한다.")
    @Test
    void checkUserLottoOutput() {
        //given
        LottoCount lottoCount = new LottoCount(2000);
        UserLotto userLotto = new UserLotto(lottoCount);
        MockNumberGenerator mockNumberGenerator = new MockNumberGenerator();
        userLotto.create(mockNumberGenerator);
        Output output = new Output();

        //when
        output.userLotto(userLotto);

        //then
        assertThat(output()).contains("2개를 구매했습니다.", "[1, 3, 5, 7, 9, 11]");
    }

    @DisplayName("당첨정보를 올바르게 출력하는지 확인한다.")
    @Test
    void checkLottoResultOutput() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        Output output = new Output();
        //when
        output.lottoResult(lottoMachine);

        //then
        assertThat(output()).contains("0개", "3개 일치 (5,000원) - ",
                "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "6개 일치 (2,000,000,000원) - ");
    }

    @DisplayName("수익률을 올바르게 출력하는지 확인한다.")
    @Test
    void checkRateOfReturnOutput() {
        //given
        Output output = new Output();
        //when
        output.rateOfReturn(67.51);
        //then
        assertThat(output()).isEqualTo("총 수익률은 67.5%입니다.");
    }

    @Override
    protected void runMain() {

    }
}
