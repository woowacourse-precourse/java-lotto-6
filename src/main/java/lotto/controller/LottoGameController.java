package lotto.controller;

import static lotto.constant.LottoInfo.ONE_LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoRank;
import lotto.model.Player;
import lotto.util.RandomNumberGenerator;
import lotto.view.View;
import lotto.vo.BonusNumber;
import lotto.vo.BuyAmount;
import lotto.vo.TicketCount;

public class LottoGameController {

    private final View view;

    public LottoGameController(View view) {
        this.view = view;
    }

    public void run() {
        BuyAmount buyAmount = initBuyAmount();
        TicketCount ticketCount = initTicketCount(buyAmount);
        Player player = initPlayer(ticketCount);

        showPlayerLottoNumber(player);
        LottoGame lottoGame = initLottoGame(player);
        showResult(ticketCount, lottoGame);
    }

    private BuyAmount initBuyAmount() {
        return view.getBuyAmount();
    }

    private TicketCount initTicketCount(BuyAmount buyAmount) {
        Integer count = buyAmount.amount() / ONE_LOTTO_PRICE.getValue();
        TicketCount ticketCount = new TicketCount(count);
        view.printTicketCountMessage(count);

        return ticketCount;
    }

    private Player initPlayer(final TicketCount ticketCount) {
        return Player.createPlayer(ticketCount, new RandomNumberGenerator());
    }

    private LottoGame initLottoGame(final Player player) {
        Lotto winningLotto = initWinningLotto();
        BonusNumber bonusNumber = initBonusNumber(winningLotto.getNumbers());

        return LottoGame.createGame(player, winningLotto, bonusNumber);
    }

    private Lotto initWinningLotto() {
        return view.getWinningLotto();
    }

    private BonusNumber initBonusNumber(final List<Integer> winningNumbers) {
        return view.getBonusNumber(winningNumbers);
    }

    private void showPlayerLottoNumber(final Player player) {
        view.showPlayerNumbers(LottoDto.toDto(player.getLotteries()));
    }

    private void showResult(final TicketCount ticketCount, final LottoGame lottoGame) {
        Map<LottoRank, Integer> result = lottoGame.calculateScore();
        view.showStatistics(result);
        view.showRateOfProfit(result, ticketCount);
    }
}
