package lotto.domain;

import lotto.controller.InputController;

import java.util.List;

public class Player {
    final static int LOTTO_SIZE = 6;
    private final List<Integer> numbers;
    private Integer bonus;
    private InputController inputController = new InputController();

    public void validation(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력할 수 있습니다.");
        }
    }

    public Player(List<Integer> numbers, Integer bonus) {
        validation(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonus() {
        return bonus;
    }
}
