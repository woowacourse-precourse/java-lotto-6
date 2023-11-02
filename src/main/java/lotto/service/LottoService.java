package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.LottoRanking;
import lotto.dto.LottoResult;
import lotto.model.LottoNumber;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private static LottoService lottoService;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (lottoService == null) {
            lottoService = new LottoService();
        }
        return lottoService;
    }

    public LottoResult compare(List<LottoNumber> lottoNumbers, Lotto lotto) {
        Map<LottoRanking, Integer> winningCounts = new HashMap<>();

        for (LottoRanking lottoRanking : LottoRanking.values()) {
            winningCounts.put(lottoRanking, 0);
        }

        for (LottoNumber lottoNumber : lottoNumbers) {
            LottoRanking lottoRanking = lotto.calculateLottoRanking(lottoNumber);
            winningCounts.put(lottoRanking, winningCounts.getOrDefault(lottoRanking, 0) + 1);
        }

        int originalPrice = calculateOriginalPrice(lottoNumbers);
        double profitRate = calculateProfitRate(winningCounts, originalPrice);

        return new LottoResult(winningCounts, profitRate);
    }

    private double calculateProfitRate(Map<LottoRanking, Integer> winningCounts, int originalPrice) {
        long prizeMoney = 0;
        for (LottoRanking lottoRanking : winningCounts.keySet()) {
            prizeMoney += (long) lottoRanking.getPrizeMoney() * winningCounts.get(lottoRanking);
        }
        return (double) prizeMoney / originalPrice * 100;
    }

    private int calculateOriginalPrice(List<LottoNumber> lottoNumbers) {
        return LOTTO_PRICE * lottoNumbers.size();
    }
}
