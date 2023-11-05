package lotto.view.output;

import lotto.dto.LottoDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputFormatter {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String COMMA = ",";

    private OutputFormatter() {
    }

    public static String makePurchaseLottos(List<LottoDto> lottoDto) {
        String result = lottoDto.stream()
                .map(OutputFormatter::makeLottoDtoFormat)
                .collect(Collectors.joining(NEW_LINE));
        return lottoDto.size() + PURCHASE_MESSAGE + NEW_LINE + result;
    }

    private static String makeLottoDtoFormat(LottoDto lottoDto) {
        List<Integer> lottoDtoNumbers = lottoDto.getNumbers();

        String result = lottoDtoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(COMMA + SPACE, LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET));
        return result;
    }
}
