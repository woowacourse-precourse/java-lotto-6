package lotto;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {
    private static List<Integer> lottoNumberList;

    @Test
    void 로또_랜덤숫자_생성() {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumberList = lottoNumber.setRandomNumbers();

        assertThat(lottoNumberList.size()).isEqualTo(6);
    }
}
