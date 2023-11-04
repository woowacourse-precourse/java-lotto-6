package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        LottoNumSupplier lottoNumSupplier = mock(LottoNumSupplier.class);
        when(lottoNumSupplier.get()).thenReturn(1,1,2,3,4,4,5,6,6);
        List<Integer> lottoNums = lottoMarketService.generateNonDuplicatedNums(lottoNumSupplier);
        Assertions.assertThat(lottoNums.size()).isEqualTo(6);
    }

    @Test
    void calculateLottoCount_정상_실행() {
        int lottoCount = lottoMarketService.calculateLottoCount(16000);
        Assertions.assertThat(lottoCount).isEqualTo(16);
    }
    @Test
    void calculateLottoCount_예외_상황(){
        Assertions.assertThatThrownBy(()->{
            lottoMarketService.calculateLottoCount(15500);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INCORRECT_AMOUNT.getErrorMessage());
    }
}