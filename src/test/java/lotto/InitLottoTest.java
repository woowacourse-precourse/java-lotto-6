package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitLottoTest {

    private LottoService lottoService = new LottoService();
    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
    @Test
    void 로또_번호_오름차순_테스트(){
        List<Integer> testNumber = Arrays.asList(10,20,1,2,4,5);
        List<Integer> expectedResult = Arrays.asList(1,2,4,5,10,20);
        Lotto lotto = new Lotto(testNumber);
        assertEquals(expectedResult, lotto.getNumbers());
    }

    @DisplayName("로또 번호가 랜덤으로 6개 저장된다.")
    @Test
    void 로또_번호_랜덤_테스트(){
        List<Integer> testNumber = lottoService.initLottoNumber();
        int expectedResult = 6;
        assertEquals(expectedResult, testNumber.size());
    }
}
