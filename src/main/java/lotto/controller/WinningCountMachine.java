package lotto.controller;

import lotto.model.*;

import java.util.*;

public class WinningCountMachine {
    public WinningDetail maketWinningDetail(WinningLotto winningLotto, MyLotto myLotto) {
        WinningDetail winningDetail = new WinningDetail();
        Map<Integer, Integer> numberOfCorrectLottoInfo = makeNumberOfCorrectLottoInfo(
                winningLotto.getLotto(), myLotto.getLottos());
        Integer numberOfWinningBonusLotto = countWinningBonusLotto(
                winningLotto.getLotto(), winningLotto.getBonusNumber(), myLotto.getLottos());
        numberOfCorrectLottoInfo.put(
                Winning.FIFTH.getNeedCorrectNumber(),
                numberOfCorrectLottoInfo.get(Winning.FIFTH.getNeedCorrectNumber()) - numberOfWinningBonusLotto);
        for (Map.Entry<Integer, Integer> entry : numberOfCorrectLottoInfo.entrySet()) {
            makeWinningInfo(winningDetail, numberOfCorrectLottoInfo, entry.getKey());
        }
        winningDetail.add(new CountOfCorrectLotto(Winning.BONUS, numberOfWinningBonusLotto));
        winningDetail.sort();
        return winningDetail;
    }

    private Map<Integer, Integer> makeNumberOfCorrectLottoInfo(Lotto winningLotto, List<Lotto> myLottos) {
        Map<Integer, Integer> numberOfCorrectLottoInfo = new HashMap<>();
        for(Winning winning : Winning.values()){
            numberOfCorrectLottoInfo.put(winning.getNeedCorrectNumber(), 0);
        }
        for (Lotto myLotto : myLottos) {
            Integer numberOfCorrectNumberInLotto = getNumberOfCorrectNumberInLotto(winningLotto, myLotto);
            if(numberOfCorrectNumberInLotto >= 3){
                numberOfCorrectLottoInfo.put(numberOfCorrectNumberInLotto, numberOfCorrectLottoInfo.get(numberOfCorrectNumberInLotto)+1);
            }
        }
        return numberOfCorrectLottoInfo;
    }

    private Integer getNumberOfCorrectNumberInLotto(Lotto winningLotto, Lotto myLotto) {
        Set<Integer> intersection = new HashSet<>(winningLotto.getNumbers());
        intersection.retainAll(new HashSet<>(myLotto.getNumbers()));
        return intersection.size();
    }

    private Integer countWinningBonusLotto(Lotto winningLotto, Integer bonusNumber, List<Lotto> myLottos) {
        int numberOfWinningBonus = 0;
        for (Lotto myLotto : myLottos) {
            if (isWinningBonus(winningLotto, bonusNumber, myLotto)) {
                numberOfWinningBonus += 1;
            }
        }
        return numberOfWinningBonus;
    }

    private boolean isWinningBonus(Lotto winningLotto, Integer bonusNumber, Lotto myLotto) {
        Set<Integer> intersection = new HashSet<>(myLotto.getNumbers());
        intersection.retainAll(new HashSet<>(winningLotto.getNumbers()));
        Set<Integer> difference = new HashSet<>(myLotto.getNumbers());
        difference.removeAll(winningLotto.getNumbers());
        return intersection.size() == Winning.BONUS.getNeedCorrectNumber() && difference.contains(bonusNumber);
    }

    private void makeWinningInfo(WinningDetail winningDetail, Map<Integer, Integer> numberOfCorrectLottoInfo, Integer key) {
        if (Objects.equals(key, Winning.THIRD.getNeedCorrectNumber())) {
            winningDetail.add(new CountOfCorrectLotto(Winning.THIRD, numberOfCorrectLottoInfo.get(key)));
        } else if (Objects.equals(key, Winning.FORTH.getNeedCorrectNumber())) {
            winningDetail.add(new CountOfCorrectLotto(Winning.FORTH, numberOfCorrectLottoInfo.get(key)));
        } else if (Objects.equals(key, Winning.FIFTH.getNeedCorrectNumber())) {
            winningDetail.add(new CountOfCorrectLotto(Winning.FIFTH, numberOfCorrectLottoInfo.get(key)));
        } else if (Objects.equals(key, Winning.SIX.getNeedCorrectNumber())) {
            winningDetail.add(new CountOfCorrectLotto(Winning.SIX, numberOfCorrectLottoInfo.get(key)));
        }
    }
}
