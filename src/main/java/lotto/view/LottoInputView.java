package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class LottoInputView {
    private static final String DELIMITER = ",";
    private static final String FORMAT_ERROR_MESSAGE = "잘못된 입력 형식 입니다.";

    public List<Integer> readLottoInput() {
        try {
            String line = readLine();
            return Arrays.stream(line.split(DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

}
