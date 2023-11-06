package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class DrawTest extends Draw{

    @Test
    void 문자열_분리_테스트() {

        //given
        String input = "1,2,3";

        //when
        String[] result = input.split(",");

        //then
        Assertions.assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 입력값이_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> isInt("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 숫자여야 합니다.");
    }

    @Test
    void 입력값이_숫자면_예외_발생_X() {
        assertThatNoException()
                .isThrownBy(() -> isInt("45"));
    }

    @Test
    void 숫자문자열을_int타입으로_변환() {

        //given
        String num = "45";

        //when
        int result = toInt(num);

        //then
        assertThat(result).isEqualTo(45);
    }

    @Test
    void 문자열배열을_Integer리스트로_변환() {

        //given
        String[] strings = {"1", "3", "15", "11", "33", "42"};

        //when
        List<Integer> result = toIntList(strings);

        //then
        assertThat(result).isInstanceOf(List.class);
        assertThat(result).contains(1, 3, 15, 11, 33, 42);
    }

    @Test
    void 로또_자동_발행_테스트() {

        //given
        int lottoNum = 14;

        //when
        List<Lotto> lottos = issueLottos(lottoNum);

        //then
        assertThat(lottos.size()).isEqualTo(14);
    }
}
