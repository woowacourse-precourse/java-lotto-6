package lotto.view;

import static lotto.util.Introduction.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * {@code InputView}의 구현부다.
 */
public class InputViewImpl implements InputView {

    /**
     * 단일 문자를 입력받는다.
     *
     * @return 입력받은 문자
     */
    @Override
    public String inputConstant() {
        return Console.readLine();
    }

    /**
     * 여러 개의 문자를 입력받는다.
     *
     * @return 구분자로 구분된 여러 개의 문자
     */
    @Override
    public List<String> inputList() {
        return List.of(Console.readLine().split(DELIMITER.getIntroduction(), -1));
    }
}
