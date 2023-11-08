package lotto.domain;

public class LottoGame {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private final Lotto winningNumber;
    private final int bonusNumber;

    public LottoGame(Lotto winningNumber, int bonusNumber){
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber(){
        return winningNumber;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }

    private void validate(Lotto winningNumber, int bonusNumber){
        checkBonusNumberRange(bonusNumber);
        checkDuplicate(winningNumber, bonusNumber);
    }

    private void checkBonusNumberRange(int bonusNumber){
        if(bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX){
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(Lotto winningNumber, int bonusNumber){
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

}
