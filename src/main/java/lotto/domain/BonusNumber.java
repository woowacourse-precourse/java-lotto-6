package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BonusNumber {
    WinningNumber winningNumbers;
    //상수(static final) 또는 클래스 변수
    private final int BONUS_NUMBER;

    //인스턴스 변수

    //생성자
    public BonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumberInput = readLine();

        int result = Integer.parseInt(bonusNumberInput);
        compareWinningAndBonus();
        BONUS_NUMBER = bonusNumberInput;
    }

    private int validateFormat(String bonusNumberInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 1개를 입력해주세요.");
        }
        return bonusNumber;
    }

    //메서드
    private void compareWinningAndBonus() {
        // 당첨번호와 보너스번호 중복체크함
        // 중복되면 예외던짐
    }

    public int getBONUS_NUMBER() {
        return BONUS_NUMBER;
    }
}
