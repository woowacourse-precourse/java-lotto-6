package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.service.WinningNumberService;
import lotto.service.exception.IllegalArgumentExceptionHandler;
import lotto.service.exception.InputErrorMessage;

public class LotteryGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private Lotto lotto;

    private void generateLotto() {
        List<Integer> numbers;
        do {
            numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER,NUMBER_SIZE);

        } while (!verifyDuplication(numbers));
        this.lotto = new Lotto(numbers);
    }

    private boolean verifyDuplication(List<Integer> winningNumber){
        Set<Integer> checkDuplication = new HashSet<>();
        for(int number : winningNumber){
            if(checkDuplication.contains(number)){
                throw new IllegalArgumentExceptionHandler(InputErrorMessage.DUPLICATE_NUMBER);
            }
            checkDuplication.add(number);
        }
        return true;
    }

    public Lotto getLotto() {
        generateLotto();
        return lotto;
    }

}
