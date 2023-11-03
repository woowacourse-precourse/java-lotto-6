package lotto.domain;


import java.util.List;

public class UserLotto {
    private final List<Integer> userNumbers;

    public UserLotto(List<Integer> userNumbers) {
        validate(userNumbers);
        this.userNumbers = userNumbers;
    }

    private void validate(List<Integer> userNumbers) {
        if (userNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 정확히 6개여야 합니다.");
        }
        if (userNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        if (userNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }
}
