package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoController {
    private static int amount;
    private static Lotto winningLotto;
    private static int bonusNumber;

    List<Lotto> lottos = new ArrayList<>();

    public void start() {
        getLottoAmount();
        getLottos();
        getWinningLotto();
        getBonusNumber();
        getLottoResults(winningLotto.getNumbers(), lottos, bonusNumber);
    }

    private void getLottos() {
        RandomNumbers randomNumbers = new RandomNumbers();
        for (int i = 0; i < amount / 1000; i++) {
            Lotto lotto = new Lotto(randomNumbers.getRandomNumbers());
            lottos.add(lotto);
        }
        OutputView.IssuedLottoNumbers(amount, lottos);
    }

    private void getLottoAmount() {
        try{
            LottoAmount lottoAmount = new LottoAmount(InputView.purchaseAmount());
            amount = lottoAmount.getAmount();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getLottoAmount();
        }
    }

    private void getWinningLotto() {
        try{
            Lotto lotto = new Lotto(lottoStringtoIntegerList());
            winningLotto = lotto;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getWinningLotto();
        }
    }

    private List<Integer> lottoStringtoIntegerList() {
        Lotto lotto = new Lotto(InputView.winningNumber());
        return lotto.getNumbers();
    }

    private void getBonusNumber() {
        try{
            BonusNumber bonus = new BonusNumber(InputView.bonusNumber(), winningLotto.getNumbers());
            bonusNumber = bonus.getBonusNumber();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getBonusNumber();
        }
    }

    public Map<LottoResultFormat, Integer> getLottoResults(List<Integer> winningNumbers, List<Lotto> lottos, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        int matchCount = 0;

        for (Lotto lotto : lottos) {
            matchCount = (int) lotto.getNumbers().stream()
                    .filter(o -> winningNumbers.stream().anyMatch(Predicate.isEqual(o)))
                    .count();

            if (matchCount < 3) {
                matchCount = 0;
            }

            lottoResult.addHashMap(matchCount, isMatchBonus(lotto, bonusNumber));
        }
        OutputView.LottoResults(lottoResult.getLottoResultHashMap());

        calculateReturnOnLotto(lottoResult.getLottoResultHashMap(), amount);
        return lottoResult.getLottoResultHashMap();
    }

    private boolean isMatchBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public double calculateReturnOnLotto(Map<LottoResultFormat, Integer> lottoResults, int amount) {
        double returnOfLotto = 0;
        for (LottoResultFormat key : lottoResults.keySet()) {
            returnOfLotto += lottoResults.getOrDefault(key, 0) * key.getWinningAmount();
        }
        OutputView.totalReturnOnLotto(returnOfLotto / amount * 100);
        return returnOfLotto / amount * 100;
    }

}
