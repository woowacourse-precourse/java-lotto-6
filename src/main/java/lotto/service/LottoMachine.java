package lotto.service;

import lotto.console.Output;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    public static void buyLotto(int price){
        int ticketNum = price / 1000;

        List<Lotto> lottoTickets = Stream.generate(LottoGenerate::generate)
                .limit(ticketNum)
                .collect(Collectors.toList());

        Output.printTickets(lottoTickets, ticketNum);
    }

    public static void judgeGrade(Lotto winningNumbers, Lotto LottoTicket){
        int matchCnt = winningNumbers.matchNum(LottoTicket);
    }

}
