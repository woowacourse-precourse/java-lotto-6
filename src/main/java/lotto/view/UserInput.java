package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.TypeChanger;

public class UserInput {
    private static final TypeChanger typeChanger = TypeChanger.getTypeChanger();

    public int money() {
        OutputView.printInputMoney();
        String input = Console.readLine();
        return typeChanger.from(input);
    }

    public List<Integer> lottoNumber() {
        OutputView.printInputWinNumber();
        String input = Console.readLine();
        return from(input);
    }

    private List<Integer> from(String input) {
        List<String> numbers = typeChanger.stringToListWithComma(input);
        return typeChanger.from(numbers);
    }

    public int bonusBall() {
        OutputView.printInputBonusNumber();
        String input = Console.readLine();
        return typeChanger.from(input);
    }
}
