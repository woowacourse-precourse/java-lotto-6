package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Test
    @DisplayName("구매자에게 구매금액을 입력받는다.")
    void inputPurchaseAmount() {
        String inputPurchaseAmount = inputPurchaseAmount("10000");
        assertThat(inputPurchaseAmount).isEqualTo("10000");
    }

    @DisplayName("구매자에게 구매금액을 입력받는 메서드.")
    private String inputPurchaseAmount(String input){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner in = new Scanner(input);
        input = in.next();
        return input;
    }

    @Test
    @DisplayName("입력한 값이 숫자인지 검증한다.")
    void inputPurchaseAmountValidation_정상케이스() {
        assertThatCode(() -> inputPurchaseAmountValidation("12000"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력한 값이 숫자인지 검증한다.")
    void inputPurchaseAmountValidation_예외케이스() {
        assertThatThrownBy(() -> inputPurchaseAmountValidation("테스트"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000");
    }

    @DisplayName("구매자에게 구매금액을 입력받는 메서드.")
    private  int inputPurchaseAmountValidation(String inputPurchaseAmount){
        try {
            int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
            return purchaseAmount;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000");
        }
    }
}
