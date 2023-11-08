package lotto.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoWinningTest extends NsTest {
    @DisplayName("LottoWinning은 문자열이 들어가면 에러처리한다.")
    @Test
    void createLottoWinningByNotNumber() {
        assertThatThrownBy(() -> new LottoWinning("2,32,33,12,43,w"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoWinning 매개변수가 6개가 아닌 경우")
    @Test
    void createLottoWinningByLengthIsNotSix() {
        assertThatThrownBy(() -> new LottoWinning("2,32,33,12,43"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoWinning 1~45 범위를 넘어서면 에러처리한다.")
    @Test
    void createLottoWinningByOutOfRange() {
        assertThatThrownBy(() -> new LottoWinning("2,32,33,12,43,67"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoWinning 중복되면 에러처리한다.")
    @Test
    void createLottoWinningByDuplicate() {
        assertThatThrownBy(() -> new LottoWinning("2,32,33,2,43,67"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus번호는 숫자가 아니면 에러처리한다.")
    @Test
    void setBonusNumberByString() {
        assertThatThrownBy(() -> {
            LottoWinning lottoWinning = new LottoWinning("2,32,33,1,43,67");
            lottoWinning.setBonusNumber("w");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus번호는 1~45 사이 숫자가 아니면 에러처리한다.")
    @Test
    void setBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> {
            LottoWinning lottoWinning = new LottoWinning("2,32,33,1,43,67");
            lottoWinning.setBonusNumber("89");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus번호는 LottoWinning이랑 중복되면 에러처리한다.")
    @Test
    void setBonusNumberByDuplicate() {
        assertThatThrownBy(() -> {
            LottoWinning lottoWinning = new LottoWinning("2,32,33,1,43,67");
            lottoWinning.setBonusNumber("33");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Winning Number 정상적으로 set 되는지 확인")
    @Test
    void createWinningNumber() {
        assertSimpleTest(() -> {
            LottoWinning lottoWinning = new LottoWinning("2,32,33,1,43,12");
            System.out.println(lottoWinning.getWinningNumber().toString());

            assertThat(output()).contains("[2, 32, 33, 1, 43, 12]");
        });
    }

    @DisplayName("Bonus Number 정상적으로 set 되는지 확인")
    @Test
    void createWinningNumberWithBonusNumber() {
        assertSimpleTest(() -> {
            LottoWinning lottoWinning = new LottoWinning("2,32,33,1,43,12");
            lottoWinning.setBonusNumber("3");
            System.out.println(lottoWinning.getWinningNumber().toString());
            System.out.println(lottoWinning.getBonusNumber());

            assertThat(output())
                    .contains("[2, 32, 33, 1, 43, 12]",
                            "3");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
