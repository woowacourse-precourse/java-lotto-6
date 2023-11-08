package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


public class LottoMachine {
    public static List<Lotto> issuedLotto(long ticketNum){
        return LongStream.range(0, ticketNum)
                .mapToObj(i -> generate())
                .collect(Collectors.toList());
    }

    public static Lotto generate(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers = numbers.stream().sorted().collect(Collectors.toList());

        return new Lotto(numbers);
    }

    public static void judgeGrade(LottoGame lottoGame, Player player) {
        Lotto winningNum = lottoGame.getWinningNum();
        Integer bonusNum = lottoGame.getBonusNum();
        List<Lotto> lottoTickets = player.getLottoTickets();

        List<Grade> grades = lottoTickets.stream().map(
                ticket -> Grade.judge(winningNum.matchNumbers(ticket), ticket.matchBonusNum(bonusNum))
        ).toList();

        player.updatePlayer(grades);
    }
}
