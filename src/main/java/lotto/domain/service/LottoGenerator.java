package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.error.ErrorType;

public class LottoGenerator {
    public Lotto generateLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public Lotto generateWinningNumber(String userInputWinningNumber) {
        String spaceRemovedUserInputWinningNumber = userInputWinningNumber.replace(" ", "");
        String[] userInputWinningNumberArray = spaceRemovedUserInputWinningNumber.split(",");
        List<Integer> userInputWinningNumberList = new ArrayList<>();

        for (String stringNumber : userInputWinningNumberArray) {
            int number = Integer.parseInt(stringNumber);

            userInputWinningNumberList.add(number);
        }
        return new Lotto(userInputWinningNumberList);
    }
}
