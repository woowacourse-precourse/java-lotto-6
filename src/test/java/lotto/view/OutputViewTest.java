package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private List<Lotto> lottos;


    @BeforeEach
    void init() {
        System.setOut(new PrintStream(byteArrayOutputStream));
        lottos = List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(7,8,9,10,11,12)));
    }

    @AfterEach
    void afterInit() {
        Console.close();
        System.setOut(System.out);
        byteArrayOutputStream.reset();
    }


    @Test
    @DisplayName("구매갯수 출력 확인")
    void 구매갯수_출력_확인() {
        OutputView.showPurchasedLottos(lottos);
        String expectedOutput = "2개를 구매했습니다.\n" + "[1, 2, 3, 4, 5, 6]\n" + "[7, 8, 9, 10, 11, 12]\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }
}