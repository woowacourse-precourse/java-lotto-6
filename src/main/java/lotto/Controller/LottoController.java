package lotto.controller;

import static lotto.message.UserInputMessage.*;
import static lotto.util.RandomNumberGenerator.generateRandomNumbers;
import static lotto.util.ThousandSeparator.addThousandsSeparator;
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

    int purchaseAmount;
    int totalEarnings;
    Lotto winningNumbers;
    LottoBonus bonusNumber;
    List<Lotto> randomNumbers;
    LottoRankCount rankCount;

    {
        randomNumbers = new ArrayList<>();
    }


    public LottoController() {
    }

    public void start() {
        requestLottoPurchaseAmount();
        printOutRandomNumbers();

        requestWinningNumbers();
        requestBonusNumber();

        printOutWinningResult();
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
        System.out.printf(LOTTO_TICKETS_PURCHASED_MESSAGE + "\n", lottoTicket);
        generateLottoRandomNumbers(lottoTicket);
        for (Lotto randomNumber : randomNumbers) {
            System.out.println(randomNumber);
        }
        System.out.println();
    }

    public void generateLottoRandomNumbers(int lottoTicket) {
        for (int i = 0; i < lottoTicket; i++) {
            Lotto randomNumber = new Lotto(generateRandomNumbers(lottoTicket));
            randomNumbers.add(randomNumber);
        }
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        String userInput = Console.readLine();
        try {
            isWinningNumberValid(userInput);
            winningNumbers = makeWinningNumbers(userInput);
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
            int bonus = Integer.parseInt(userInput);
            isBonusNumberDuplicate(winningNumbers.getNumbers(), bonus);
            bonusNumber = new LottoBonus(bonus);
            System.out.println();
        } catch (Exception error) {
            System.out.println(error.getMessage());
            requestBonusNumber();
        }
    }

    public void printOutWinningResult() {
        System.out.println(LOTTO_RESULTS_MESSAGE);
        System.out.println(DIVIDER);
        calculateResult();

        String earningsRate = calculateEarningsRate(totalEarnings, purchaseAmount);
        printOutMatchingResult();
        System.out.printf(EARNING_RATE_MESSAGE + "\n", earningsRate);
    }

    public void calculateResult() {
        totalEarnings = Judge.calculateEarnings(randomNumbers, winningNumbers, bonusNumber);
        rankCount = Judge.calculateRank(randomNumbers, winningNumbers, bonusNumber);
    }

    public void printOutMatchingResult() {
        for (LottoResult result : LottoResult.values()) {
            String messageFormat = MATCH_MESSAGE;
            int matchCount = result.getLottoMatchCount();
            int winningAmount = result.getLottoWinningAmount();
            int rank = result.getRank();
            String rankName = result.name();
            int currentRankCount = rankCount.getCount(rank);
            if (rankName.equals("SECOND_PLACE")) {
                messageFormat = MATCH_BONUS_MESSAGE;
            }
            System.out.printf(messageFormat + "\n", matchCount, addThousandsSeparator(winningAmount), currentRankCount);
        }
    }

}
