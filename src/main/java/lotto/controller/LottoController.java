package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLottoAmount;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class LottoController {
    public LottoController(){
    }

    private static PlayerLottoAmount playerLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;

    public void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = validateBonus();
    }

    // 발행할 로또 개수의 금액 입력 메소드
    public int inputPlayerAmount(){
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPurchaseAmount());
        return playerLottoAmount.calculateLottoCount();
    }

    // 보너스 번호 검증 하기
    public WinningResult validateBonus() {
        Lotto lotto = new Lotto(InputView.inputLottoWinningNumber());
        List<Integer> winningNumber = lotto.getLottoNumbers();

        int bonus = InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumber, bonus);
        return  new WinningResult(new Lotto(winningNumber), bonus);
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto(){
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }
}
