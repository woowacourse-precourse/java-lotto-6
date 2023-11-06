package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String NUMBER_DELIMITER = ",";

    public int readPurchaseAccount() {
        int purchaseAccount = Integer.parseInt(readLine());
        //TODO 검증
        return purchaseAccount;
    }

    public List<Integer> readWinningNumbers() {
        String numbers = readLine();
        List<Integer> winningNumbers = Arrays.stream(numbers.split(NUMBER_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        //TODO 검증 + input의 책임에 대해 다시 한번 생각해보기.
        return winningNumbers;
    }

    public int readBonusNumber() {
        int bonusNumber = Integer.parseInt(readLine());
        //TODO 검증
        return bonusNumber;
    }
}
