package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.controller.InputController.*;

public class CheckValidation {
    public void checkInputMoney() {
        if (money % 1000 !=0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }
    public void checkWinningNumBlank(String[] numberStrings) {
        boolean checkBlank = Arrays.stream(numberStrings).noneMatch(str -> str.equals(" ") || str.equals(""));
        if (!checkBlank) {
            throw new IllegalArgumentException("입력하신 값 중에 공백이 존재합니다.");
        }
    }
    public void checkWinningNumDuplication() {
        List<Integer> checking = new ArrayList<>();
        checking = winningNumbers.stream().distinct().collect(Collectors.toList());

        if (winningNumbers.size() != checking.size()) {
            throw new IllegalArgumentException("중복되지 않는 6개의 숫자를 입력해주세요.");
        }
    }
    public void checkWinningNumRangeOver() {
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("범위를 초과한 숫자를 입력하셨습니다. 로또 당첨 번호의 숫자 범위는 1 ~ 45 입니다.");
            }
        }
    }
    public void checkWinningNumAmount() {
        if (winningNumbers.stream().count() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
    }
    public void checkBonusNumDuplication() {
        for (Integer winningNum : winningNumbers) {
            if (bonusNumber == winningNum) {
                throw new IllegalArgumentException("당첨 번호 중에 이미 존재하는 숫자 입니다. 당첨 번호와 중복되지 않는 숫자를 입력해주세요");
            }
        }
    }
    public void checkBonusNumRangeOver() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("범위를 초과한 숫자를 입력하셨습니다. 보너스 번호의 숫자 범위는 1 ~ 45 입니다.");
        }
    }
}
