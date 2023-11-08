package lotto.View.InputConvertor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputConvertorTest {

    InputConvertor convertor = new InputConvertor();

    @Test
    @DisplayName("당첨 번호 문자열 입력 리스트 변환 테스트")
    public void 당첨_번호_문자열_입력_리스트_변환_테스트() {
        List<Integer> result = convertor.convertWinningNum("1,2,3,4,5,6");
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 당첨 번호 문자열 입력 Integer 변환 테스트")
    public void 당첨_번호_문자열_입력_변환_테스트() {
        Integer result = convertor.convertBonusWinningNum("1");
        Integer expected = 1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 구입 금액 문자열 입력 Integer 입력 변환 테스트")
    public void 로또_구입_금액_문자열_입력_변환_테스트() {
        Integer result = convertor.convertLotteryBudget("12000");
        Integer expected = 12000;
        assertThat(result).isEqualTo(expected);
    }
}
