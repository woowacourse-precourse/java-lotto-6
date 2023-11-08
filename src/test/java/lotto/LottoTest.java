package lotto;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoService;
import lotto.validator.ValidateBonusNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("생성한 로또가 오름차순으로 정렬 되는지 확인.")
    @Test
    void validateAscending(){
        Lotto lotto=new Lotto(List.of(6,5,4,3,2,1));
        List<Integer> sortedLotto = lotto.getLotto();
        for(int i=0;i<sortedLotto.size()-1;i++){
            assertTrue(sortedLotto.get(i)<=sortedLotto.get(i+1));
        }
    }

    @DisplayName("입력한 구매금액만큼 로또가 반환되는지 확인.")
    @Test
    void exchangeLottoTicket(){
        LottoService service=new LottoService();
        Lottos lottos = service.exchangeLottoTicket(3000);
        assertThat(lottos.getLottos().size()).isEqualTo(3);
    }

}