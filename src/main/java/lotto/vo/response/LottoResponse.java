package lotto.vo.response;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResponse {
    private static final String DELIMITER = ", ";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";

    private final List<String> lottoNumbers;

    public LottoResponse(List<Integer> lottoNumbers) {
        this.lottoNumbers = convertToString(lottoNumbers);
    }

    private List<String> convertToString(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Object::toString)
            .collect(Collectors.toList());
    }

    public String createMessage() {
        String numbers = String.join(DELIMITER, lottoNumbers);
        StringBuilder builder = new StringBuilder();
        return builder.append(OPEN_BRACKET)
            .append(numbers)
            .append(CLOSE_BRACKET)
            .toString();
    }
}
