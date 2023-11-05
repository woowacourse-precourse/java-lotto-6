package lotto.view;

import static java.util.stream.Collectors.joining;

import lotto.dto.LotteriesDto;
import lotto.dto.LottoDto;

public class OutputView {

    private static final String LOTTO_SIZE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String NUMBER_DELIMITER = ", ";
    private static final String NUMBER_PREFIX = "[";
    private static final String NUMBER_SUFFIX = "]\n";

    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s\n";

    public void printLotteries(LotteriesDto lotteries) {
        printCountOfLotteries(lotteries.getSize());
        lotteries.lottos().forEach(this::printLotto);
    }

    private void printCountOfLotteries(int size) {
        print(LOTTO_SIZE_FORMAT.formatted(size));
    }

    private void printLotto(LottoDto lottoDto) {
        String message = makeLottoView(lottoDto);
        print(message);
    }

    private String makeLottoView(LottoDto lottoDto) {
        return lottoDto.numbers().stream()
                .sorted()
                .map(Object::toString)
                .collect(joining(NUMBER_DELIMITER, NUMBER_PREFIX, NUMBER_SUFFIX));
    }

    public void printExceptionMessage(Exception exception) {
        String message = makeExceptionView(exception);
        print(message);
    }

    private String makeExceptionView(Exception exception) {
        return EXCEPTION_MESSAGE_FORMAT.formatted(exception.getMessage());
    }

    private void print(String message) {
        System.out.print(message);
    }
}
