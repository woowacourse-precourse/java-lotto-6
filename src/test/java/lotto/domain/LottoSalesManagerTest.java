package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSalesManagerTest {

    @DisplayName("정상적인 로또를 생성하는지 확인합니다.")
    @Test
    void makeLottosTest() {
        //개수 테스트
        Assertions.assertThat(new LottoSalesManager("6000").makeLottos().size()).isEqualTo(6);
    }
}