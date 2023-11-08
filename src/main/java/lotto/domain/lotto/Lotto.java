package lotto.domain.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void lottoByDuplicateNumber() {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 로또 번호를 입력해주세요.");
        }
    }

    public void lottoByRange() {
        numbers.forEach(e -> {
            if (e > 45 || e < 1) {
                throw new IllegalArgumentException("1 ~ 45 사이의 로또 번호를 입력해주세요.");
            }
        });
    }

    public void numberByContains(int num) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException("이미 당첨번호에 포함된 숫자입니다.");
        }
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    public int containsCount(WinLotto winLotto) {
        return (int) numbers.stream().filter(e -> winLotto.contains(e)).count();

    }

    public void showLotto() {
        System.out.println(numbers);
    }
}
