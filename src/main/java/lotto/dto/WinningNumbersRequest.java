package lotto.dto;

import static lotto.exception.ExceptionMessage.ILLEGAL_NUMBER;

import java.util.List;
import lotto.domain.Lotto;

public class WinningNumbersRequest {
    private final Lotto winningNumbers;

    private WinningNumbersRequest(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbersRequest of(String input) {
        List<Integer> integerList = stringToInt(List.of(input.split(",")));
        Lotto winningNumbers = Lotto.of(integerList);
        return new WinningNumbersRequest(winningNumbers);
    }

    private static List<Integer> stringToInt(List<String>  input) {
        try{
            return input.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) { //그냥 엔터한 경우 null로 return되는데 이경우도 처리됨.
            throw new IllegalArgumentException(ILLEGAL_NUMBER.getMessage());
        }
    }

    public Lotto getWinningLotto() {
        return winningNumbers;
    }


}
