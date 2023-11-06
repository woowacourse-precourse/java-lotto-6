package lotto.core;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.UserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.utils.PrintUtil.*;
import static lotto.constValue.ConstNumber.*;
import static lotto.core.Random.*;

public class Lottery {
    private UserInput userInput;
    private List<Lotto> lottos;
    private WinningNumber winningNumbers;
    private int countOfLotto;

    public Lottery(){
        this.userInput = new UserInput();
        this.lottos = new ArrayList<>();
        this.countOfLotto = 0;
    }

    public void play(){
        ready();
        start();
        //end();
    }

    private void ready(){
        printPricePrompt();
        userInput.inputLottoPrice();

        this.countOfLotto = userInput.getLottoPrice()/LOTTO_PRICE;

        printLottoCount(countOfLotto);

        for(int i=0;i<countOfLotto;i++){
            setLottos(getRandomNumbers());
        }

        printWinningNumberPrompt();
        userInput.inputWinningNumbers();

        printBonusNumberPrompt();
        userInput.inputBonusNumber();

        winningNumbers = new WinningNumber(
                userInput.getWinningNumbers(),
                userInput.getBonusNumber()
        );
    }

    private void start(){
        for(Lotto currentLotto:lottos){
            int count = compareLotto(currentLotto);
            System.out.println(count);
        }
    }

    private void end(){

    }

    private void setLottos(List<Integer> randomNumbers){
        Lotto newLotto = new Lotto(randomNumbers);
        printLottoNumbers(newLotto);
        lottos.add(newLotto);
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
