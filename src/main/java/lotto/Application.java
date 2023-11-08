package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount=InputView.getPurchaseAmount();
        int numberOfLotto=purchaseAmount/1000;
        OutputView.printNumberOfLotto(numberOfLotto);

        LottoTickets lottoTickets = new LottoTickets();

        for(int i=0;i<numberOfLotto;i++){
            List<Integer> randomNumbers=LottoNumbersMaker.generateRandomNumbers();
            Lotto lottoTicket=new Lotto(new ArrayList<>(randomNumbers));
            lottoTickets.addTicket(lottoTicket);
        }

        for (Lotto lottoTicket: lottoTickets.getTickets()){
            OutputView.printLottoTicketNumbers(lottoTicket);
        }

        Lotto winningNumbers = LottoNumbersMaker.generateWinningNumbers(InputView.getWinningNumbers());
        int bonusNumber=InputView.getBonusNumber(winningNumbers.getNumbers());

        RankChecker rankChecker = new RankChecker(winningNumbers, bonusNumber);

        EnumMap<Rank, Integer> rankCounts=new EnumMap<>(Rank.class);
        int totalPrizeMoney=0;
        for(Lotto lottoTicket: lottoTickets.getTickets()){
            Rank rank = rankChecker.check(lottoTicket);
            if(rank==Rank.NOTHING){
                continue;
            }
            totalPrizeMoney+=rank.getPrizeMoney();
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0)+1);
        }

        OutputView.printResults(rankCounts);
        OutputView.printEarningPercent(totalPrizeMoney, purchaseAmount);

    }
}
