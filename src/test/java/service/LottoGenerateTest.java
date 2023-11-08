package service;

import lotto.domain.Lotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoGeneratorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoGenerateTest {
    LottoGeneratorService lottoGeneratorService;
    @BeforeEach
    void getInstance() {
        lottoGeneratorService = LottoGeneratorServiceImpl.getInstance();
    }
    @Test
    @DisplayName("나의 로또 생성 테스트")
    void myLottos() {
        List<Lotto> lottos = lottoGeneratorService.myLottos("7000");
        assertEquals(lottos.size(), 7);
    }

    @Test
    @DisplayName("나의 로또 생성 실패 테스트 - 1000단위 실패")
    void myLottosFailWithUnitFirst() {
        assertThrows(IllegalArgumentException.class,
                () -> lottoGeneratorService.myLottos("7500"));
    }

    @Test
    @DisplayName("나의 로또 생성 실패 테스트 - 1000단위 실패")
    void myLottosFailWithUnitSecond() {
        assertThrows(IllegalArgumentException.class,
                () -> lottoGeneratorService.myLottos("0"));
    }

    @Test
    @DisplayName("나의 로또 생성 실패 테스트 - 숫자 이외의 값")
    void myLottosFail() {
        assertThrows(IllegalArgumentException.class,
                () -> lottoGeneratorService.myLottos("abc"));
    }
}
