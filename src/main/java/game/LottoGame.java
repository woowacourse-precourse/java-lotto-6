package game;

import static constant.ConstantMessage.WINNING_STATISTICS_NOTICE_MESSAGE;
import static constant.ConstantNumber.BONUS_CRITERIA;
import static constant.ConstantNumber.NUMBER_INITIALIZATION;
import static game.LottoRank.FIFTH_RANK;
import static game.LottoRank.FIRST_RANK;
import static game.LottoRank.FOURTH_RANK;
import static game.LottoRank.SECOND_RANK;
import static game.LottoRank.THIRD_RANK;

import base.Converter;
import java.util.ArrayList;
import java.util.List;
import lottoTicketPurchase.LottoTicketPurchase;
import lottoTicketPurchase.LottoTicketQuantity;

public class LottoGame {
    public void run() {
        Converter converter = new Converter();
        LottoTicketPurchase lottoTicketPurchase = new LottoTicketPurchase();
        LottoTicketQuantity lottoTicketQuantity = new LottoTicketQuantity();
        UserLottoNumbers lottoTicketDisplay = new UserLottoNumbers();
        WinningNumberInput winningNumberInput = new WinningNumberInput();
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        int purchaseAmount = lottoTicketPurchase.getPurchaseAmount(converter);

        // LottoTicketPurchase

        System.out.println();

        //LottoTicketQuantity

        int purchaseQuantity = lottoTicketQuantity.getPurchaseQuantity(purchaseAmount);

        lottoTicketQuantity.printPurchaseQuantity(purchaseQuantity);

        //UserLottoNumbers
        List<List<Integer>> userLottoNumbers = lottoTicketDisplay.getUserLottoNumbers(purchaseQuantity);
        lottoTicketDisplay.printUserLottoNumbers(purchaseQuantity, userLottoNumbers);

        System.out.println();

        //WinningNumberInput

        List<Integer> winningNumberList = new ArrayList<>();

        String winningNumbers = winningNumberInput.receiveWinningNumbers();
        String[] winningNumberStringList = winningNumberInput.makeWinningNumberStringList(winningNumbers, converter);
        winningNumberInput.getWinningNumbers(winningNumberStringList, winningNumberList, converter);

        //BonusNumberInput
        System.out.println();

        int bonusNumber = bonusNumberInput.getBonusNumber(converter);

        System.out.println();

        // LottoResultDisplay
        System.out.println(WINNING_STATISTICS_NOTICE_MESSAGE);

        int sixSuccess = NUMBER_INITIALIZATION;
        int fiveSuccess = NUMBER_INITIALIZATION;
        int fiveAndBonusSuccess = NUMBER_INITIALIZATION;
        int fourSuccess = NUMBER_INITIALIZATION;
        int threeSuccess = NUMBER_INITIALIZATION;

        for (int index = 0; index < userLottoNumbers.size(); index++) {
            int score = 0;
            int bonusScore = 0;
            for (int userNumber : userLottoNumbers.get(index)) {
                for (int luckyNumber : winningNumberList) {
                    if (luckyNumber == userNumber) {
                        score++;
                    }
                    if (userNumber == bonusNumber) {
                        bonusScore++;
                    }
                }
            }
            if (score == FIFTH_RANK.getMatchCount()) {
                threeSuccess++;
            }
            if (score == FOURTH_RANK.getMatchCount()) {
                fourSuccess++;
            }
            if (score == THIRD_RANK.getMatchCount()) {
                fiveSuccess++;
            }
            if (score == SECOND_RANK.getMatchCount() && bonusScore == BONUS_CRITERIA) {
                fiveAndBonusSuccess++;
            }
            if (score == FIRST_RANK.getMatchCount()) {
                sixSuccess++;
            }
        }

        System.out.println("3개 일치 (5,000원) - " + threeSuccess + "개");
        System.out.println("4개 일치 (50,000원) - " + fourSuccess + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveSuccess + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveAndBonusSuccess + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixSuccess + "개");

        int totalReward = NUMBER_INITIALIZATION;
        totalReward += FIFTH_RANK.getReward() * threeSuccess;
        totalReward += FOURTH_RANK.getReward() * fourSuccess;
        totalReward += THIRD_RANK.getReward() * fiveSuccess;
        totalReward += SECOND_RANK.getReward() * fiveAndBonusSuccess;
        totalReward += FIRST_RANK.getReward() * sixSuccess;

        double benefit = (double) totalReward / purchaseAmount * 100;

        double result = Math.round(benefit * 100.0) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }
}