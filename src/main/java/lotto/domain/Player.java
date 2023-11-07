package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.InputController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    final static int LOTTO_SIZE = 6;
    private Lotto lotto;
    private InputController inputController = new InputController();

    Integer bonus; // 메소드 호출


    public Player(List<Integer> numbers) {
        while (true) {
            try {
                lotto = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                numbers = inputController.playerInput();
            }
        }

        bonus = InputController.bonusInput();
    }


    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public Integer getBonus() {
        return bonus;
    }
}
