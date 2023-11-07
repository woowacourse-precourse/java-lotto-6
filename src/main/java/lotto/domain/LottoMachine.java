package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.console.Output;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


public class LottoMachine {
    public static List<Lotto> issuedLotto(Float price){
        long ticketNum = (long) (price / 1000);

        List<Lotto> lottoTickets = LongStream.range(0, ticketNum)
                .mapToObj(i -> generate())
                .collect(Collectors.toList());

        Output.printTickets(lottoTickets, ticketNum);

        return lottoTickets;
    }
    public static Lotto generate(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
    public static void judgeGrade(LottoGame lottoGame, Player player) {
        Lotto winningNum = lottoGame.getWinningNum();
        Integer bonusNum = lottoGame.getBonusNum();

        List<Lotto> lottoTickets = player.getLottoTickets();

        List<Grade> grades = lottoTickets.stream().map(
                ticket -> Grade.judge(winningNum.matchNumbers(ticket), ticket.matchBonusNum(bonusNum))
        ).toList();

        grades.stream()
                .filter(grade -> grade != Grade.NOTHING)
                .forEach( grade -> {
                    player.setState(grade);
                    player.setAsset(grade);
                });
    }
}
