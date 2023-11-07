package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    Lotto actualLotto1;
    Lotto actualLotto2;
    List<Lotto> actualLottoGroup;
    Lottos actualLottos;

    @BeforeEach
    void beforeEach() {
        actualLotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        actualLotto2 = new Lotto(Arrays.asList(2, 5, 1, 7, 8, 9));
        actualLottoGroup = Arrays.asList(actualLotto1, actualLotto2);
        actualLottos = new Lottos(actualLottoGroup);

    }

    @Test
    @DisplayName("lottos 에 로또를 집어 넣은 순서를 보장해야 한다.")
    void Lottos_는_순서를_보장한다() {
        // 디미터 법칙을 어기지만, 실제 매소드에서 lottos.get()을 쓰지 않음.
        // 또한 lottos 는 record 성질 (불변) 과 List.copyOf로 get을 호출하더라도 내부 소스를 변경하지 못한다.
        assertThat(actualLottos.lottoGroup().get(0).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(actualLottos.lottoGroup().get(1).toString()).isEqualTo("[1, 2, 5, 7, 8, 9]");
    }

    @Test
    @DisplayName("lottos 는 불변하고, 다른 Lottos 와 내부 값(로또 번호들)이 같으면 동등하다")
    void lottos_동등성_비교() {
        Lotto tempactualLotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto tempactualLotto2 = new Lotto(Arrays.asList(2, 5, 1, 7, 8, 9));

        List<Lotto> tempactualLottoGroup = Arrays.asList(tempactualLotto1, tempactualLotto2);
        Lottos tempLottos = new Lottos(tempactualLottoGroup);

        assertThat(tempLottos).isEqualTo(actualLottos);
    }

    @Test
    @DisplayName("lottos 는 불변하고, 다른 Lottos 와 내부 값(로또 번호들)이 같아도 동일하지 않다.")
    void lottos_동일성_비교() {
        Lotto newLotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto newLotto2 = new Lotto(Arrays.asList(1, 2, 5, 7, 8, 9));

        List<Lotto> tempactualLottoGroup = Arrays.asList(newLotto1, newLotto2);
        Lottos tempLottos = new Lottos(tempactualLottoGroup);

        assertThat(tempLottos).isNotSameAs(actualLottos);
    }

    @Test
    void getSize() {
        assertThat(actualLottos.getSize()).isEqualTo(2);
    }
}