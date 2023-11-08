package lotto.domain;

import static lotto.LottoConstants.LOTTO_SIZE;

import java.util.List;
import java.util.StringJoiner;
import lotto.util.ExceptionMessageGenerator;

public class Lotto {
    private static final String NOT_SIZE = String.format("로또 번호는 %d자리여야 합니다.", LOTTO_SIZE.getValue());
    private static final String NOT_UNIQUE = "로또번호는 중복되지 않아야 합니다.";
    private static final String SEPERATOR = ", ";
    private static final String FRONT = "[";
    private static final String BACK = "]";
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertToLottoNumber(numbers);
    }

    private void validate(List<Integer> numbers) {
        ExceptionMessageGenerator exceptionMessageGenerator = ExceptionMessageGenerator.INSTANCE;

        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(exceptionMessageGenerator.makeMessage(NOT_SIZE));
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(exceptionMessageGenerator.makeMessage(NOT_UNIQUE));
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        int uniqueSize = numbers.stream().distinct().toList().size();
        return uniqueSize != LOTTO_SIZE.getValue();
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    public boolean isContains(LottoNumber number) {
        return numbers.contains(number);
    }

    public long getMatchCount(Lotto otherLotto) {
        return otherLotto.numbers.stream()
                .filter(this::isContains)
                .count();
    }

    public String getNumbersMessage() {
        StringJoiner numberMessage = new StringJoiner(SEPERATOR, FRONT, BACK);
        numbers.stream()
                .map(LottoNumber::getNumberMessage)
                .forEach(numberMessage::add);

        return numberMessage.toString();
    }
}
