package lotto;

import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        String userPurchaseAmount = userInput.inputPurchaseAmount();


        int convertedUserPurchaseAmount = convertDataType.stringToInt(userPurchaseAmount);
        userInputValidation.userPurchaseAmountMinValidation(convertedUserPurchaseAmount);
        userInputValidation.userPurchaseAmountValidation(convertedUserPurchaseAmount);


        int purchasableLottoTickets = outputResult.calculateNumberOfLottoTickets(convertedUserPurchaseAmount);
        List<List<Integer>> userLottoTickets = outputResult.displayLottoPurchaseResult(purchasableLottoTickets);

        String userWinningNumber = userInput.inputWinningNumber();
        List<Integer> convertedUserWinningNumber = convertDataType.stringToList(userWinningNumber);
        Lotto userWinningNumberList = new Lotto(convertedUserWinningNumber);

        String userBonusNumber = userInput.inputBonusNumber();
        int convertedUserBonusNumber = convertDataType.stringToInt(userBonusNumber);

        int[] ticketsList = drawLots.generateMatchResultList(userLottoTickets, convertedUserWinningNumber, convertedUserBonusNumber);

        int lottoWholeEarning = earning.calculateWholeEarning(ticketsList);
        String rateOfReturn = earning.caculateRateOfReturn(lottoWholeEarning, convertedUserPurchaseAmount);
        earning.displayResultRateOfReturn(rateOfReturn);

    }
}
