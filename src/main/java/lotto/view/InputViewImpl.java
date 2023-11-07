package lotto.view;

import static lotto.util.Introduction.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputViewImpl implements InputView {

    @Override
    public String inputConstant() {
        return Console.readLine();
    }

    @Override
    public List<String> inputList() {
        return List.of(Console.readLine().split(DELIMITER.getIntroduction(), -1));
    }
}
