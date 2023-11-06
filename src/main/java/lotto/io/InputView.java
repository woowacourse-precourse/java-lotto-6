package lotto.io;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionManager;

public class InputView {

    private final IoManager ioManager;

    public InputView(IoManager ioManager) {
        this.ioManager = ioManager;
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return stringToInt(ioManager.read());
    }

    public List<Integer> inputLotto() {
        displayEmptyLine();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = ioManager.read().split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String str : input) {
            lottoNumbers.add(stringToInt(str));
        }
        return lottoNumbers;
    }

    public int inputBonus() {
        displayEmptyLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        return stringToInt(ioManager.read());
    }

    private int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw ExceptionManager.BEGIN_ERROR.createIllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void displayEmptyLine() {
        System.out.println();
    }

}
