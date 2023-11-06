package lotto.service;

import lotto.console.Output;
import lotto.domain.Grade;
import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    public static List<Lotto> buyLotto(Float price){
        long ticketNum = (long) (price / 1000);

        List<Lotto> lottoTickets = Stream.generate(LottoGenerate::generate)
                .limit(ticketNum)
                .collect(Collectors.toList());

        Output.printTickets(lottoTickets, ticketNum);

        return lottoTickets;
    }

    public static void judgeGrade(Lotto winningNumbers, int bonusNum, Lotto LottoTicket) {
        int matchCnt = winningNumbers.matchNumbers(LottoTicket);
        boolean bonusMatch = LottoTicket.matchBonusNum(bonusNum);

        Grade grade = Grade.judge(matchCnt, bonusMatch);

        if(grade != Grade.NOTHING){
            Execute.state.setGradeState(grade);
            Execute.asset.increaseIncome(grade);
        }
    }
}
