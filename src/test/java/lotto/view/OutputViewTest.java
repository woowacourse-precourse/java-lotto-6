package lotto.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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


    @DisplayName("구매한 로또를 출력한다.")
    @Test
    void printLotto() {
        //given
        OutputView outputView = new OutputView();

        int quantity = 2;
        List<List<Integer>> lottos = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );

        //when
        outputView.printLotto(quantity, lottos);

        //then
        Assertions.assertThat(output.toString())
                .contains("2개를 구매했습니다.")
                .contains("[8, 21, 23, 41, 42, 43]"
                        , "[3, 5, 11, 16, 32, 38]");
    }

    @DisplayName("당첨통계를 출력한다.")
    @Test
    void printStatistics(){
        //given
        OutputView outputView = new OutputView();

        List<Integer> statistics = new ArrayList<>();
        statistics.addAll(List.of(0, 0, 0, 1, 2, 3, 0, 0));

        //when
        outputView.printStatistics(statistics);

        //then
        Assertions.assertThat(output.toString())
                .containsAnyOf("3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 2개",
                        "5개 일치 (1,500,000원) - 3개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 0개");
    }

}