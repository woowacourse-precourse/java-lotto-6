package lotto;

import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    TextView textView = new TextView();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoTicket ticket;
    LottoAnalyzer analyzer;

    public void game() {
        start();
        lottoPrint();
        prizeNumberGet();
        winStatistics();
    }

    private void start() {
        textView.inputPrice();
        String price = inputView.price();
        ticket = new LottoTicket(Integer.parseInt(price));
        System.out.print("\n");
    }

    private void lottoPrint() {
        System.out.printf("%d개를 구매했습니다.\n", ticket.getLottos().size());
        for (int i = 0; i < (ticket.getPrice() / 1000); i++) {
            outputView.lottoNumber(ticket.getLottos().get(i).getNumbers());
        }
        System.out.print("\n");
    }

    private void prizeNumberGet() {
        textView.inputPrizeNum();
        String prize = inputView.prizeNumber();
        String[] prizeNumber = prize.split(",");
        List<String> prizeNum = new ArrayList<>();
        for (int i = 0; i < prizeNumber.length; i++) {
            prizeNum.add(prizeNumber[i]);
        }
        textView.inputBonusNum();
        int bonusNum = Integer.parseInt(inputView.bonusNumber());
        analyzer = new LottoAnalyzer(prizeNum, bonusNum);
        System.out.print("\n");
    }

    private void winStatistics() {
        analyzer.compareLotto(ticket.getLottos());
        outputView.numberOfWins(analyzer.getNumberOfWins());
        analyzer.yieldCalculation(ticket.getPrice());
        outputView.yield(analyzer.getYieldNum());
    }
}
