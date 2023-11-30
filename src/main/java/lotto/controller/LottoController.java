package lotto.controller;

import java.util.List;
import lotto.View.OutputView;
import lotto.constant.constant;
import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.IssuedLottoDataService;
import lotto.service.LottoCalculation;
import lotto.service.LottoDataService;

public class LottoController {
    private LottoDataService lottoDataService = new LottoDataService();
    private IssuedLottoDataService issuedLottoDataService = new IssuedLottoDataService();
    private LottoCalculation lottoCalculation = new LottoCalculation();
    private LottoResult lottoResult;


    Lotto lotto;
    public void play(){
        IssuedLottos issuedLottos = issuedLottoDataService.create_issued_lottos();
        printIssuedLottos(issuedLottos);
        lotto = lottoDataService.create_official_Lotto();
        List<Integer> countWinningLottos =  lottoCalculation.CountWinningLottos(issuedLottos, lotto);
        lottoResult = lottoCalculation.lottoResult(countWinningLottos);
        String yield = lottoCalculation.getYield(issuedLottos.getAmount()* constant.THOUSAND);
        OutputView.printYield(yield);
    }

    private void printIssuedLottos(IssuedLottos issuedLottos){
        for(int i = 0 ; i < issuedLottos.size() ; i++){
            OutputView.printIssuedLottoNumbers(issuedLottos.find_issued_lotto_by_index(i));
        }
    }
}
