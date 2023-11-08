package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final LottoHandler lottoHandler = new LottoHandler();

    public int lottoCountForPurchasePrice() {
        int lottoTicket = 0;
        boolean validPrice = false;
        OutputHandler.printMessage("구입금액을 입력해 주세요.");

        while (!validPrice) {
            try {
                lottoTicket = lottoHandler.calculateLottoTicketCount(Console.readLine());
                validPrice = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        OutputHandler.printLineBreakMessage(lottoTicket + "개를 구매했습니다.");
        return lottoTicket;
    }

    public Lotto winningLotto() {
        boolean validWinning = false;
        Lotto winningLotto = null;
        OutputHandler.printLineBreakMessage("당첨 번호를 입력해 주세요.");

        while (!validWinning) {
            try {
                winningLotto = lottoHandler.receiveWinningLotto(Console.readLine());
                validWinning = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        return winningLotto;
    }

    public int bonusNumber() {
        int bonusNumber = 0;
        boolean validBonusNumber = false;
        OutputHandler.printLineBreakMessage("보너스 번호를 입력해 주세요.");

        while (!validBonusNumber) {
            try {
                bonusNumber = lottoHandler.receiveBonusNumber(Console.readLine());
                validBonusNumber = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
