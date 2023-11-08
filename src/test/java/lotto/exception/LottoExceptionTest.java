package lotto.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoExceptionTest {

    private final LottoException lottoException = new LottoException();

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 로또_구입_금액_입력_성공() {
        // given
        String line = "10000";

        // when
        boolean checked = lottoException.checkLottoAmount(line);

        // then
        assertThat(checked).isFalse();
    }

    @Test
    void 로또_구입_금액_입력_실패_1000으로_나누어_떨어지지_않을때() {
        // given
        String line = "10500";
        String expectedPrintNot1000Division = "[ERROR] 1000으로 나누어 떨어지지 않는 숫자를 입력 받았습니다. 다시 입력 해 주세요\n";

        // when
        boolean checked = lottoException.checkLottoAmount(line);

        // then
        assertThat(checked).isTrue();
        assertThat(output.toString()).isEqualTo(expectedPrintNot1000Division);
    }

    @Test
    void 당첨_번호_입력_성공() {
        // given
        String line = "1,2,3,4,5,6";

        // when
        boolean checked = lottoException.checkWinningNum(line);

        // then
        assertThat(checked).isFalse();
    }

    @Test
    void 당첨_번호_입력_실패_숫자가_6개가_아닐때() {
        // given
        String line = "1,2,3,4,5,6,7";
        String expectedPrintNot6Num = "[ERROR] 6개가 아닌 숫자를 입력 받았습니다. 다시 입력 해 주세요\n";

        // when
        boolean checked = lottoException.checkWinningNum(line);

        // then
        assertThat(checked).isTrue();
        assertThat(output.toString()).isEqualTo(expectedPrintNot6Num);
    }

    @Test
    void 당첨_번호_입력_실패_1에서_45사이의_숫자가_아닐때() {
        // given
        String line = "1,2,3,4,5,66";
        String expectedPrintNot1To45 = "[ERROR] 1~45 사이의 숫자가 아닌 수를 입력 받았습니다. 다시 입력 해 주세요\n";

        // when
        boolean checked = lottoException.checkWinningNum(line);

        // then
        assertThat(checked).isTrue();
        assertThat(output.toString()).isEqualTo(expectedPrintNot1To45);
    }

    @Test
    void 당첨_번호_입력_실패_중복_숫자를_입력_받을때() {
        // given
        String line = "1,2,3,4,5,5";
        String expectedPrintDuplicatedNum = "[ERROR] 중복된 숫자를 입력 받았습니다. 다시 입력 해 주세요\n";

        // when
        boolean checked = lottoException.checkWinningNum(line);

        // then
        assertThat(checked).isTrue();
        assertThat(output.toString()).isEqualTo(expectedPrintDuplicatedNum);
    }

    @Test
    void 보너스_번호_입력_성공() {
        // given
        String line = "7";
        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        boolean checked = lottoException.checkBonusNum(line, winningNum);

        // then
        assertThat(checked).isFalse();
    }

    @Test
    void 보너스_번호_입력_실패_당첨_번호와_중복된_수_입력_받을때() {
        // given
        String line = "1";
        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        String expectedPrintDuplicatedWinningNum = "[ERROR] 기존 당첨 번호와 중복된 숫자를 입력 받았습니다. 다시 입력 해 주세요.\n";

        // when
        boolean checked = lottoException.checkBonusNum(line, winningNum);

        // then
        assertThat(checked).isTrue();
        assertThat(output.toString()).isEqualTo(expectedPrintDuplicatedWinningNum);
    }
}