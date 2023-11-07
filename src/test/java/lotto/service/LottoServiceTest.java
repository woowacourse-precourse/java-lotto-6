package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.repository.BuyLottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService = new LottoService();
    BuyLottoRepository buyLottos;

    @DisplayName("구매한 갯수만큼 복권번호를 자동생성해줍니다.")
    @Test
    void quickPick() {
        // given
        int purchaseCount = 5;
        // when
        buyLottos = lottoService.quickPick(purchaseCount);
        // then
        assertThat(buyLottos.size()).isEqualTo(5);
    }
    @DisplayName("복권을 사면 1~45사이에 6자리의 번호를 받습니다.")
    @Test
    void createRandomNumbers() {
        int cnt =10000000;

        //천만번 반복하여 확인합니다
        while(cnt >=0){
            // given // when
            List<Integer> randomNumbers = lottoService.createRandomNumbers();

            // then
            // 1~45사이인지 확인
            for (Integer randomNumber : randomNumbers) {
                assertThat(randomNumber).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
            }

            // 6자리 인지 확인
            assertThat(randomNumbers.size()).isEqualTo(6);
            cnt--;
        }
    }
}