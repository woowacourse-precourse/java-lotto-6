package lotto;

import java.util.List;

public class Validation {
    public void validateIsNum(String str) {
        if (!str.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public void validateIsThousand(int budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1,000단위로 입력해주세요.");
        }
    }

    public void validateIsLottoNumRange(int lottoNum) {
        if (lottoNum < 1 || lottoNum > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateIsSIzeSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 이여야 합니다.");
        }
    }
}
