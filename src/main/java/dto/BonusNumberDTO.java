package dto;

import java.util.List;
import lotto.LottoConfig;

public class BonusNumberDTO {
    private int number;

    public BonusNumberDTO(CommonNumberDTO dto, int bonus) {
        List<Integer> commonNumbers = dto.getNumbers();
        verify(bonus, commonNumbers);
        this.number = bonus;
    }

    private static void verify(int bonus, List<Integer> commonNumbers) {
        if (bonus < LottoConfig.START_NUM || bonus > LottoConfig.END_NUM) {
            throw new IllegalArgumentException("[ERROR] 로또 번호로 적합하지 않은 숫자입니다.");
        }

        if (commonNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 가질 수 없습니다.");
        }
    }


    public int getNumber() {
        return number;
    }
}
