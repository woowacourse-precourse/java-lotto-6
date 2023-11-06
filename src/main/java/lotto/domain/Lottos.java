package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;
import lotto.domain.winningNumber.FinalWinningNumber;
import lotto.service.LottoService;

import java.util.*;

public class Lottos {
    int numberOfLottos;
    List<Lotto> lottos = new ArrayList<>();
    HashMap<LottoRank, Integer> rankCount;

    public Lottos(String purchaseAmount) {
        numberOfLottos = validate(purchaseAmount);
        initEachLotto();
        initRankCount();
    }

    private int validate(String purchaseAmount) {
        validateNumber(purchaseAmount);
        return validateDivisibilityByLottoPrice(purchaseAmount);
    }

    private void validateNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    private int validateDivisibilityByLottoPrice(String purchaseAmount) {
        int purchaseResult = Integer.parseInt(purchaseAmount);
        if(purchaseResult % LottoRule.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_AMOUNT.getMessage());
        }
        return purchaseResult / LottoRule.LOTTO_PRICE.getNumber();
    }

    private void initEachLotto() {
        for(int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(LottoService.generateRandomLottoNumber()));
        }
    }

    private void initRankCount() {
        rankCount = new LinkedHashMap<>();
        for(LottoRank lottoRank : LottoRank.values()) {
            rankCount.put(lottoRank, 0);
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
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.compareLottoNumberWithFinalWinningNumber(finalWinningNumber);
            rankCount.put(lottoRank, rankCount.get(lottoRank) + 1);
        }
        rankCount.remove(LottoRank.OUT_OF_RANK);
        return rankCount;
    }

    public double calculateTotalRateOfReturn() {
        double totalSum = 0;
        for(LottoRank lottoRank : rankCount.keySet()) {
            totalSum += lottoRank.getValue() * rankCount.get(lottoRank);
        }
        return totalSum / (numberOfLottos * LottoRule.LOTTO_PRICE.getNumber()) * 100;
    }
}
