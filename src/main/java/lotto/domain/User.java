package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

public class User {
    private int purchaseLottoPrice;
    private final List<Lotto> lottos;

    private double rateOfReturn = 0;


    public User(int purchaseLottoPrice, LottoNumberGenerator lottoNumberGenerator) {
        asserValidPrice(purchaseLottoPrice);

        if (Lotto.getPrice() < 0) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다.");
        }

        this.purchaseLottoPrice = purchaseLottoPrice;
        this.lottos = new ArrayList<>();

        for (int i = 0; i < purchaseLottoPrice / Lotto.getPrice(); i++) {
            lottos.add(lottoNumberGenerator.generateLotto());
        }
    }

    public int getPurchaseLottoPrice() {
        return purchaseLottoPrice;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public EnumMap<LottoResult, Integer> getLottoResultsAndSetRateOfReturn(WinningLotto winningLotto) {
        EnumMap<LottoResult, Integer> result = initResult();
        int winningPrice = 0;

        for (Lotto lotto : lottos) {
            Optional<LottoResult> lottoResult = LottoResult.getLottoResult(winningLotto, lotto);

            if (lottoResult.isEmpty()) {
                continue;
            }
            result.put(lottoResult.get(), result.get(lottoResult.get()) + 1);
            winningPrice += lottoResult.get().getPrice();
        }
        this.rateOfReturn = BigDecimal.valueOf(winningPrice).divide(BigDecimal.valueOf(purchaseLottoPrice)).multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP).doubleValue();

        return result;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    private EnumMap<LottoResult, Integer> initResult() {
        EnumMap<LottoResult, Integer> result = new EnumMap(LottoResult.class);
        for (LottoResult lottoResult : LottoResult.values()) {
            result.put(lottoResult, 0);
        }

        return result;
    }

    private void asserValidPrice(int price) {
        if (price % 1000 != 0 || price < 1000) {
            throw new IllegalArgumentException();
        }
    }


}
