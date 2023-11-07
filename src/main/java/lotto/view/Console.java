package lotto.view;

import lotto.controller.dto.GameResult;
import lotto.controller.dto.GameResult.LottoGameResult;
import lotto.controller.dto.LottoResult;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.controller.dto.LottoResult.*;

public class Console {

    private static final Pattern REGEX = Pattern.compile("^[0-9]*$");
    private static final String DELIMITER = ",";

    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public List<Integer> readWinningNumbers() {
        output.println("\n당첨 번호를 입력해 주세요.");
        String value = input.read();
        validateNull(value);
        validateType(value);

        return Arrays.stream(value.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        output.println("\n보너스 번호를 입력해 주세요.");
        String value = input.read();
        validateNull(value);
        validateType(value);

        return Integer.parseInt(value);
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateType(String value) {
        Arrays.stream(value.split(DELIMITER))
                .filter(input -> !isNumeric(input))
                .findAny()
                .ifPresent(input -> {
                    throw new IllegalArgumentException();
                });
    }

    private boolean isNumeric(String value) {
        return REGEX.matcher(value).matches();
    }

    public int readMoney() {
        output.println("구입금액을 입력해 주세요.");
        String value = input.read();
        validateNull(value);
        validateType(value);

        return Integer.parseInt(value);
    }

    public void printLottoResults(GameResult gameResult) {
        output.println("\n당첨 통계\n---");
        gameResult.results().forEach(this::printLottoResult);
        printProfitRate(gameResult);
    }

    private void printLottoResult(LottoGameResult result) {
        String LottoResultMessage = MessageFormat.format(
                "{0}개 일치 ({1}원) - {2}개",
                result.matchCount(),
                result.winningMoney(),
                result.count()
        );
        output.println(LottoResultMessage);
    }

    private void printProfitRate(GameResult gameResult) {
        String profitRateMessage = MessageFormat.format("총 수익률은 {0}%입니다.", gameResult.profitRate());
        output.println(profitRateMessage);
    }

    public void printLottoCount(int lottoCount) {
        String lottoCountMessage = MessageFormat.format("\n{0}개를 구매했습니다.", lottoCount);
        output.println(lottoCountMessage);
    }

    public void printLottos(LottoResult result) {
        result.responses().forEach(this::printLotto);
    }

    private void printLotto(LottoResponse lottoResponse) {
        String lotto = lottoResponse.numbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"));

        output.println(lotto);
    }

}
