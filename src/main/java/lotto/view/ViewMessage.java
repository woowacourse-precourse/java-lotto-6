package lotto.view;

import java.util.Arrays;

public enum ViewMessage {
    THREE_VIEW_MESSAGE(3, "3개 일치 (5,000원) - "),
    FOUR_VIEW_MESSAGE(4, "4개 일치 (50,000원) - "),
    FIVE_VIEW_MESSAGE(5, "5개 일치 (1,500,000원) - "),
    FIVE_WITH_BONUS_VIEW_MESSAGE(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_VIEW_MESSAGE(6, "6개 일치 (2,000,000,000원) - "),
    ;

    public static final String END = "개";
    private final String message;
    private final int index;

    ViewMessage(int index, String message) {
        this.index = index;
        this.message = message;
    }

    public String resultMessage(int index, int count) {
        return String.format(findByIndex(index) + count + END);
    }

    public String findByIndex(int index) {
        return Arrays.stream(values())
            .filter(viewMessage -> viewMessage.getIndex() == index)
            .findFirst().get().getMessage();
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }
}
