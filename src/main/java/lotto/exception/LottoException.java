package lotto.exception;

import lotto.Service.InputService;
import lotto.domain.LottoEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoException {

    private final InputService inputService = new InputService();

    private final Integer LOTTO_SIZE = 6;

    public boolean checkLottoAmount(String line) {
        return checkGap(line) || checkString(line) || check1000Division(line);
    }

    public boolean checkWinningNum(String line) {
        return checkGap(line) || checkStringList(line) || check6Num(line) || check1To45(line) || checkDuplicated(line);
    }

    public boolean checkBonusNum(String line, List<Integer> winningNum) {
        return checkGap(line) || checkString(line) || check1To45(line) || checkDuplicatedBonus(line, winningNum);
    }


    private boolean checkGap(String line) {
        try {
            if (line.isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 공백을 입력 받았습니다. 다시 입력 해 주세요.");
            return true;
        }
        return false;
    }

    private boolean checkString(String line) {
        try {
            if (!line.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 문자를 입력 받았습니다. 다시 입력 해 주세요.");
            return true;
        }
        return false;
    }

    private boolean checkStringList(String line) {
        try {
            inputService.isString(line);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 문자를 입력 받았습니다. 다시 입력 해 주세요.");
            return true;
        }
        return false;
    }

    private boolean check1000Division(String line) {
        try {
            if (Integer.parseInt(line) % LottoEnum.LOTTO_PRICE.getStatus() != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000으로 나누어 떨어지지 않는 숫자를 입력 받았습니다. 다시 입력 해 주세요");
            return true;
        }
        return false;
    }

    private boolean check6Num(String line) {
        try {
            if (inputService.getStringToList(line).size() != LOTTO_SIZE) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 6개가 아닌 숫자를 입력 받았습니다. 다시 입력 해 주세요");
            return true;
        }
        return false;
    }

    private boolean check1To45(String line) {
        try {
            List<Integer> winningNum = inputService.getStringToList(line);
            if (inputService.is1To45(winningNum)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1~45 사이의 숫자가 아닌 수를 입력 받았습니다. 다시 입력 해 주세요");
            return true;
        }
        return false;
    }

    private boolean checkDuplicated(String line) {
        try {
            List<Integer> winningNum = inputService.getStringToList(line);
            Set<Integer> winningNumSet = new HashSet<>(winningNum);
            if (winningNum.size() > winningNumSet.size()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 중복된 숫자를 입력 받았습니다. 다시 입력 해 주세요");
            return true;
        }
        return false;
    }

    private boolean checkDuplicatedBonus(String line, List<Integer> winningNum) {
        try {
            Integer bonusNum = inputService.getBonusNum(line);
            if (winningNum.contains(bonusNum)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 기존 당첨 번호와 중복된 숫자를 입력 받았습니다. 다시 입력 해 주세요.");
            return true;
        }
        return false;
    }
}
