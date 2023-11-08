package lotto.domain;

import lotto.Lotto;
import lotto.LottoTicket;

import java.util.ArrayList;

import java.util.List;

public class LottoController {
    private static Lotto lotto;
    private LottoTicket lottoTicket;
    private LottoOutput lottoOutput;
    private LottoTicketGenerator lottoTicketGenerator;
    private UserInput userInput;
    private UserInputChecker userInputChecker;
    private LottoResultCalculator lottoResultCalculator;

    public LottoController() {
        lottoTicketGenerator = new LottoTicketGenerator();
        userInput = new UserInput();
        userInputChecker = new UserInputChecker();
        lottoOutput = new LottoOutput();
        lottoResultCalculator = new LottoResultCalculator();
    }

    public void playGame() {
        List<LottoTicket> userLottoTickets = new ArrayList<>();
        List<Integer> lottoResults = new ArrayList<>();
        int purchaseAmount = handlePurchaseAmount(); // 구입금액

        userLottoTickets = lottoTicketGenerator.generateLottoTicket(purchaseAmount);
        lottoOutput.printTickets(userLottoTickets); // 구매한 로또들 번호 출력

        lotto = new Lotto(handleWinningNumbers()); // 당첨번호 입력, lotto 객체에 저장
        compareNumbers(userLottoTickets); // 당첨번호와 추첨번호 비교
        compareBonusNumber(userLottoTickets); // 보너스 번호 입력, 2등 로또 확인
        lottoResults = lottoResultCalculator.summarizeLottoResults(); // 각 등수별 몇장이 당첨되었는지 확인
        String totalYield = lottoResultCalculator.calculateTotalYield(lottoResults, purchaseAmount); //수익률 계산
        lottoOutput.printResults(lottoResults, totalYield); // 총 결과 출력
    }

    public void compareBonusNumber(List<LottoTicket> userLottoTickets) { // 2등 확인
        lottoOutput.requestBounsNumbers();
        String input = userInput.input();
        int bonusNumber = 0;

        bonusNumber = userInput.getUserBonusNumber(userInputChecker, input);

        for (LottoTicket lottoTicket : userLottoTickets) {
            if (lottoTicket.getMatchCount() == 5 && lotto.compareBonusNumber(lottoTicket, bonusNumber)) // 5개 일치하고 보너스번호 일치할 경우
                lottoTicket.setMatchCount(6);
        }
    }

    public void compareNumbers(List<LottoTicket> userLottoTickets) {
        int matchCount = 0;
        for (LottoTicket lottoTicket : userLottoTickets) {
            matchCount = lotto.compareWinningNumbers(lottoTicket);
            lottoTicket.setMatchCount(matchCount);
        }
    }

    public List<Integer> handleWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        do {
            lottoOutput.requestWinningNumbers(); // 당첨번호 입력 안내문구 출력
            String input = userInput.input();
            winningNumbers = userInput.getUserWinningNumbers(userInputChecker, input);
        } while (winningNumbers == null);

        return winningNumbers;
    }

    public int handlePurchaseAmount() {
        int purchaseAmount = 0;

        do {
            lottoOutput.purchaseAmountMessage(); // 구입금액 입력 안내문구 출력
            String input = userInput.input();
            purchaseAmount = userInput.getUserPurchaseAmount(userInputChecker, input);
        } while (purchaseAmount == 0);

        int ticketCount = purchaseAmount / 1000;
        lottoOutput.purchaseCountMessage(ticketCount); // 구매한 로또 개수 출력
        return purchaseAmount;
    }
}
