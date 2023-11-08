package lotto.dto;

public class LottoResultDto {
    private int winningNumberCount;
    private boolean isBonusNumberCorrect;

    public LottoResultDto(int winningNumberCount, boolean isBonusNumberCorrect){
        this.winningNumberCount = winningNumberCount;
        this.isBonusNumberCorrect = isBonusNumberCorrect;
    }

    public int getWinningNumberCount(){
        return winningNumberCount;
    }

    public boolean getIsBonusNumberCorrect(){
        return isBonusNumberCorrect;
    }
}
