package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    InputView inputView = new InputView();

    @Nested
    class RequestMoneyToBuyTest extends NsTest {
        @DisplayName("금액 입력 에러 테스트입니다.")
        @Test
        void requestMoneyToBuyTest() {
            assertSimpleTest(() -> {
                run("-123", "0", "1001", "3000q", "3000");
                assertThat(output()).contains(
                        "[ERROR] 금액은 양수여야 합니다.",
                        "[ERROR] 금액은 양수여야 합니다.",
                        "[ERROR] 금액은 1000원 단위이어야 합니다.",
                        "[ERROR] For input string: \"3000q\""
                );
            });
        }

        @Override
        protected void runMain() {
            inputView.requestMoneyToBuy();
        }
    }

    @Nested
    class RequestWinningLottoTest extends NsTest {
        @DisplayName("당첨 번호 입력에 대한 에러 테스트입니다.")
        @Test
        void requestWinningLottoTest() {
            assertSimpleTest(() -> {
                run("1,2,3,4",
                        "1,2,3,4,5,5",
                        "1,2,3,4,5,46",
                        "0,2,3,4,5,45",
                        "1,2,3,4,5,45a",
                        "1,2,3,4,5,6", // normal case
                        "1", // bonus
                        "0",
                        "1f",
                        "46",
                        "7" // normal case
                );
                assertThat(output()).contains(
                        "[ERROR] 로또 번호의 개수는 6이어야 합니다.",
                        "[ERROR] 로또 번호는 서로 중복되면 안됩니다.",
                        "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
                        "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
                        "[ERROR] For input string: \"45a\"",
                        "[ERROR] 로또 번호는 서로 중복되면 안됩니다.",
                        "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
                        "[ERROR] For input string: \"1f\"",
                        "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
                );
            });
        }

        @Override
        protected void runMain() {
            inputView.requestWinningLotto();
        }
    }
}

