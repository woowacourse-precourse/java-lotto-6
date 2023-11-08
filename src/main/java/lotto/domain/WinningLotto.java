package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private final Bonus bonusNumber;

    public WinningLotto() {
        this.lotto = this.generateGuessLotto();
        bonusNumber = this.generateBonusNumber();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber(){
        return bonusNumber.getBonusNumber();
    }


    private Lotto generateGuessLotto(){
        String[] splittedNumbers = Console.readLine().split(",");
        List<Integer> numbers = Arrays.stream(splittedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    private Bonus generateBonusNumber(){
        return new Bonus();
    }


}
