package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lottos {
    int numberOfLottos;
    List<Lotto> lottos = new ArrayList<>();
    public Lottos(String purchaseAmount) {
        numberOfLottos = validatePurchaseAmount(purchaseAmount);
        initEachLotto();
    }

    private int validatePurchaseAmount(String purchaseAmount) {
        validateNumber(purchaseAmount);
        return validateDivisibilityByLottoPrice(purchaseAmount);
    }

    private void validateNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_NUMBER.getMessage());
        }
    }

    private int validateDivisibilityByLottoPrice(String purchaseAmount) {
        int purchaseResult = Integer.parseInt(purchaseAmount);
        if(purchaseResult % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CANT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }
        return purchaseResult / 1000;
    }

    private void initEachLotto() {
        for(int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(LottoService.generateRandomLottoNumber()));
        }
    }

    public int getNumberOfLottos() {
        return numberOfLottos;
    }

    public List<List<Integer>> getAllLottoNumbers() {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        for(Lotto lotto : lottos) {
            allLottoNumbers.add(lotto.getNumbers());
        }
        return Collections.unmodifiableList(allLottoNumbers);
    }

    public HashMap<LottoRank, Integer> getLottosResult(FinalWinningNumber finalWinningNumber) {
        HashMap<LottoRank, Integer> rankCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.compareLottoNumberWithFianlWinningNumber(finalWinningNumber);
            rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, 0) + 1);
        }
        return rankCount;
    }
}
