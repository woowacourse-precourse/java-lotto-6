package lotto;

import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author 김지환
 * 
 * 로또시작을 위한 메서드를 모아놓은 클래스
 */
public class StartLotto {
    private LottoUserInput lottoInput = new LottoUserInput();
    private LottoPrint lottoPrint = new LottoPrint();
    private LottoManager lottoManager = new LottoManager();
    
    public void lottoStart() {
        int userAmount = lottoInput.getUserPurchaseAmount();
        lottoPrint.printPurchaseLottoNumbers(userAmount);
        List<List<Integer>> lottoTickets = lottoManager.generateLottoTickets(userAmount/1000);
        List<Integer> winningNumber = lottoInput.getWinningNumber();
        int bonusNumber = lottoInput.getValidBonusNumber(new HashSet<>(winningNumber));
        int[] recordMatches = lottoManager.recordMatches(lottoTickets, winningNumber, bonusNumber);
        lottoPrint.printMatchStatistics(recordMatches);
        lottoPrint.rateOfReturn(recordMatches, userAmount);
        Console.close();
    }
    
}
