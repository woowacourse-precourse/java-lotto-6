package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.List;
import java.util.Map;

import static lotto.service.LottoService.generateLottoList;

public class LottoController {
    public static void playLotto() {
        Integer numberOfLotto = LottoView.getNumberOfLottoForPrice();
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        List<Lotto> lottoList = generateLottoList(numberOfLotto);
        LottoView.printLottoList(lottoList);

        Lotto winningNumbers = LottoService.inputWinningNumbers();
        Integer bonusNumber = LottoService.inputBonusNumber(winningNumbers);

        Map<Integer, Integer> rank = LottoService.checkWinning(lottoList, winningNumbers, bonusNumber);
        LottoView.printResult(rank);

        Double rateOfReturn = LottoService.calculateReturnRate(numberOfLotto, rank);
        LottoView.printRateOfReturn(rateOfReturn);

    }
}
