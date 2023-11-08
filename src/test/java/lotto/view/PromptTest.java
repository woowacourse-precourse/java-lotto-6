package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PromptTest extends NsTest {
    @DisplayName("prompt enum 결과값 정상 출력 확인")
    @Test
    void checkPromptReturnValue() {
        init();
        for (Prompt prompt : Prompt.values()) {
            System.out.println(prompt.getMessage());
        }
        assertThat(output()).contains(
                "구입금액을 입력해 주세요.",
                "당첨 번호를 입력해 주세요.",
                "보너스 번호를 입력해 주세요.",
                "%d개를 구매했습니다.\n",
                "당첨 통계\n---",
                "%d개 일치%s - %d개",
                "총 수익률은 %.1f%%입니다."
        );

    }

    @Override
    protected void runMain() {

    }
}
