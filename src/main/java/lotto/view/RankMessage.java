package lotto.view;

import java.util.Arrays;
import java.util.List;

public enum RankMessage {

    FIRST_RANK_MESSAGE("6개 일치 (2,000,000,000원) - %d개"),
    SECOND_RANK_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_RANK_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    FOURTH_RANK_MESSAGE("4개 일치 (50,000원) - %d개"),
    FIFTH_RANK_MESSAGE("3개 일치 (5,000원) - %d개");

    private String message;

    RankMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}