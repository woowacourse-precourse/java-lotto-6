package lotto.Controller;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.PlayerPrice;
import lotto.Exception.BonusNumberException;
import lotto.Service.LotteryDrawerInputManagerService;
import lotto.Service.PlayerInputManagerService;
import lotto.Service.WinningNumberComparatorService;

public class LottogameController {
    private final PlayerInputManagerService playerInputManagerService = new PlayerInputManagerService();
    private final LotteryDrawerInputManagerService lotteryDrawerInputManagerService = new LotteryDrawerInputManagerService();
    private final WinningNumberComparatorService winningNumberComparatorService = new WinningNumberComparatorService();

    private final BonusNumberException bonusNumberException = new BonusNumberException();

    public void startLottoGame() {
        while (true) {
            try {
                PlayerPrice playerNumber = setPlayerInputNumber();
                Lotto lotto = setDrawerInputNumber();
                compareNumbersWinningAndPlayer(playerNumber, lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public PlayerPrice setPlayerInputNumber() {
        while (true) {
            try {
                return playerInputManagerService.inputPlayerAddInfo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto setDrawerInputNumber() {
        Lotto winningLottoNumbers = null;
        int bonusNumber = 0;
        while (winningLottoNumbers == null) {
            try {
                winningLottoNumbers = new Lotto(inputWinningLottoNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                bonusNumber = inputBonusNumber();
                winningLottoNumbers.setBonusNumber(bonusNumber);
                return winningLottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningLottoNumbers() {
        while (true) {
            try {
                return lotteryDrawerInputManagerService.inputLottoNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                return lotteryDrawerInputManagerService.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void compareNumbersWinningAndPlayer(PlayerPrice playerPrice, Lotto lotto) {
        while (true) {
            try {
                winningNumberComparatorService.winningComparison(playerPrice, lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}