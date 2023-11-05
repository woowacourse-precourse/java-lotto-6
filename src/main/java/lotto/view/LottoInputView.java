package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoInputView {
    private static final String DELIMITER = ",";
    private static final String FORMAT_ERROR_MESSAGE = "잘못된 입력 형식 입니다.";

    public List<Integer> readLottoInput() {
        try {
            String line = readLine();
            return Arrays.stream(line.split(DELIMITER)).map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

}
