package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("유저 구매 로또 생성 테스트 - 정상 데이터 - 성공")
    @Test
    void createUserLottosTest() {
        int testAmount = 3;
        Lottos testLottos =  lottoService.createUserLottos(testAmount);
        assertThat(testLottos.getLottos().size()).isEqualTo(3);
    }

    @DisplayName("당첨 로또 생성 테스트 - 정상 데이터 - 성공")
    @Test
    void createAnswerLottosTest() {
        List<Integer> testLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto testLotto =  lottoService.createAnswerLotto(testLottoNumbers);
        assertThat(testLotto.getNumbers()).isEqualTo(testLottoNumbers);
    }

    @DisplayName("Integer 리스트 오름차순 정렬 테스트 - 성공")
    @Test
    void orderNumbersByAsc() {
        List<Integer> testList = Arrays.asList(3, 2, 1, 4, 6, 5);
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lottoService.sortNumbersByAsc(testList)).isEqualTo(expectedResult);
    }
}
