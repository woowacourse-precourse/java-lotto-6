package lotto;

import java.util.List;

public class ResultBuilder {

    private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String SIZE_MESSAGE = "개";

    public ResultBuilder() {
    }

    public String resultBuild(int[] result) {
        List<String> messages = List.of(FIFTH_PRIZE_MESSAGE, FOURTH_PRIZE_MESSAGE, THIRD_PRIZE_MESSAGE, SECOND_PRIZE_MESSAGE, FIRST_PRIZE_MESSAGE);
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < result.length; index++) {
            stringBuilder.append(messages.get(index))
                    .append(result[index])
                    .append(SIZE_MESSAGE)
                    .append('\n');
        }
        return stringBuilder.toString();
    }
}
