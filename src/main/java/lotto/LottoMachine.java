package lotto;

import java.util.*;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_NEED_TO_DIVIDE_BY_PRICE = "[ERROR] 로또 구입 금액은 로또 가격의 배수여야 합니다. 로또 가격 : " + LOTTO_PRICE;

    private final int purchaseMoney;
    private final List<Lotto> lottoTickets;

    public LottoMachine(int purchaseMoney) {
        validateCanBuy(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
        this.lottoTickets = purchase(calculateLottoCount(purchaseMoney));
    }

    public LottoResult calculatePrize(WinningLotto winningLotto) {
        List<LottoRank> ranks = new ArrayList<>();
        for (Lotto lottoTicket : lottoTickets) {
            Optional<LottoRank> lottoRank = winningLotto.calculateRank(lottoTicket);
            lottoRank.ifPresent(ranks::add);
        }

        int earnMoney = 0;
        Map<LottoRank, Integer> rankToCount = new HashMap<>();
        for (LottoRank rank : ranks) {
            rankToCount.put(rank, rankToCount.getOrDefault(rank, 0) + 1);
            earnMoney += rank.getWinningMoney();
        }

        return new LottoResult(purchaseMoney, earnMoney, rankToCount);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    private List<Lotto> purchase(int lottoCount) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            purchasedLotto.add(new Lotto());
        }
        return purchasedLotto;
    }

    private void validateCanBuy(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_NEED_TO_DIVIDE_BY_PRICE);
        }
    }

    private int calculateLottoCount(int purchaseMoney) {
        return purchaseMoney / LOTTO_PRICE;
    }
}
