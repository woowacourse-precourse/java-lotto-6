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


    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }


    private static Lotto makeLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }
}
