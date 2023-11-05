package lotto.io;

import java.util.List;

public class UserInput {
    private Integer price;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public UserInput(Integer price, List<Integer> winningNumbers, Integer bonusNumber) {
        this.price = price;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
