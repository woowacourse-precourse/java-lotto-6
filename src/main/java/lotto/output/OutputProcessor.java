package lotto.output;

import lotto.Lotto;

import java.util.List;

public class OutputProcessor {
    public static final String NUMBER_OF_BOUGHT_PROMPT = "%d개를 구매했습니다.";
    public static final String DEFAULT_SEPARATOR = ", ";
    public static final String LEFT_BRACKET = "[";
    public static final String RIGHT_BRACKET = "]";
    private final OutputSender outputSender;

    public OutputProcessor(OutputSender outputSender) {
        this.outputSender = outputSender;
    }

    public void outputNumberOfLottos(int numberOfLottos) {
        outputSender.send(String.format(NUMBER_OF_BOUGHT_PROMPT, numberOfLottos));
    }

    public void outputLotto(Lotto lotto) {
        List<String> numbers = lotto.getLottoNumbers().stream()
                .map(String::valueOf)
                .toList();
        outputSender.send(LEFT_BRACKET +
                String.join(DEFAULT_SEPARATOR, numbers) +
                RIGHT_BRACKET);
    }
}
