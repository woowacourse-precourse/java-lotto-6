package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.WinningLotto;
import lotto.service.LottoNumbers;
import lotto.service.LottoService;

public class LottoController {

    private static LottoService lottoService;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningLotto winningLotto;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void run() {
        boolean validAmountEntered = false;
        while (!validAmountEntered) {
            try {
                start();
                validAmountEntered = true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("올바른 입력을 다시 시도하세요.");
            }
        }
    }

    public void start() {
        int ticketAmount = InputView.getAmount();
        int lottoCount = OutputView.getLottoCount(ticketAmount);

        lottoList = getLottoList(lottoCount);
        makeWinningNumber();

        winningTotal(lottoList, winningLotto);
    }

    private static List<Lotto> getLottoList(int lottoCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(MakeLottoNumber());
        }
        return lottoList;
    }

    private static Lotto MakeLottoNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.getRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private WinningLotto makeWinningNumber() {
        Lotto lotto = new Lotto(InputView.getWinningNumbersFromUser());
        List<Integer> winningNumber = lotto.getLottoNumbers();

        int bonusNumber = InputView.getBonusNumberFromUser();
        lotto.validateWinningResult(winningNumber, bonusNumber);
        winningLotto = new WinningLotto(new Lotto(winningNumber), bonusNumber);

        return winningLotto;
    }

    // 당첨 통계
    private void winningTotal(List<Lotto> lottoList, WinningLotto winningLotto) {
        OutputView.printResult();
        lottoService.getWinningTotal(lottoList, winningLotto);
    }
}
