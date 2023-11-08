package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lotto.constant.LottoMessage;
import lotto.constant.LottoPrize;
import lotto.model.LottoResult;

public class OutputMaker {

    private static final String NUMBERS_PREFIX = "[";
    private static final String NUMBERS_SUFFIX = "]";
    private static final String DELIMITER = ", ";
    private static final String NEW_LINE = "\n";

    public String makeLottosNumbersOutput(List<List<Integer>> lottosNumbers) {
        return lottosNumbers.stream()
            .map(this::makeLottoNumbersOutput)
            .collect(Collectors.joining(NEW_LINE));
    }

    public String makeLottoResultOutput(LottoResult lottoResult) {
        StringJoiner sj = new StringJoiner(NEW_LINE);
        Map<LottoPrize, Integer> prizesCount = lottoResult.getPrizesCount();
        for (LottoPrize lottoPrize : prizesCount.keySet()) {
            if (lottoPrize.equals(LottoPrize.NO_MATCH)) {
                continue;
            }
            sj.add(LottoMessage.getLottoResultMessage(lottoPrize, prizesCount.get(lottoPrize)));
        }
        return sj.toString();
    }

    private String makeLottoNumbersOutput(List<Integer> numbers) {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(DELIMITER, NUMBERS_PREFIX, NUMBERS_SUFFIX));
    }
}
