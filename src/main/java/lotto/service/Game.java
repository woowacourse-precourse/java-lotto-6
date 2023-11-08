package lotto.service;

import lotto.controller.Controller;
import lotto.domain.BonusNumber;
import lotto.domain.EnumLotto;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.domain.WinningNumbers;
import lotto.util.Parser;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Controller controller;
    private final LottoRepository lottoRepository;
    private final List<EnumGame> ranks;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private final Input input;

    public Game() {
        lottoRepository = new LottoRepository();
        input = new Input();
        controller = new Controller(this, lottoRepository, input);
        ranks = new ArrayList<>();
    }

    public void run() {
        controller.createLotto();
        winningNumbers = new WinningNumbers(Parser.getSplitLottoNumber(input.inputValidateWinningNumbers()));
        bonusNumber = new BonusNumber(Integer.parseInt(input.inputValidateBonusNumber(winningNumbers.getWinningNumbers())));
        jackpot();
        controller.printLottoGameResult();
    }

    public int[] getRankCount() {
        int[] rankCount = new int[EnumGame.values().length];

        for (EnumGame rank : ranks) {
            rankCount[rank.ordinal()]++;
        }
        return rankCount;
    }

    public double getEarningsRate() {
        int totalPrize = 0;

        for (EnumGame rank : ranks) {
            totalPrize += rank.getMoney();
        }
        return Math.round(getEarningsRateForm(totalPrize) * 100.0) / 100.0;
    }

    private double getEarningsRateForm(int totalPrize) {
        int buyMoney = lottoRepository.getNumberOfLotto() * EnumLotto.LOTTO_PRICE.getNumber();
        return ((double) (totalPrize) / buyMoney) * 100;
    }

    private void jackpot() {
        for (Lotto lotto : lottoRepository.getLottos()) {
            int matchCount = countMatchedNumbers(lotto.getNumbers(), winningNumbers.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
            EnumGame rank = getRankCondition(matchCount, bonusMatch);

            if(rank != null) {
                ranks.add(rank);
            }
        }
    }

    private int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;

        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private EnumGame getRankCondition(int matchCount, boolean bonusMatch) {
        for (EnumGame rankInfo : EnumGame.values()) {
            if (rankInfo.getRank() == matchCount && !rankInfo.isBonus()) {
                return rankInfo;
            }
            if (rankInfo.getRank() == matchCount && rankInfo.isBonus() && bonusMatch) {
                return rankInfo;
            }
        }
        return null;
    }
}
