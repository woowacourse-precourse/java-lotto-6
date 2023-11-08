package lotto.domain;

import static lotto.domain.ValidateUtil.toNumeric;

import java.util.LinkedHashMap;
import java.util.List;


public class LottoStore {

    private List<Lotto> userLottoTickets;
    private int lottoPurchase;
    private Lotto winningNumbers;
    private int bonusNumber;
    LinkedHashMap<LottoRank, Integer> lottoResults = new LinkedHashMap<>();
    private static final String AVERAGE_REWARD_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String UNIT_OF_QUANTITY = "개\n";
    private static final float PERCENTAGE = 100;
    private static final int INITIAL_REWARD = 0;


    public void buyLottoTickets(String lottoPurchaseRequest) {
        lottoPurchase = toNumeric(lottoPurchaseRequest);
        this.userLottoTickets = LottoStoreClerk.createLottoTickets(lottoPurchase);
    }

    public void noticeWinningNumber(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void makeLottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.put(rank, 0);
        }
        for (Lotto userLottoTicket : userLottoTickets) {
            findWinningTicket(userLottoTicket);
        }
    }

    private void findWinningTicket(Lotto userLottoTicket) {
        LottoRecord lottoRecord = userLottoTicket.winCheck(winningNumbers, bonusNumber);
        if (lottoRecord.getRank() != null) {
            lottoResults.put(lottoRecord.getRank(), lottoResults.get(lottoRecord.getRank()) + 1);
        }
    }

    public String makeLottoReceipt() {
        makeLottoResult();
        String lottoReceipt = addAverageRewardAtLottoReceipt(toStringLottoResult());
        return lottoReceipt;
    }

    private String addAverageRewardAtLottoReceipt(StringBuilder lottoReceipt) {
        int reward = INITIAL_REWARD;
        for (LottoRank rank : LottoRank.values()) {
            reward += rank.getReward() * lottoResults.get(rank);
        }
        float averageReward = (float) reward / lottoPurchase * PERCENTAGE;
        lottoReceipt.append(String.format(AVERAGE_REWARD_MESSAGE, averageReward));
        return lottoReceipt.toString();
    }

    private StringBuilder toStringLottoResult() {
        StringBuilder lottoReceipt = new StringBuilder();
        for (LottoRank rank : LottoRank.values()) {
            lottoReceipt.append(rank.getRankMessage());
            lottoReceipt.append(lottoResults.get(rank));
            lottoReceipt.append(UNIT_OF_QUANTITY);
        }
        return lottoReceipt;
    }

    public List<Lotto> getUserLottoTickets() {
        return userLottoTickets;
    }
}