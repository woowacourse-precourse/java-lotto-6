package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void playLotto() {
        Integer numberOfLotto = LottoView.getNumberOfLottoForPrice();
        System.out.println();
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        List<Lotto> lottoList = LottoService.generateLottoList(numberOfLotto);
        LottoView.printLottoList(lottoList);

        Lotto winningNumbers = LottoService.inputWinningNumbers();
        Integer bonusNumber = LottoService.inputBonusNumber(winningNumbers);

        Map<Integer, Integer> rank = LottoService.checkWinning(lottoList, winningNumbers, bonusNumber);

    }
}
