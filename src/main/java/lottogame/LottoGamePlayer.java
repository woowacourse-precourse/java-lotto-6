package lottogame;

import java.util.List;
import lotto.Lotto;
import lottogenerate.LottoGenerator;
import manager.LottoManager;
import print.LottoGameMessagePrinter;
import supervisor.LottoSupervisor;

public class LottoGamePlayer {
    private LottoManager lottoManager;
    private LottoGenerator generator;
    private LottoSupervisor lottoSupervisor;
    public LottoGamePlayer() {
        this.generator = new LottoGenerator();
        this.lottoManager = new LottoManager();
        this.lottoSupervisor = new LottoSupervisor(generator);
    }

    public void gamePlay() {
        //티켓 값 입력 및 객체 생성
        LottoGameMessagePrinter.InputBuyLottoTicketMessage();
        lottoManager.setInputLottoTicketPrice();
        int lottoTickets = lottoManager.setLottoTicket();

        // 해당 메서드가 호출이 되어야 Lotto 객체가 생성됨.
        generator.generateLotto(lottoTickets);
        // 로또 객체가 생성 되었으니 로또 리스트를 가지고옴
        List<Lotto> lotto = generator.getLottoList();

        //몇개를 구매했는지 출력 후, 해당 로또의 숫자들을 출력
        LottoGameMessagePrinter.printPurchasedTickets(lotto);
        LottoGameMessagePrinter.printLottoNumbers(lotto);


        // 당첨번호 입력 및 객체 생성
        LottoGameMessagePrinter.InputWinningNumber();
        int[] winningNumber = lottoManager.setInputWinningNumbers();


        // 보너스 번호 입력 및 객체 생성
        LottoGameMessagePrinter.InputBonusNumber();
        int bonusNumber = lottoManager.setInputBonusNumber();

        // 당첨 통계 및 결과
        LottoGameMessagePrinter.printResultMessage();
        lottoSupervisor.compareToWinningNumber(winningNumber, bonusNumber);

    }
}
