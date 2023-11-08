package lotto.controller;

import lotto.domain.*;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.ManualNumberStrategy;
import lotto.domain.number.NumberStrategy;
import lotto.domain.number.RandomNumberStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// EnumMap 더 공부!!
// Lotto.getNumber() 사용 좀 없애고 싶다
public class LottoController {
    // 여러 매서드에서 이용하는 전역변수
    // but 전역변수는 결합도 높임. 리팩토링 필요...
    private static List<Lotto> lottoTickets;
    private int lottoTicketAmount;
    private int purchaseMoney;
    private NumberStrategy winningLotto;
    private int bonusNumber; // 얘를 BonusNumber 클래스 책임으로 넘기면 다른 매서드에선 항상 getter로 받아와야 함. 어떻게 리팩토링할까?

    public void run() {
        try {
            LottoGame();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void LottoGame() {
        purchaseLotto(); //로또 구매
        printTickets(); //산 로또 티켓들 출력
        setWinningNumbers(); //당첨번호 세팅
        setBonusNumber(); //보너스넘버 세팅

        LottoDraw lottoDraw = new LottoDraw(lottoTickets); //로또 추첨
        Map<LottoResult, Integer> resultCounts = lottoDraw.extractResult(winningLotto, bonusNumber);
        OutputView.printWinningMessage();
        printResult(resultCounts); //결과 출력

        //수익률 산출
        EarningsRate earningsRate = new EarningsRate();
        OutputView.printEarningsRate(earningsRate.getEarningsRate(purchaseMoney, resultCounts));
    }

    // "에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다" -> while, try-catch문 이용
    private void setBonusNumber() {
        while (true) {
            try {
                bonusNumber = InputView.inputBonusNumber();
                new BonusNumber(winningLotto.generateNumber(), bonusNumber);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void setWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumber = InputView.inputWinningNumbers();
                winningLotto = new ManualNumberStrategy(inputWinningNumber); //파라미터 세팅
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void printTickets() {
        OutputView.printTicketCount(lottoTicketAmount);
        for (Lotto lottoTicket : lottoTickets) {
            OutputView.printTicketList(lottoTicket.getNumbers());
        }
    }

    private void purchaseLotto() {
        while (true) {
            try {
                purchaseMoney = InputView.inputBuyLotto();
                lottoTicketAmount = new TicketCount(purchaseMoney).getTicketCount();
                makeLottoTickets(lottoTicketAmount);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    // stream API 이용하도록 수정
    private void makeLottoTickets(int lottoTicketAmount) {
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        lottoTickets = IntStream.range(0, lottoTicketAmount)
                .mapToObj(i -> randomNumberStrategy.generateNumber())
                .collect(Collectors.toList());
    }

    private void printResult(Map<LottoResult, Integer> resultCounts) {
        for (LottoResult result : LottoResult.values()) {
            Integer count = resultCounts.get(result);
            String description = result.getResultDescription(count);
            OutputView.printText(description);
        }
    }
}
