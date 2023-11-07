package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.User;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoService {

    private final User user;

    private final WinningNumber winningNumber;

    private final LottoResult lottoResult;

    public LottoService(User user, WinningNumber winningNumber, LottoResult lottoResult) {
        this.user = user;
        this.winningNumber = winningNumber;
        this.lottoResult = lottoResult;
    }

    public void buyLottoTickets() {
        user.inputMoney();
        user.createLottoTickets();
    }

    public int getTicketCount() {
        return user.getMoney() / 1000;
    }


    public List<Lotto> getLottoTickets() {
        return user.getLottoTickets();
    }

    public void inputWinnerNumbers() {
        winningNumber.inputWinnerNumbers();
    }

    public void inputBonusNumber() {
        winningNumber.inputBonusNum();
    }

    public void lottoResultAddPrizes() {
        user.getLottoTickets().forEach(lotto -> {
            int matchesNumber = countMatchingNumbers(lotto, winningNumber);
            boolean bonusNumber = isBonusNumber(lotto, winningNumber, matchesNumber);
            lottoResult.addPrize(LottoPrize.getLottoPrizeByMatchesNumber(matchesNumber, bonusNumber));
        });
    }

    public String getPrizeDescription(int prize) {
        return lottoResult.getPrizeDescription(prize);
    }

    public double getRevenue() {
        return user.getRevenue(lottoResult.getPrizeMoney());
    }

    private int countMatchingNumbers(Lotto lotto, WinningNumber winningNumber) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumber.getWinnerNumbers()::contains)
                .count();
    }

    private boolean isBonusNumber(Lotto lotto, WinningNumber winningNumber, int matchesNumber) {
        boolean bonusNum = lotto.getNumbers().stream()
                .anyMatch(num -> num == winningNumber.getBonusNumber());
        return matchesNumber == 5 && bonusNum;
    }

}
