package lotto.model;

import java.util.List;

public class BonusNumber {
    private final int num;

    public BonusNumber(String num, List<Integer> winningNumber) {
        validate(Integer.parseInt(num), winningNumber);
        this.num = Integer.parseInt(num);
    }

    private void validate(int num, List<Integer> winningNumber) {
        try {
            int parsedNum = Integer.parseInt(String.valueOf(num));
            if (parsedNum > 45 || parsedNum < 1) {
                throw new IllegalArgumentException("보너스 번호는 전부 1에서 45 사이의 수여야 합니다.");
            }
            if (winningNumber.contains(parsedNum)) {
                throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다.");
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력해 주세요.");
        }
    }
    public int getNum() {
        return this.num;
    }
}
