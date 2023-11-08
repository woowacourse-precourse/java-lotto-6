package lotto.Input;

import java.util.List;

public class Lotto {
    private final List<Integer> winningNumber;


    public Lotto(List<Integer> numbers) {
        checkInputSize(numbers);
        duplicateException(numbers);
        rangeException(numbers);
        this.winningNumber = numbers;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    private void checkInputSize(List<Integer> ticket) {
        if (ticket.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력하셔야 합니다.");
        }
    }

    public void duplicateException(List<Integer> ticket) {
        if (ticket.size() == 6 & ticket.stream().distinct().count() != 6)
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
    }

    public void rangeException(List<Integer> ticket) {
        if (ticket.stream().filter(s -> s < 1 || s > 45).count() != 0)
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
    }

}
