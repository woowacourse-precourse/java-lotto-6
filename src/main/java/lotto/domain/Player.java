package lotto.domain;

import lotto.controller.InputController;

import java.util.List;

public class Player {


    private final List<Integer> numbers;
    private Integer bonus;
    private InputController inputController = new InputController();

    public void validation(List<Integer> numbers) {
        // TODO: 예외처리(입력 값 개수 등..)
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
