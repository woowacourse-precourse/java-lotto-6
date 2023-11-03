package lotto.Domain;

public class LottoSystem {
    private String lottoWinningNumber;
    private String lottoBonusNumber;
    public LottoSystem(String lottoWinningNumber, String lottoBonusNumber){
        // 예외처리
        this.lottoWinningNumber = lottoWinningNumber;
        this.lottoBonusNumber = lottoBonusNumber;
    }
}
