package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @DisplayName("구매한 로또 전체를 출력한다.")
    @Test
    void printLottoNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    int purchaseAmount = 5000;
                    User user = new User(purchaseAmount);

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outputStream));

                    user.printLottoNumbers();

                    String captured = outputStream.toString().trim();

                    assertThat(captured).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 8, 9, 10, 11, 12]",
                            "[13, 14, 15, 16, 17, 18]",
                            "[19, 20, 21, 22, 23, 24]",
                            "[25, 26, 27, 28, 29, 30]"
                    );


                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18),
                List.of(19, 20, 21, 22, 23, 24),
                List.of(25, 26, 27, 28, 29, 30)
        );
    }

}
