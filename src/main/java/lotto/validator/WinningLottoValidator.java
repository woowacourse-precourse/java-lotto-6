package lotto.validator;

import lotto.util.Utils;

import java.util.List;

public class WinningLottoValidator {
    public static boolean isInvalid(String winningLotto) {
        try {
            Utils.convertStringToList(winningLotto);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주셔야 합니다.");
            return true;
        }
        return false;
    }

    public static boolean hasSpecialCharacter(String winningLotto) {
        if(!winningLotto.matches("[0-9, ]+")) {
            System.out.println("[ERROR] 쉼표 외에 다른 특수문자는 사용할 수 없습니다.");
            return true;
        }
        return false;
    }

    public static boolean isInvalidSize(String winningLotto) {
        List<Integer> winningLottos = Utils.convertStringToList(winningLotto);
        if(winningLottos.size() != 6) {
            System.out.println("[ERROR] 6개의 당첨 번호를 입력해주셔야 합니다.");
            return true;
        }
        return false;
    }

    public static boolean isDuplicated(String winningLotto) {
        List<Integer> winningLottos = Utils.convertStringToList(winningLotto);
        if (winningLottos.stream().distinct().count() != winningLottos.size()) {
            System.out.println("[ERROR] 당첨 번호는 중복되어서는 안됩니다.");
            return true;
        }
        return false;
    }

    public static boolean isInvalidNumber(String winningLotto) {
        List<Integer> winningLottos = Utils.convertStringToList(winningLotto);
        if(winningLottos.stream().anyMatch(number -> number > 45 || number < 1)) {
            System.out.println("[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
            return true;
        }
        return false;
    }
}
