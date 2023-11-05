package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Integer> inputWinningLottoStandardNumber() {
        List<Integer> lottoNumbers;
        System.out.println("당첨 번호를 입력해주세요.");
        try {
            lottoNumbers = Arrays.stream(readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoStandardNumber();
        }
        return lottoNumbers;
    }
}
