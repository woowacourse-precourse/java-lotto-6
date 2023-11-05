package game;

import static constant.ConstantNumber.NUMBER_INITIALIZATION;
import static game.LottoRank.FIFTH_RANK;
import static game.LottoRank.FIRST_RANK;
import static game.LottoRank.FOURTH_RANK;
import static game.LottoRank.SECOND_RANK;
import static game.LottoRank.THIRD_RANK;

import base.Converter;
import java.util.ArrayList;
import java.util.List;
import lottoResult.LottoResultDisplay;
import lottoResult.UserLottoNumbers;
import lottoTicketPurchase.LottoTicketPurchase;
import lottoTicketPurchase.LottoTicketQuantity;
import lottoWinningNumber.BonusNumberInput;
import lottoWinningNumber.WinningNumberInput;

public class LottoGame {
    public void run() {
        Converter converter = new Converter();
        LottoTicketPurchase lottoTicketPurchase = new LottoTicketPurchase();
        LottoTicketQuantity lottoTicketQuantity = new LottoTicketQuantity();
        UserLottoNumbers lottoTicketDisplay = new UserLottoNumbers();
        WinningNumberInput winningNumberInput = new WinningNumberInput();
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        LottoResultDisplay lottoResultDisplay = new LottoResultDisplay();
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
        lottoResultDisplay.getLottoSuccessCount(userLottoNumbers, winningNumberList, bonusNumber);
        lottoResultDisplay.outputLottoResult();

        int sixSuccess = lottoResultDisplay.sixSuccess;
        int fiveSuccess = lottoResultDisplay.fiveSuccess;
        int fiveAndBonusSuccess = lottoResultDisplay.fiveAndBonusSuccess;
        int fourSuccess = lottoResultDisplay.fourSuccess;
        int threeSuccess = lottoResultDisplay.threeSuccess;

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