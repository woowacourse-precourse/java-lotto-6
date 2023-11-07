package lotto;

import lotto.domain.GenerateLottoNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseCost;
import lotto.util.GenerateLottoNumberUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 범위가 1~45범위를 벗어나면 예외가 발생한다")
    @Test
    void test1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 420)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또번호의 개수와 구입개수가 같은가")
    @Test
    void test2(){
        GenerateLottoNumberUtil generateLottoNumberUtil = new GenerateLottoNumberUtil();
        PurchaseCost purchaseCost = new PurchaseCost("1000");
        generateLottoNumberUtil.generateLottoNumber();

        Assertions.assertEquals(purchaseCost.getPurchaseCost(), generateLottoNumberUtil.getLottos().size());
    }




}