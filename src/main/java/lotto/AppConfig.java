package lotto;

import lotto.controller.*;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class AppConfig {

    public CountWinLotto countWinLotto(){
        return new CountWinLottoImpl();
    };
    public GetBuyNumber getBuyNumber(){
        return new GetBuyNumberImpl(inputView());
    }
    public GetMyLottos getMyLottos(){
        return new GetMyLottosImpl();
    }
    public GetWinLotto getWinLotto(){
        return new GetWinLottoImpl(inputView());
    }
    public OutputView outputView(){
        return new OutputViewImpl();
    }
    public InputView inputView(){
        return new InputViewImpl();
    }
    public PlayLotto playLotto(){
        return new PlayLottoImpl(countWinLotto(),getBuyNumber(),getMyLottos(),getWinLotto(),outputView());
    }

}
