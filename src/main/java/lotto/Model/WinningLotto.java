package lotto.Model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {
    private static final String LOTTO_NUMBER_DELIMETER = ",";
    public static final String ERROR_NOT_LOTTO_FORMAT =
            String.format("[ERROR] 숫자와 쉼표(%s)만을 이용해서 입력해주세요. 예시) 1,2,3,4,5,6", LOTTO_NUMBER_DELIMETER);
    public static final String ERROR_END_LOTTO_NUMBER_DELEMETER =
            String.format("[ERROR] 마지막은 %s가 올 수 없습니다. 예시) 1,2,3,4,5,6", LOTTO_NUMBER_DELIMETER);

    private final Lotto winningLotto;

    public WinningLotto(String input) {
        validate(input);
        try {
            this.winningLotto = new Lotto(Stream.of(input.split(LOTTO_NUMBER_DELIMETER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_LOTTO_FORMAT);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    @Override
    public String toString() {
        return winningLotto.toString();
    }

    private void validate(String input) {
        if (input.endsWith(LOTTO_NUMBER_DELIMETER)) {
            throw new IllegalArgumentException(ERROR_END_LOTTO_NUMBER_DELEMETER);
        }
    }
}
