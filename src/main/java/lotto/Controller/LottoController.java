package lotto.controller;

import static lotto.controller.UserInputMessage.*;
import static lotto.util.RandomNumberGenerator.generateRandomNumbers;
import static lotto.util.WinningNumbersMaker.makeWinningNumbers;
import static lotto.util.EarningsCalculator.calculateEarningsRate;
import static lotto.validator.Validator.isBonusNumberDuplicate;
import static lotto.validator.Validator.isBonusNumberValid;
import static lotto.validator.Validator.isPurchaseAmountValid;
import static lotto.validator.Validator.isWinningNumberValid;


import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.Judge;
import lotto.domain.LottoRankCount;
import lotto.domain.LottoResult;


public class LottoController {
    public static final int LOTTO_PRICE = 1000;
    private static final LottoResult OUT_OF_RANK = null;

    int purchaseAmount;
    int totalEarnings;
    Lotto lottoWinningNumbers;
    LottoBonus lottoBonusNumber;
    List<Lotto> lottoRandomNumbers;
    LottoRankCount lottoRankCount;

    {
        lottoRandomNumbers = new ArrayList<>();
        lottoRankCount = new LottoRankCount();
    }


    public LottoController() {
    }

    public void start() {
        requestLottoPurchaseAmount();
        printOutRandomNumbers();

        requestWinningNumbers();
        requestBonusNumber();

        calculateEarnings();
    }

    public void requestLottoPurchaseAmount() {
        System.out.println(REQUEST_LOTTO_PURCHASE_AMOUNT);
        String userInput = Console.readLine();
        try {
            isPurchaseAmountValid(userInput);
            purchaseAmount = Integer.parseInt(userInput);
            System.out.println();
        } catch (Exception error) {
            System.out.println(error.getMessage());
            requestLottoPurchaseAmount();
        }
    }

    public void printOutRandomNumbers() {
        int lottoTicket = purchaseAmount / LOTTO_PRICE;
        System.out.printf(LOTTO_TICKETS_PURCHASED_MESSAGE, lottoTicket);
        System.out.println();
        generateLottoRandomNumbers(lottoTicket);
        for (Lotto randomNumber : lottoRandomNumbers) {
            System.out.println(randomNumber);
        }
        System.out.println();
    }

    public void generateLottoRandomNumbers(int lottoTicket) {
        for (int i = 0; i < lottoTicket; i++) {
            Lotto randomNumbers = new Lotto(generateRandomNumbers(lottoTicket));
            lottoRandomNumbers.add(randomNumbers);
        }
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        String userInput = Console.readLine();
        try {
            isWinningNumberValid(userInput);
            lottoWinningNumbers = makeWinningNumbers(userInput);
            System.out.println();
        } catch (Exception error) {
            System.out.println(error.getMessage());
            requestWinningNumbers();
        }
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String userInput = Console.readLine();
        try {
            isBonusNumberValid(userInput);
            int bonusNumber = Integer.parseInt(userInput);
            isBonusNumberDuplicate(lottoWinningNumbers.getNumbers(), bonusNumber);
            lottoBonusNumber = new LottoBonus(bonusNumber);
            System.out.println();
        } catch (Exception error) {
            System.out.println(error.getMessage());
            requestBonusNumber();
        }
    }

    public void calculateEarnings() {
        for (Lotto randomNumbers : lottoRandomNumbers) {
            LottoResult lottoResult = findRank(randomNumbers);
            if (lottoResult != OUT_OF_RANK) {
                totalEarnings += lottoResult.getLottoWinningAmount();
            }
        }
    }

    public void calculateRank() {
        for (Lotto randomNumbers : lottoRandomNumbers) {
            LottoResult lottoResult = findRank(randomNumbers);
            if (lottoResult != OUT_OF_RANK) {
                int currentRank = lottoResult.getRank();
                lottoRankCount.incrementCount(currentRank);
            }
        }
    }

    public LottoResult findRank(Lotto randomNumbers) {
        int matchCount = Judge.compareWinningNumbers(lottoWinningNumbers, randomNumbers);
        boolean isMatchBonusNumber = Judge.compareBonusNumber(lottoWinningNumbers, lottoBonusNumber);
        return LottoResult.getLottoResult(matchCount, isMatchBonusNumber);
    }


    public void printOutWinningResult() {
        System.out.println(LOTTO_RESULTS_MESSAGE);
        System.out.println(DIVIDER);
        String earningsRate = calculateEarningsRate(totalEarnings, purchaseAmount);

    }
}
