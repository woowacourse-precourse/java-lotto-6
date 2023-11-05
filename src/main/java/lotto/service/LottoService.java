package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.view.OutputView;

import java.util.List;

import static lotto.validator.LottoValidator.*;
import static lotto.validator.PurchaseAmountValidator.*;
import static lotto.view.InputView.*;

public class LottoService {

    private static final int DIVIDER_MONEY_TO_EXCHANGE_AMOUNT = 1000;
    private static final String DELIMITER = ",";

    public static int enterPurchaseAmount() {
        noticeToGetPurchaseAmount();
        String inputMoney = Console.readLine();
        int money = Integer.parseInt(inputMoney);
        //천 원 단위로 입력받았는지 검증
        validateMoney(inputMoney, DIVIDER_MONEY_TO_EXCHANGE_AMOUNT);

        OutputView.printPurchaseAmount(money);
        return money / DIVIDER_MONEY_TO_EXCHANGE_AMOUNT;
    }

    public static Lotto enterWinningNumbers() {
        noticeToGetWinningNumbers();
        String[] numbers = Console.readLine().split(DELIMITER);
        //중복 값 입력받았는지 여부 확인
        List<Integer> inputNumbers = validateLottoNumbers(numbers);

        return new Lotto(inputNumbers);
    }

    public static int enterBonusNumber(Lotto lotto) {
        noticeToGetBonusNumber();
        int bonusNumber = Integer.parseInt(Console.readLine());
        //보너스 번호가 당첨 번호랑 중복되는지 여부 확인
        validateBonusNumberInWinningNumbers(lotto, bonusNumber);

        return bonusNumber;
    }

    public static void matchLottoNumbers(WinningNumbers winningNumbers, List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            matchLottoTicket(winningNumbers, lotto);
        }
    }

    private static void matchLottoTicket(WinningNumbers winningNumbers, Lotto userLottoNumbers) {
        boolean hasBonusNumber = false;
        int matchCount = 0;
        int bonusNumber = winningNumbers.getBonusNumber();
        List<Integer> winningNumber = winningNumbers.getWinningNumbers().getLotto();
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
