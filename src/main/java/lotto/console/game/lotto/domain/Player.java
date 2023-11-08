package lotto.console.game.lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.console.game.lotto.constants.GameConstants;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int playerMoney;
    private final List<Lotto> lottos;
    private PrizeDetail prizeDetail;

    public Player(int money) {
        this.playerMoney = money;
        this.lottos = new ArrayList<>();
    }

    public void issueLottoTickets() {
        generateLottoTickets(calculateAvailableQuantity());
    }

    private int calculateAvailableQuantity() {
        return playerMoney / GameConstants.LOTTO_TICKET_PRICE;
    }

    private void generateLottoTickets(int quantity) {
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    public int getIssuedQuantity(){
        return lottos.size();
    }

    public List<Lotto> getIssuedLottos() {
        return lottos;
    }

    public void receivePrizeDetail(PrizeDetail prizeDetail) {
        this.prizeDetail = prizeDetail;
    }

    public String exportProfitRate() {
        return String.format("%.1f%%", calculateProfitRate());
    }

    private double calculateProfitRate() {
        double profitRate = (double) prizeDetail.getPrizeMoney() / playerMoney * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
