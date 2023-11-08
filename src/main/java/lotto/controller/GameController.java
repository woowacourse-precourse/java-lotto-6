package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Winning;

import java.util.List;

import static lotto.service.LottoService.*;
import static lotto.service.LottoService.getWinning;
import static lotto.view.OutView.outputLottoNumber;

public class GameController {
    private List<Lotto> lotto;
    private List<Integer> list;
    private int bonusNumber;

    public GameController() {
        //구매 금액 입력
        setLotto();
        // 티켓 출력
        outputLottoTickets();
        //당첨 번호 입력
        inputWinningNumbers();
        //보너스 번호 입력
        inputBonusNumber();
        //결과 출력
        lottoWinningResult();
    }

    private void setLotto() {
        int amount = setPurchaseAmount();
        lotto = setLottoNumber(amount);
    }

    private void outputLottoTickets() {
        outputLottoNumber(lotto);
    }

    private void inputWinningNumbers() {
        list = lottoNumbers();
    }

    private void inputBonusNumber() {
        bonusNumber = setBonusNumber(list);
    }

    private void lottoWinningResult() {
        Winning winning = getWinning(lotto, list, bonusNumber);
        winning.lottoResult();
        winning.calculateProfitRate(lotto.size());
    }
}
