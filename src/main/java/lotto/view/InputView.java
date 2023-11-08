package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constant.Delimiter;
import lotto.constant.ErrorMessage;
import lotto.constant.InputMessage;

public class InputView {
    public int inputMoney() {
        System.out.println(InputMessage.RECEIVE_MONEY.getMessage());
        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch(IllegalArgumentException e) {
            System.out.println(ErrorMessage.INPUT_NOT_A_NUMBER.getMessage());
            return inputMoney();
        }
    }
    public List<Integer> inputWinningLottoStandardNumber() {
        List<Integer> lottoNumbers;
        System.out.println(InputMessage.RECEIVE_LOTTO_NUMBER.getMessage());
        try {
            lottoNumbers = stringListToIntList(
                    Arrays.stream(Console.readLine().split(Delimiter.SEQUENCE.getValue())).toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoStandardNumber();
        }
        return lottoNumbers;
    }

    private List<Integer> stringListToIntList(List<String> stringInput) throws IllegalArgumentException{
        try {
            return stringInput.stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CANT_DELIMITER.getMessage());
        }
    }

    public int inputWinningLottoBonusNumber() {
        System.out.println(InputMessage.RECEIVE_BONUS_NUMBER.getMessage());
        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch(IllegalArgumentException e) {
            System.out.println(ErrorMessage.INPUT_MULTIPLE_INPUT.getMessage());
            return inputWinningLottoBonusNumber();
        }
    }
}
