package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidInputNumFormatException;
import lotto.exception.InvalidRangeException;
import lotto.exception.InvalidWinningLottoFormatException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoAdmin {
    private final Pattern WINNINGPATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    private final Pattern BONUSPATTERN = Pattern.compile("\\d+");

    private final Integer MIN_RANGE = 1;
    private final Integer MAX_RANGE = 45;

    private Lotto winningNumber;
    private Integer bonusNumber;

    public void inputWinningNumber() {
        String winningNums = Console.readLine();
        validateWinningInput(winningNums);
        this.winningNumber = new Lotto(Stream.of(winningNums.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public void inputBonusNumber() {
        String bonusStr = Console.readLine();
        validateBonusInput(bonusStr);
        Integer bonusNum = Integer.parseInt(bonusStr);
        validateRange(bonusNum);
        this.bonusNumber = bonusNum;
    }

    private void validateWinningInput(String inputValue) {
        if (!WINNINGPATTERN.matcher(inputValue).matches()) {
            throw new InvalidWinningLottoFormatException();
        }
    }

    private void validateBonusInput(String inputValue) {
        if (!BONUSPATTERN.matcher(inputValue).matches()) {
            throw new InvalidInputNumFormatException();
        }
    }

    private void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new InvalidRangeException();
        }
    }

    public boolean isContain(Integer number) {
        return winningNumber.isContain(number);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
