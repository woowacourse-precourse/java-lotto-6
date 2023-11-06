package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.InputController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    final static int LOTTO_SIZE = 6;
    private List<Integer> numbers;

    private InputController inputController = new InputController();

    Integer bonus; // 메소드 호출

    public void validation(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력할 수 있습니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public Player(List<Integer> numbers) {
        while (true) {
            try {
                validation(numbers);
                this.numbers = numbers;
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                numbers = inputController.playerInput();
            }
        }

        bonus = InputController.bonusInput();
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonus() {
        return bonus;
    }
}
