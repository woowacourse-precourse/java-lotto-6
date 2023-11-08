package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp(){
        lottoResult = new LottoResult();
    }

    @Test
    void 당첨횟수_추가_테스트(){
        lottoResult.incrementCount(1);
        lottoResult.incrementCount(1);

        assertEquals(2,lottoResult.getCount(1));
        assertEquals(0,lottoResult.getCount(5));
    }

    @Test
    void 당첨횟수_추가_범위_밖_순위_입력_테스트(){
        lottoResult.incrementCount(0);
        lottoResult.incrementCount(6);

        assertEquals(0,lottoResult.getCount(0));
        assertEquals(0,lottoResult.getCount(6));
    }

}
