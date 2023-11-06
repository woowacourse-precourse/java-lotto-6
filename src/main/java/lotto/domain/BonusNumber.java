package lotto.domain;

public class BonusNumber {
    WinningNumber winningNumbers;
    //상수(static final) 또는 클래스 변수
    private final int BONUS_NUMBER;

    //인스턴스 변수

    //생성자
    public BonusNumber(String bonusNumberInput) {
        Integer bonusNumber = Integer.parseInt(bonusNumberInput);
        compareWinningAndBonus();
        this.BONUS_NUMBER = bonusNumber;
    }

    //메서드
    private void compareWinningAndBonus() {
        // 당첨번호와 보너스번호 중복체크함
        // 중복되면 예외던짐
    }
}
