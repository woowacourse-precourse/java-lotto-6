package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.TypeChanger;

public class UserInput {
    private static final TypeChanger typeChanger = TypeChanger.getTypeChanger();

    public int money() {
        OutputView.printInputMoney();
        String input = Console.readLine();
        int money = typeChanger.from(input);
        return money;
    }

    public List<Integer> lottoNumber() {
        OutputView.printInputWinNumber();
        String input = Console.readLine();
        List<Integer> lottoNumbers = from(input);
        return lottoNumbers;
    }

    private List<Integer> from(String input) {
        List<String> numbers = typeChanger.stringToListWithComma(input);
        List<Integer> lottoNumbers = typeChanger.from(numbers);
        return lottoNumbers;
    }

    public int bonusBall() {
        OutputView.printInputBonusNumber();
        String input = Console.readLine();
        return typeChanger.from(input);
    }
}
