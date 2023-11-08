package lotto.presentation.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.LottoWinningNumbers;
import lotto.presentation.view.View;
import lotto.repository.LottoTicketRepository;
import lotto.service.Referee;
import lotto.util.Rank;

public class LottoGameController {
    private static final String ERROR_MESSAGE_INPUT_BLANK = "아무것도 입력하지 않으셨거나, 공백만으로 이뤄진 값이 있습니다.";
    private static final String ERROR_MESSAGE_INPUT_UNABLE_INTEGER = "정수로 변환 가능한 값을 입력하셔야 합니다.";
    private View view;
    private Referee referee;
    private LottoTicketRepository ticketRepository;
    private PurchaseLogicController purchaseLogicController;
    private WinningNumberController winningNumberController;
    private LottoWinningNumbers lottoWinningNumbers;

    public LottoGameController(View view, Referee referee, LottoTicketRepository ticketRepository) {
        this.view = view;
        this.referee = referee;
        this.ticketRepository = ticketRepository;
        this.purchaseLogicController = new PurchaseLogicController(view, referee, ticketRepository);
        this.winningNumberController = new WinningNumberController(view, referee, ticketRepository);
    }

    public void run() {
        purchaseLogicController.lottoPurchaseLogic();
        lottoWinningNumbers = winningNumberController.lottoWinningNumbersGenerationLogic();
        List<Rank> ranks = referee.calculateRanks(lottoWinningNumbers);
        displayWinningStatistics(ranks);
        Console.close();
    }

    public static String readAndRemoveSpace() {
        return Console.readLine().replaceAll(" ", "");
    }

    public static void isNotBlankValue(final String inputValue) {
        if (inputValue.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_BLANK);
        }
    }

    public static void isNotIntegerValue(final String inputValue) {
        if (!inputValue.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_UNABLE_INTEGER);
        }
    }

    private void displayWinningStatistics(List<Rank> ranks) {
        view.promptForWinningStatistics();
        for (Rank rank : Rank.values()) {
            view.printWinningStatistics(rank, Rank.countRank(ranks, rank));
        }
        double returnRate = referee.calculateReturnRate(ranks);
        view.printReturnRate(returnRate);
    }
}