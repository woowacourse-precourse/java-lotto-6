package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Bonus {
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;

    private final int bonusNumber;

    public Bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int value = Integer.parseInt(Console.readLine());
        validateInRange(value);
        this.bonusNumber = value;
    }


    public boolean isContainBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int containBonusNumber(Lotto lottoNumbers) {
        if (lottoNumbers.getNumbers().contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    private void validateInRange(final int value) {
        if (value < LOTTO_NUMBER_START || value > LOTTO_NUMBER_END) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위가 벗어났습니다.");
        }
    }
}
