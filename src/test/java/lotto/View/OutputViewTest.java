package lotto.View;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.View.OutputView.printLottoList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.Lotto;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

//    @Test
//    void printLottoListTest(){
//        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
//        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
//        List<Lotto> lottoList = new ArrayList<>();
//        lottoList.add(lotto1);
//        lottoList.add(lotto2);
//
//        assertSimpleTest(
//                () -> {
//                    assertThat(printLottoList(2,lottoList))
//                            .contains(
//                                    "[1, 2, 3, 4, 5, 6]",
//                                    "[1, 2, 3, 4, 5, 6]");
//                }
//        );
//    }

    @Test
    void printLottoListTest(){
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 8, 4, 10, 6));
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto1);
        lottoList.add(lotto2);
        printLottoList(2,lottoList);
    }
}
