package lotto.domain;

public class LottoGame {
    private final Lotto winningNum;
    private final Integer bonusNum;

    public LottoGame(Lotto winningNum, Integer bonusNum){
        this.winningNum = winningNum;
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateBonusNum(Integer bonusNum){
        if(bonusNum < 0 || 45 < bonusNum){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
        }
    }
    public Lotto getWinningNum(){
        return winningNum;
    }

    public Integer getBonusNum(){
        return bonusNum;
    }
}
