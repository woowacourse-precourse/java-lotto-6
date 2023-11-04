package lotto.service;

import lotto.dto.PurchaseResult;
import lotto.util.RandomNumbersGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private static final LottoService instance = new LottoService();

    public static LottoService getInstance() {
        return instance;
    }

    private LottoService() {
    }

    public List<PurchaseResult> purchaseLottos(int purchaseLottoAmount) {
        return Stream.generate(() -> new PurchaseResult(RandomNumbersGenerator.generate()))
                .limit(purchaseLottoAmount)
                .collect(Collectors.toList());
    }
}
