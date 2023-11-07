package lotto.lotto;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.bonus.BonusNumber;
import lotto.utils.StringSplitParser;

public class WinningLotto {

    private static final String NOT_NUMBERS_MESSAGE = "당첨 번호는 숫자로 입력해야 합니다.";
    private static final Pattern LOTTO_NUMBERS_PATTERN = Pattern.compile("^\\d+(,\\d+)*");
    private final Lotto winningLotto;

    public WinningLotto(String numbers) {
        validate(numbers);
        this.winningLotto = splitStringToLotto(numbers);
    }

    private void validate(String numbers) {
        if (!LOTTO_NUMBERS_PATTERN.matcher(numbers).matches()) {
            throw new IllegalArgumentException(NOT_NUMBERS_MESSAGE);
        }
    }

    private Lotto splitStringToLotto(String numbers) {
        return StringSplitParser.splitStringToNumbers(numbers).stream().map(Integer::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }

    public Integer getMatchNumberCount(Lotto lotto) {
        return this.winningLotto.findMatchCount(lotto);
    }

    public boolean hasBonusNumber(BonusNumber bonusNumber) {
        return winningLotto.hasBonusNumber(bonusNumber);
    }
}
