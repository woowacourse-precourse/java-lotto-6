package domain;

public class WinningLotto { // 싱글톤 패턴으로 관리

    private static WinningLotto defaultWinningLotto;
    private Lotto numbers;
    private Integer bonusNumber;

    private WinningLotto() {
    }

    public static WinningLotto getInstance() {
        if(defaultWinningLotto == null) {
            defaultWinningLotto = new WinningLotto();
        }
        return defaultWinningLotto;
    }

    public void setNumbers(Lotto lotto) {
        numbers = lotto;
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if(numbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
        }
    }

}
