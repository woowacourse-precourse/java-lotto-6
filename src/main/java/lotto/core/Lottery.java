package lotto.core;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.UserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.utils.PrintUtil.*;

public class Lottery {
    private UserInput userInput;
    private List<Lotto> lottos;
    private WinningNumber winningNumbers;

    public Lottery(){
        this.userInput = new UserInput();
        this.lottos = new ArrayList<>();

        ready();
        start();
        end();
    }

    public void ready(){
        printPricePrompt();
        userInput.inputLottoPrice();

    }

    public void start(){

    }

    public void end(){

    }

    public int compareLotto(Lotto lotto){
        int count = 0;
        int bonusNumber = winningNumbers.getBonusNumber();
        List<Integer> winningNumber = winningNumbers.getWinningNumbers().getNumbers();

        for (Integer number : winningNumber) {
            if (lotto.getNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasBonusNumber(Lotto lotto){
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

}
