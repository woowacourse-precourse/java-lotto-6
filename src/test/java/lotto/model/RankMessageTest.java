package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankMessageTest {

    @Test
    @DisplayName("결과 출력 형식 확인")
    void messageTest() {
        for (RankMessage message : RankMessage.values()) {
            System.out.println(message.getMessage(3));
        }
    }
}