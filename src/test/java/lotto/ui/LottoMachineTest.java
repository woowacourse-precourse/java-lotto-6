package lotto.ui;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.LottoMachine;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또_생성_갯수_테스트() {
        lottoMachine.insertMoney("3000");
        lottoMachine.generateLottos();
        assertThat(lottoMachine.getLottos().size()).isEqualTo(3);
    }

    @Test
    void 로또_생성_갯수_테스트_돈이_없는_상태() {
        assertThrows(IllegalStateException.class, () -> lottoMachine.generateLottos());
    }

    @Nested
    class 사용자_구입_금액_테스트 {
        @Test
        void 영어_입력인_경우() {
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney("abc"));
        }

        @Test
        void 한글_입력인_경우() {
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney("오천원어치요"));
        }

        @Test
        void 특수문자_입력인_경우() {
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney("!@#$"));
        }

        @Test
        void 빈값_입력() {
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney(""));
        }

        @Test
        void 글자와_숫자가_혼합_입력() {
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney("abc1000"));
        }

        @Test
        void INT_범위_외_입력() {
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney("2147483648"));
        }

        @Test
        void 단위가_다른_돈_입력() {
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney("6001"));
        }

        @Test
        void ZERO_값_입력() {
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney("0"));
        }

        @Test
        void 정상적인_돈_입력() {
            lottoMachine.insertMoney("1000");
            assertThat(lottoMachine.getInputAmount()).isEqualTo(1000);
        }
    }

}
