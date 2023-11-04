package lotto.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp(){
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

//    @DisplayName("로또를 몇개 구매 했는지 출력한다.")
//    @Test
//    void printPurchaseMessage(){
//        //given
//        OutputView outputView = new OutputView();
//        int quantity = 8;
//
//        //when
//        outputView.printPurchaseMessage(quantity);
//
//        //then
//        Assertions.assertThat(output.toString()).contains("8개를 구매했습니다.");
//    }

//    @DisplayName("구매한 로또를 출력한다.")
//    @Test
//    void printLotto() {
//        //given
//        OutputView outputView = new OutputView();
//
//        List<List<Integer>> lottos = List.of(
//                List.of(8, 21, 23, 41, 42, 43),
//                List.of(3, 5, 11, 16, 32, 38)
//        );
//
//        //when
//        outputView.printLotto(lottos);
//
//        //then
//        Assertions.assertThat(output.toString())
//                .contains("[8, 21, 23, 41, 42, 43]"
//                        , "[3, 5, 11, 16, 32, 38]");
//    }

}