package lotto.manager;

import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.utils.LottoReferee;
import lotto.utils.LottoService;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoManager {

    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    private final LottoService lottoService;
    private final LottoReferee lottoReferee;

    public LottoManager() {
        this.lottoInput = new LottoInput();
        this.lottoOutput = new LottoOutput();
        this.lottoService = new LottoService();
        this.lottoReferee = new LottoReferee();
    }

    public void start(){
        int purchasePrice = lottoInput.lottoPurchaseInput();
        LottoResult lottoResult = new LottoResult(purchasePrice);
        lottoResult = lottoService.makeLottoAsPurchaseAndAccumulate(lottoResult);
        lottoOutput.printAllRandomLotto(lottoResult.getLottos());

        WinningLotto winningLotto = lottoInput.winningLottoInput();
        lottoResult.determineAllLottoRank(winningLotto);
        lottoOutput.printLottoStatistics(lottoResult);
    }

    public LottoInput getLottoInput(){
        return lottoInput;
    }

    public LottoOutput getLottoOutput(){
        return lottoOutput;
    }

    public LottoService getLottoService(){
        return lottoService;
    }

    public LottoReferee getLottoReferee(){
        return lottoReferee;
    }
}
