package lotto.domain;

import lotto.Lotto;
import lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private Lotto lotto;
    private LottoTicketGenerator lottoTicketGenerator;
    private UserInput userInput;
    private UserInputChecker userInputChecker;

    public LottoController() {
        lottoTicketGenerator = new LottoTicketGenerator();
        userInput = new UserInput();
        userInputChecker = new UserInputChecker();
    }

    public enum LottoMessage {
        PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
        PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
        REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        WINNING_STATS_HEADER("당첨 통계 ln ---");

        private String message;

        LottoMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void playGame() {
        List<LottoTicket> userLottoTickets = new ArrayList<>();
        int purchaseAmount = handlePurchaseAmount();

        userLottoTickets = lottoTicketGenerator.generateLottoTicket(purchaseAmount);
        printTickets(userLottoTickets); // 구매한 로또들 번호 출력
    }

    public int handlePurchaseAmount() {
        int ticketCount = 0;
        String input = "";

        System.out.println(LottoMessage.PURCHASE_AMOUNT_MESSAGE.getMessage()); // 구입금액 입력 안내문구 출력
        input = userInput.input();

        int purchaseAmount = userInput.getUserPurchaseAmount(userInputChecker, input);
        ticketCount = purchaseAmount / 1000;
        System.out.println(ticketCount + LottoMessage.PURCHASE_COUNT_MESSAGE.getMessage()); // 구매한 로또 개수 출력

        return purchaseAmount;
    }

    public void printTickets(List<LottoTicket> userLottoTickets) {
        for (LottoTicket ticket : userLottoTickets) {
            ticket.printNumbers();
        }
    }
}
