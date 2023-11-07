package lotto.domain;

import java.util.List;

public class Game {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Game(List<Integer> winningNumbers,int bonusNumber){
        this.winningNumbers=winningNumbers;
        this.bonusNumber=bonusNumber;
    }
}
