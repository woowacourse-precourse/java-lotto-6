package lotto.service;

import lotto.console.Output;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    public static void buyLotto(int price){
        int ticketNum = price / 1000;

        List<Lotto> lottoTickets = Stream.generate(LottoGenerate::generate)
                .limit(ticketNum)
                .collect(Collectors.toList());

        Output.printTickets(lottoTickets, ticketNum);
    }

    public static void judgeGrade(Lotto winningNumbers, int bonusNum, Lotto LottoTicket){
        int matchCnt = winningNumbers.matchNumbers(LottoTicket);
        boolean bonusMatch = LottoTicket.matchBonusNum(bonusNum);

        if(matchCnt == 6) {
            Output.printResult(1);
            return;
        }
        if(matchCnt == 5 && bonusMatch) {
            Output.printResult(2);
            return;
        }
        if(matchCnt == 5) {
            Output.printResult(3);
            return;
        }
        if(matchCnt == 4) {
            Output.printResult(4);
            return;
        }
        if(matchCnt == 3) {
            Output.printResult(5);
        }
    }

    public static void increaseIncome(int grade){
        
    }
}
