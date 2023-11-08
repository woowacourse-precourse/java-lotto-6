package lotto.winningLotto.domain;

public class WinningLottoService {

    public WinningLotto createWinningLotto(LottoNumber lottoNumber,LottoBonusNumber lottoBonusNumber){
        return new WinningLotto(lottoNumber,lottoBonusNumber);
    }
}
