package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.List;

import static lotto.domain.Lotto.*;
import static lotto.domain.PurchaseAmount.*;
import static lotto.domain.WinningNumbers.*;
import static lotto.util.Constant.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoService {

    private static final int DIVIDER_MONEY_TO_EXCHANGE_AMOUNT = 1000;

    public static int enterPurchaseAmount() {
        noticeToGetPurchaseAmount();
        //천 원 단위로 입력받았는지 검증
        try {
            String inputMoney = Console.readLine();
            int purchaseAmount = validateMoney(inputMoney, DIVIDER_MONEY_TO_EXCHANGE_AMOUNT);
            printPurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterPurchaseAmount();
        }
    }

    public static Lotto enterWinningNumbers() {
        noticeToGetWinningNumbers();
        String[] numbers = Console.readLine().split(DELIMITER);
        //중복 값 입력받았는지 여부 확인
        try{
            List<Integer> inputNumbers = validateNumberSeparate(numbers);
            return new Lotto(inputNumbers);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return enterWinningNumbers();
        }
    }

    public static int enterBonusNumber(Lotto lotto) {
        noticeToGetBonusNumber();
        String bonusNumber = Console.readLine();
        //보너스 번호가 당첨 번호랑 중복되는지 여부 확인
        try{
            return validateBonusNumber(lotto, bonusNumber);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return enterBonusNumber(lotto);
        }
    }

    public static void matchLottoNumbers(WinningNumbers winningNumbers, List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            matchLottoTicket(winningNumbers, lotto);
        }
    }

    private static void matchLottoTicket(WinningNumbers winningNumbers, Lotto userLottoNumbers) {
        boolean hasBonusNumber = false;
        int matchCount = 0;
        int bonusNumber = winningNumbers.bonusNumber();
        List<Integer> winningNumber = winningNumbers.winningNumbers().getLotto();
        for (int number : userLottoNumbers.getLotto()) {
            if(winningNumber.contains(number)){
                ++matchCount;
            }
            if(number == bonusNumber){
                hasBonusNumber = true;
            }
        }
        Rank.increaseRankResult(matchCount, hasBonusNumber);
    }

    public static int totalEarningMoney() {
        int totalMoney = 0;
        for (Rank rank : Rank.values()) {
            if (rank.getWinningAmount() > 0) {
                totalMoney += rank.getMoney();
            }
        }
        return totalMoney;
    }

    public static double calculateEarningRatio(int purchaseAmount) {
        int totalEarningMoney = totalEarningMoney();

        return Math.round(totalEarningMoney / purchaseAmount) / 10.0;
    }

}
