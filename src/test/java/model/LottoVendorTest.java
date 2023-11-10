package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoVendorTest {

    @DisplayName("로또 구입 금액이 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoVendorByInvalidPurchaseAmount() {
        assertThatThrownBy(() -> new LottoVendor("23"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 하나 생성 테스트")
    @Test
    void createOneLottoByLottoVendor(){
        assertThat(new LottoVendor("1000").generateRandomLotto().getClass())
                .isEqualTo(Lotto.class);
    }

    @DisplayName("로또 여러개 생성 테스트")
    @Test
    void createManyLottoByLottoVendor(){
        assertThat(new LottoVendor("4000").createLottos(4).size())
                .isEqualTo(4);
    }

    @DisplayName("로또 저장소에 로또 발행 테스트")
    @Test
    void createLottoRepositoryByLottoVendor(){
        assertThat(new LottoVendor("40000").publishLotto("40000").getClass())
                .isEqualTo(LottoRepository.class);
    }
    @DisplayName("올바른 로또 개수만큼 로또가 발행 되었는지 테스트")
    @Test
    void createLottoRepositoryByValidLottoAmount(){
        assertThat(new LottoVendor("40000").publishLotto("40000").getSize())
                .isEqualTo(40);
    }
}
