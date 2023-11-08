package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

class LottoMarketServiceTest {
    LottoMarketService lottoMarketService;
    @Mock
    LottoNumSupplier lottoNumSupplier;
    @BeforeEach
    void setUp(){
        lottoMarketService = new LottoMarketService();
    }

    @Test
    void issueLottoes() {
        List<Lotto> lottoes = lottoMarketService.issueLottoes(10);
        Assertions.assertThat(lottoes.size()).isEqualTo(10);
    }

    @Test
    void generateNonDuplicatedNums() {
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                .thenReturn(List.of(1,2,3,4,5,6));
        List<Integer> lottoNums = lottoMarketService.generateNonDuplicatedNums();
        Assertions.assertThat(lottoNums.size()).isEqualTo(6);
        mock.close();
    }

    @Test
    void calculateLottoCount_정상_실행() {
        int lottoCount = lottoMarketService.calculateLottoCount(16000);
        Assertions.assertThat(lottoCount).isEqualTo(16);
    }
}