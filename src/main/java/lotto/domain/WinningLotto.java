package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    public static final String NUMBERS_EXCEPTION_MSG = "[ERROR] 당첨 번호가 정수가 아닙니다.";
    public static final String BONUS_EXCEPTION_MSG = "[ERROR] 보너스 번호가 이상합니노 ㅋㅋ.";
    private Lotto winningLotto;
    private Integer bonusNumber;

    public WinningLotto(String numbers, String bonus) {
        winningLotto = new Lotto(sliceNumbers(numbers));
    }

    private List<Integer> sliceNumbers(String numbers) {
        List<String> temp = Arrays.stream(numbers.split(",", -1)).toList();

        List<Integer> validNumbers;
        try {
            validNumbers = temp.stream()
                    .map(number -> Integer.parseInt(number)).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBERS_EXCEPTION_MSG);
        }

        return validNumbers;
    }

}
