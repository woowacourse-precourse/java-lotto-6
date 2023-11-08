package lottogame;

import java.util.List;
import lotto.Lotto;
import lottogenerate.LottoGenerator;
import manager.LottoManager;
import print.LottoGameMessagePrinter;
import supervisor.LottoSupervisor;

public class LottoGamePlayer {
    private final LottoManager lottoManager;
    private final LottoGenerator generator;
    private final LottoSupervisor lottoSupervisor;
    public LottoGamePlayer() {
        this.generator = new LottoGenerator();
        this.lottoManager = new LottoManager();
        this.lottoSupervisor = new LottoSupervisor(generator);
    }

    public void gamePlay() {
        int lottoTickets = settingInputTicket();
        generator.generateLotto(lottoTickets);
        printLottoInfo();
        int[] winningNumber = settingInputWinningNum();
        int bonusNumber = settingInputBonusNum();
        printLottoResult(winningNumber, bonusNumber);
    }

    private void printLottoResult(int[] winningNumber, int bonusNumber) {
        // 당첨 통계 및 결과
        LottoGameMessagePrinter.printResultMessage();
        lottoSupervisor.printResultComparingToWinningNumber(winningNumber, bonusNumber);
    }

    private int settingInputBonusNum() {
        // 보너스 번호 입력 및 객체 생성
        LottoGameMessagePrinter.InputBonusNumber();
        int bonusNumber = lottoManager.setInputBonusNumber();
        return bonusNumber;
    }

    private int[] settingInputWinningNum() {
        // 당첨번호 입력 및 객체 생성
        LottoGameMessagePrinter.InputWinningNumber();
        int[] winningNumber = lottoManager.setInputWinningNumbers();
        return winningNumber;
    }

    private void printLottoInfo() {
        List<Lotto> lotto = generator.getLottoList();

        //몇개를 구매했는지 출력 후, 해당 로또의 숫자들을 출력
        LottoGameMessagePrinter.printPurchasedTickets(lotto);
        LottoGameMessagePrinter.printLottoNumbers(lotto);
    }

    private int settingInputTicket() {
        //티켓 값 입력 및 객체 생성
        LottoGameMessagePrinter.InputBuyLottoTicketMessage();
        lottoManager.setInputLottoTicketPrice();
        int lottoTickets = lottoManager.setLottoTicket();
        return lottoTickets;
    }
}
