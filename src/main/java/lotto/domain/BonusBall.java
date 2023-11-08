package lotto.domain;

import java.util.List;

/**
 * @author 민경수
 * @description bonus ball
 * @since 2023.11.06
 **********************************************************************************************************************/
public class BonusBall {

    private final Integer number;

    public BonusBall(Integer number) {
        this.number = number;
    }

    public static BonusBall valueOf(int number) {
        validateRange(number);

        return new BonusBall(number);
    }

    private static void validateRange(int number) {
        if (Lotto.VALID_MIN_NUMBER > number || Lotto.VALID_MAX_NUMBER < number) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 유효범위를 벗어났습니다. 유효범위 : 1 ~ 45");
        }
    }

    public boolean contains(List<Integer> lotto) {
        return lotto.contains(number);
    }

}