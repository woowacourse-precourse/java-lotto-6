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

    @DisplayName("구매한 로또 당첨 통계를 출력한다.")
    @Test
    void printWinningStatistics() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    int purchaseAmount = 5000;
                    User user = new User(purchaseAmount);

                    List<Integer> numbers = createLottoNumbers();
                    int bonusNumber = 8;

                    LottoResult result = new LottoResult(numbers, bonusNumber);
                    user.matchLottoNumbers(result);

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outputStream));

                    user.printWinningStatistics();

                    String captured = outputStream.toString().trim();

                    assertThat(captured).contains(
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );


                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 2, 3, 4, 5, 11)
        );
    }

    @DisplayName("당첨된 금액의 수익률을 출력한다.")
    @Test
    void printProfitRate() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    int purchaseAmount = 5000;
                    User user = new User(purchaseAmount);

                    List<Integer> numbers = createLottoNumbers();
                    int bonusNumber = 8;

                    LottoResult result = new LottoResult(numbers, bonusNumber);
                    user.matchLottoNumbers(result);

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outputStream));

                    user.printProfitRate();

                    String captured = outputStream.toString().trim();

                    assertThat(captured).contains(
                            "총 수익률은 40631100.0%입니다."
                    );


                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 2, 3, 4, 5, 11)
        );
    }

    List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
