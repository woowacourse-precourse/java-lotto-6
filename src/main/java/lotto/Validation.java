package lotto;

public class Validation {
    void validateIsNum(String str) {
        if (!str.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    void validateIsThousand(int budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1,000단위로 입력해주세요.");
        }
    }

    void validateIsLottoNumRange(int lottoNum) {
        if (lottoNum < 1 || lottoNum > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
