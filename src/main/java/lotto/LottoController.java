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
    }

    private void lottoPrint() {
        System.out.printf("%d개를 구매했습니다.\n", ticket.getLottos().size());
        for (int i = 0; i < ticket.getLottos().size(); i++) {
            outputView.lottoNumber(ticket.getLottos().get(i).getNumbers());
        }
    }

    private void prizeNumberGet() {
        String[] prizeNumber = inputView.prizeNumber().split(",");
        List<String> prizeNum = new ArrayList<>();
        for (int i = 0; i < prizeNumber.length; i++) {
            prizeNum.add(prizeNumber[i]);
        }
        int bonusNum = Integer.parseInt(inputView.bonusNumber());
        analyzer = new LottoAnalyzer(prizeNum, bonusNum);
    }

    private void winStatistics() {
        analyzer.compareLotto(ticket.getLottos());
        outputView.numberOfWins(analyzer.getNumberOfWins());
        analyzer.yieldCalculation(ticket.getPrice());
        outputView.yield(analyzer.getYieldNum());
    }
}
