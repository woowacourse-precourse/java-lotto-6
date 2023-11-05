package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.service.NumberMatchingService;
import lotto.service.EarningRateService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
//    InputView inputView;
    LottoService lottoService;
    private List<List<Integer>> allYourNums;  //////////////
    private List<Integer> winningNumbers; /////////////
    private int ticketCount;
    private int bonusNumber;       /////////
    private static final String ERROR = "[ERROR] ";

    public Controller() {
//        this.inputView = new InputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        lottoTicketSetting();
        showTicketCount();
        lottoGameSetting();
        WinningNumbers winningNumbers = winningNumberSetting();
        BonusNumber bonusNumber = bonusNumberSetting(winningNumbers);
        showSystemMessage();
        showWinningResults();
    }

    private void lottoTicketSetting() {
        while (true) {
            String moneyInput = InputView.inputMoney();
            try {
                LottoTicket lottoTicket = new LottoTicket(moneyInput);
                this.ticketCount = lottoTicket.getTicketCount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private void showTicketCount() {
        OutputView.displayTicket_Count(ticketCount);
    }

    private void lottoGameSetting() {
        List<Lotto> lottoNumber = lottoService.purchaseLottoTickets(ticketCount);
        this.allYourNums = convertToNumbersList(lottoNumber);                       ///////////
        OutputView.displayLottoNumber(lottoNumber);
    }

    private List<List<Integer>> convertToNumbersList(List<Lotto> lottoTickets) {
        // Lotto 객체들을 번호의 리스트로 변환하는 로직
        List<List<Integer>> numbersList = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            numbersList.add(lotto.getNumbers());
        }
        return numbersList;
    }

    private  WinningNumbers winningNumberSetting() {
        while (true) {
            try {
                String[] winningNumbers = InputView.inputWinningNumber();
                this.winningNumbers = convertToIntegerList(winningNumbers);       ////////////
                return new WinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private List<Integer> convertToIntegerList(String[] numberStrings) {            /////////////
        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private BonusNumber bonusNumberSetting(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String bonusNumberString = InputView.inputBonusNumber();
                this.bonusNumber = Integer.parseInt(bonusNumberString); ///////////
                return new BonusNumber(bonusNumberString, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
                // 유효하지 않은 입력에 대한 처리
            }
        }
    }
    private void showSystemMessage() {
        OutputView.displaySystemMessage();
    }

    private void showWinningResults() {
        // NumberMatchingService의 객체 생성 또는 Controller에 멤버 변수로 선언해야 합니다.
        NumberMatchingService numberMatchingService = new NumberMatchingService();

        // 당첨 결과 계산
        EnumMap<LottoPrize, Integer> winCount = numberMatchingService.calculateResults(allYourNums, winningNumbers, bonusNumber);

        // 결과 출력
        OutputView.displayLottoResult(winCount);

        EarningRateService earningRateService = new EarningRateService();
        double earningsRate = earningRateService.calculateEarningsRate(winCount, ticketCount);
        OutputView.displayEarningsRate(earningsRate);
    }
}
