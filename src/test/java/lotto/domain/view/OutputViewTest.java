package lotto.domain.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("생성한 로또들을 포맷에 맞추어 출력합니다.")
    public void 로또들_출력() {
        // GIVEN
        Integer cash = 2000;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        User userObj = new User(lottos, cash);
        String lottosStatus = userObj.toString();

        // WHEN
        OutputView.printLottos(lottosStatus);

        // THEN
        assertEquals("[8, 21, 23, 41, 42, 43]\n"
                + "[3, 5, 11, 16, 32, 38]", outputStreamCaptor.toString()
                .trim());
    }
}