package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GroupLottoTest {

    @DisplayName("여러개 로또 생성")
    @Test
    void 로또생성() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(7,8,9,10,11,12))
        );
        GroupLotto groupLotto = new GroupLotto(lottos);
        List<Lotto> multiLottos = groupLotto.getLottos();
        //lottos의 객체와 grouplotto의 객체가 동일한것을 확인함
        assertThat(multiLottos.size()).isEqualTo(2);
        assertThat(multiLottos).isEqualTo(lottos);
    }
}