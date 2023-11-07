package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    int lottoQuantity = 5;
    List<Lotto> lottos = new ArrayList<>(lottoQuantity);

    @DisplayName("로또 배열의 사이즈가 로또 개수보다 작을 때 예외 처리")
    @Test
    void createUnderLottoSize() {
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(7,18,19,26,33,45)));
        lottos.add(new Lotto(List.of(6,20,23,24,28,30)));
        lottos.add(new Lotto(List.of(12,19,21,29,40,45)));
        assertThatThrownBy(() -> new User(lottos, lottoQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력된 로또 리스트의 사이즈와 로또 개수가 일치하지 않습니다.\n");
    }

    @DisplayName("로또 배열의 사이즈가 로또 개수보다 클 때 예외 처리")
    @Test
    void createOverLottoSize() {
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(7,18,19,26,33,45)));
        lottos.add(new Lotto(List.of(6,20,23,24,28,30)));
        lottos.add(new Lotto(List.of(12,19,21,29,40,45)));
        lottos.add(new Lotto(List.of(4,18,31,37,42,43)));
        lottos.add(new Lotto(List.of(8,14,25,36,42,45)));
        assertThatThrownBy(() -> new User(lottos, lottoQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력된 로또 리스트의 사이즈와 로또 개수가 일치하지 않습니다.\n");
    }

    @DisplayName("로또 당첨 결과를 정확히 도출하는 지 테스트")
    @Test
    void testResultCount() {
        lottos.add(new Lotto(List.of(1,7,15,18,23,45)));  //5등
        lottos.add(new Lotto(List.of(7,18,19,28,33,45)));  //2등
        lottos.add(new Lotto(List.of(6,20,23,24,28,30)));  //미당첨
        lottos.add(new Lotto(List.of(12,19,23,28,40,45)));  //5등
        lottos.add(new Lotto(List.of(4,18,19,23,33,43)));  //4등
        User user = new User(lottos, lottoQuantity);
        assertThat(user.countTotalResult(List.of(7,18,19,23,28,33), 45))
                .isEqualTo(List.of(1,2,1,0,1,0));
    }

    @DisplayName("수익률을 정확히 도출하는 지 테스트")
    @Test
    void testcalculateProfitRate() {
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(7,18,19,26,33,45)));
        lottos.add(new Lotto(List.of(6,20,23,24,28,30)));
        lottos.add(new Lotto(List.of(12,19,21,29,40,45)));
        lottos.add(new Lotto(List.of(4,18,31,37,42,43)));
        User user = new User(lottos, lottoQuantity);
        assertThat(user.calculateProfitRate(List.of(4,1,0,0,0,0)))    //미당첨 4개, 5개 1명 총 5000원
                .isEqualTo(100.0);
    }
}
