package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Integer> inputWinningLottoStandardNumber() {
        List<Integer> lottoNumbers;
        System.out.println("당첨 번호를 입력해주세요.");
        try {
            lottoNumbers = stringListToIntList(Arrays.stream(Console.readLine().split(",")).toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoStandardNumber();
        }
        return lottoNumbers;
    }

    public int inputWinningLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR]: 한 개의 숫자를 입력하셔야 됩니다.");
            return inputWinningLottoBonusNumber();
        }
    }

    private List<Integer> stringListToIntList(List<String> stringInput) throws IllegalArgumentException{
        try {
            return stringInput.stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력 하셔야하고 각 숫자는 ,로 구분되어야 합니다.");
        }
    }
}
