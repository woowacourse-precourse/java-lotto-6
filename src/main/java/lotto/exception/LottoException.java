package lotto.exception;

import lotto.domain.LottoEnum;

public class LottoException {

    public boolean checkLottoAmount(String line) {
        return checkGap(line) || checkString(line) || check1000Division(line);
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
}
