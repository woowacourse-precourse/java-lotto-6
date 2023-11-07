package lotto;

import java.util.List;

public class Run {

    private static ViewInput viewInput = new ViewInput();
    private static ViewOutput viewOutput = new ViewOutput();
    private static Game game = new Game();
    private static Computer computer = new Computer();

    public void run() {
        // 유저 생성
        User user = new User();

        // 구입금액 입력
        int purchaseAmount = viewInput.getPurchaseAmount();
        user.setPurchaseAmount(purchaseAmount);
        user.setLottoList(computer.makeLottoList(purchaseAmount/1000));

        viewOutput.showLottoList(user.getLottoList());

        List<Integer> winningNumbers = viewInput.getWinningNumbers();
        int bonusNumber = viewInput.getBonusNumber(winningNumbers);

        user.setWinningStatistics(game.checkAllLotto(user.getLottoList(), winningNumbers, bonusNumber));
        int totalReturn = game.getTotalReturn(user.getWinningStatistics());

        user.setTotalReturnPercentage(totalReturn);

        viewOutput.showWinningStatistics(user.getWinningStatistics());
        viewOutput.showTotalReturnPercentage(user.getTotalReturnPercentage());
    }
}
