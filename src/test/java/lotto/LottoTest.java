package lotto;

import lotto.domain.LottoAmount;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    /*
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
    */
    // 아래에 추가 테스트 작성 가능
    @Test
    void 음수금액_test(){
        assertThrows(IllegalArgumentException.class, ()-> {
            LottoAmount lotto=new LottoAmount(-1000);
        });
    }

    @Test
    void 단위불일치_test(){
        assertThrows(IllegalArgumentException.class, ()-> {
            LottoAmount lotto=new LottoAmount(2100);
        });
    }

    @Test
    void 로또숫자생성기(){
        LottoNumbers lottoNumbers= new LottoNumbers();
        List<Integer> lottoTest= lottoNumbers.setLottoNumbers();
        assertEquals(lottoTest.size(), 6);

    }

}