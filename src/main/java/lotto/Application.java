package lotto;

import java.util.ArrayList;
import java.util.List;


/**
 * 프로그램이 시작하는 Main 입니다.
 */
public class Application {
    public static void main(String[] args) {
        List<List<Integer>> userNumbers = new ArrayList<>();

        int priceAmount = Input.priceAmountInput();
        Lotto winningnumbers = Input.winningNumberInput(); 
        int bonusNumber = Input.bonusNumberInput(winningnumbers);

        int lottoAmount = priceAmount / 1000;
        ArrayList<LottoResult> matchResults = new ArrayList<>();


        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> userNumber =  GenerateRandom.getRandomNumbers();
            userNumbers.add(userNumber);
        }
        Output.lottoInfoPrint(userNumbers);

        for (int i = 0; i < lottoAmount; i++) {
            int matchCount = MatchLotto.isNumbersMatching(winningnumbers, userNumbers.get(i));
            boolean matchBonus = MatchLotto.isBonusNumbersMatching(bonusNumber, userNumbers.get(i));
    
            matchResults.add(LottoResult.getResult(matchCount, matchBonus));
        }

        Output.resultPrint(matchResults);
        Output.calculateLottoEarnings(matchResults, priceAmount);
        
    }
}
