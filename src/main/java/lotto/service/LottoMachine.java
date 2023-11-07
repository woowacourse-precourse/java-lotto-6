package lotto.service;

import lotto.console.Output;
import lotto.domain.Grade;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Player;

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

    public static void judgeGrade(LottoGame lottoGame, Player player) {
        Lotto winningNum = lottoGame.getWinningNum();
        Integer bonusNum = lottoGame.getBonusNum();

        List<Lotto> lottoTickets = player.getLottoTickets();

        List<Grade> grades = lottoTickets.stream().map(
                ticket -> Grade.judge(winningNum.matchNumbers(ticket), ticket.matchBonusNum(bonusNum))
        ).toList();

        System.out.println(grades);

        grades.stream()
                .filter(grade -> grade != Grade.NOTHING)
                .forEach( grade -> {
                    player.setState(grade);
                    player.setAsset(grade);
                });
    }
}
