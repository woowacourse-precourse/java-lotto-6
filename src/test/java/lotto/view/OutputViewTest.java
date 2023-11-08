package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
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

    @DisplayName("내가 구매한 로또를 출력한다.")
    @Test
    void printLotto(){
        //given
        OutputView outputView = new OutputView();
        int quantity = 1;
        List<List<Integer>> myLottos = new ArrayList<>();
        myLottos.add(List.of(1,3,2,5,4,6));

        //when
        outputView.printLotto(1, myLottos);

        //then
        assertThat(output.toString())
                .containsAnyOf("1개를 구매했습니다.",
                        "[1, 2, 3, 4, 5, 6]");
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
        assertThat(output.toString())
                .containsAnyOf("3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 2개",
                        "5개 일치 (1,500,000원) - 3개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 0개");
    }

    @DisplayName("수익률을 소수점 둘째 자리에서 반올림하여 출력한다.")
    @Test
    void printProfitability(){
        //given
        OutputView outputView = new OutputView();
        double profitability = 13.13;

        //when
        outputView.printProfitability(profitability);

        //then
        assertThat(output.toString())
                .contains("총 수익률은 13.1%입니다.");
    }

}