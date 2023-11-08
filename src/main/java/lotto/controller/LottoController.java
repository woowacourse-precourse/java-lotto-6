package lotto.controller;public class LottoController {
    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = validateBonus();

        lottoResult(lottoList, winningResult, ticketCount);

    }

    public int inputPlayerAmount() {
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        return playerLottoAmount.calculateLottoCount();
    }

    public WinningResult validateBonus() {
        Lotto lotto = new Lotto(InputView.inputLottoWinningNum());
        List<Integer> winningNumber = lotto.getLottoNumbers();

        int ball = InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumber, ball);
        winningResult = new WinningResult(new Lotto(winningNumber), ball);

        return winningResult;
    }


}
