package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.dto.LottoDto;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Player;
import lotto.util.RandomNumberGenerator;
import lotto.view.View;
import lotto.vo.BonusNumber;
import lotto.vo.TicketQuantity;

public class LottoGameController {

    private final View view;

    public LottoGameController(View view) {
        this.view = view;
    }

    public void run() {
        TicketQuantity ticketQuantity = initTicketQuantity();
        Player player = initPlayer(ticketQuantity);

        showPlayerLottoNumber(player);

        LottoGame lottoGame = initLottoGame(player);

        showResult(ticketQuantity, lottoGame);
    }

    private TicketQuantity initTicketQuantity() {
        return view.getTicketQuantity();
    }

    private Player initPlayer(final TicketQuantity ticketQuantity) {
        return Player.createPlayer(ticketQuantity, new RandomNumberGenerator());
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

    private void showResult(final TicketQuantity ticketQuantity, final LottoGame lottoGame) {
        Map<LottoRank, Integer> result = lottoGame.calculateScore();
        view.showStatistics(result);
        view.showRateOfProfit(result, ticketQuantity);
    }
}
