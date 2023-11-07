package lotto.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.constant.StateType;
import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;

public class OutputView {
    private static final String OUTPUT_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_NUMBERS_MESSAGE = "[%d, %d, %d, %d, %d, %d]";
    private static final String OUTPUT_LOTTO_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String OUTPUT_RESULT_TEMPLATE_MESSAGE = "당첨 통계\n---";
    private static LinkedHashMap<StateType, String> OUTPUT_RESULT_MESSAGE_BY_STATE = new LinkedHashMap<>();

    static {
        OUTPUT_RESULT_MESSAGE_BY_STATE.put(StateType.THREE_MATCH, "3개 일치 (5,000원) - %d개");
        OUTPUT_RESULT_MESSAGE_BY_STATE.put(StateType.FOUR_MATCH, "4개 일치 (50,000원) - %d개");
        OUTPUT_RESULT_MESSAGE_BY_STATE.put(StateType.FIVE_MATCH_NO_BONUS, "5개 일치 (1,500,000원) - %d개");
        OUTPUT_RESULT_MESSAGE_BY_STATE.put(StateType.FIVE_MATCH_BONUS, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개");
        OUTPUT_RESULT_MESSAGE_BY_STATE.put(StateType.SIX_MATCH, "6개 일치 (2,000,000,000원) - %d개");
    }

    public static void outputAllLottoNumbers(Lottos lottos) {
        List<Lotto> outputLottos = lottos.getAllLotto();
        outputLottoCount(outputLottos);

        outputLottos.forEach(
                lotto -> System.out.println(String.format(OUTPUT_LOTTO_NUMBERS_MESSAGE, lotto.getNumbers().toArray())));

    }

    public static void outputLottoCount(List<Lotto> outputLottos) {
        System.out.println(String.format(OUTPUT_LOTTO_COUNT_MESSAGE, outputLottos.size()));
    }

    public static void outputResult(HashMap<StateType, Integer> result) {
        System.out.println(OUTPUT_RESULT_TEMPLATE_MESSAGE);
        OUTPUT_RESULT_MESSAGE_BY_STATE.forEach((stateType, message) -> {
            System.out.println(String.format(message, result.getOrDefault(stateType, 0)));
        });
    }

    public static void outputProfitRate(double profitRate) {
        System.out.println(String.format(OUTPUT_LOTTO_PROFIT_RATE_MESSAGE, profitRate));
    }
}
