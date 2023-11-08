package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private Lotto lotto;
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp(){
        lottoNumbers = Arrays.asList(10,3,45,33,26,9);
        lotto = new Lotto(lottoNumbers);
    }

    @Test
    void 로또_번호정렬_테스트(){
        List<Integer> sortedNumbers = Arrays.asList(3,9,10,26,33,45);
        assertEquals(sortedNumbers,lotto.sortNumbers());
    }

    @Test
    void 범위_밖_개수_입력_예외_확인() {
        List<Integer> invalidLengthLotto = Arrays.asList(1,2,3,4,5);
        assertThatThrownBy(() -> new Lotto(invalidLengthLotto))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
