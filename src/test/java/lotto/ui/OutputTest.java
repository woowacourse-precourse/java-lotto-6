package lotto.ui;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest {

    @DisplayName("로또 번호를 오름차순으로 정렬하여 구매한 로또 전체 출력")
    @Test
    void printLottos(){
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));
        lottos.add(new Lotto(List.of(20,30,10,40,1,45)));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        List<Lotto> sortedLottos = LottoManager.sortLottos(lottos);
        Output.printLottos(sortedLottos);

        // then
        assertThat(out.toString())
                .contains("[1, 2, 3, 4, 5, 6]")
                .contains("[1, 10, 20, 30, 40, 45]");

        }
    }