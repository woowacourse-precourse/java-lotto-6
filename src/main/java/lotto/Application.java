package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 최초 커밋 테스트
    }

    public static String inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputPurchaseAmount = Console.readLine();
        return inputPurchaseAmount;
    }

    public int inputPurchaseAmountValidation(String inputPurchaseAmount){
        try {
            int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
            return purchaseAmount;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000 ");
        }
    }

    public int lottoQuantity(int lottoPurchaseAmount){
        int lottoQuantity = lottoPurchaseAmount % 1000;
        if(lottoQuantity != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액을 1,000원 단위로 입력하세요.");
        }
        return lottoQuantity;
    }

    public List<Lotto> createLottos(int lottoQuantity){
        List<Lotto> lottos= new ArrayList<>();
        for(int quantity = 1; quantity <= lottoQuantity ; quantity++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public void purchaseLottoNumbersDisplay(List<Lotto> lottos){
        int lottoQuantity = lottos.size();
        System.out.println(lottoQuantity+"개를 구매했습니다.");
        for (int quantity = 1 ; quantity <= lottoQuantity ; quantity++){
            lottos.get(quantity-1).lottoNumberDisplay();
        }
    }

    public String inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumber = Console.readLine();
        return inputWinningNumber;
    }

    public String[] inputWinningNumberSplit(String inputWinningNumber){
        String[] inputWinningNumberSplit = inputWinningNumber.split(",");
        if(inputWinningNumberSplit.length != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표(,)를 기준으로 6자리를 입력해주세요.");
        }
        return inputWinningNumberSplit;
    }

    public List<Integer> inputWinningNumberValidation(String[] inputWinningNumberSplit){
        try {
            List<Integer> winningNumber = new ArrayList<>();
            for (int i = 0 ; i < inputWinningNumberSplit.length ; i++){
                int number = Integer.parseInt(inputWinningNumberSplit[i]);
                winningNumber.add(number);
            }
            Collections.sort(winningNumber);
            return winningNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 숫자로 입력해주세요.");
        }
    }

    public String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        return inputBonusNumber;
    }

    public int inputBonusNumberValidation(String inputBonusNumber){
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            return bonusNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
        }
    }

    public int inputBonusNumberRangeValidation(int inputBonusNumberValidation){
        if(inputBonusNumberValidation < 1 || inputBonusNumberValidation > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해 주세요.");
        }
        return inputBonusNumberValidation;
    }

    public int lottoWinningAmount(List<Integer> lotto ,List<Integer> winningNumber, int bonusNumber){
        int matchCount = 0;
        for(int i = 0 ; i < winningNumber.size() ; i++){
            if(lotto.contains(winningNumber.get(i))){
                matchCount++;
            }
        }

        if(matchCount == 3){
            return 5000;
        }
        if(matchCount == 4){
            return 50000;
        }
        if(matchCount == 5){
            if(lotto.contains(bonusNumber)){
                return 30000000;
            }
            return 1500000;
        }
        if(matchCount == 6){
            return 200000000;
        }
        return 0;
    }

    public void lottoWinningResult (List<Lotto> lottos ,List<Integer> winningNumber, int bonusNumber){
        int totalWinningAmount = 0;
        float totalReturnRate = 0;
        int lottoQuantity = lottos.size();

        int threeMatches = 0;
        int fourMatches = 0;
        int fiveMatches = 0;
        int fiveBonusMatches = 0;
        int sixMatches = 0;

        for (int quantity = 0 ; quantity < lottoQuantity ; quantity ++){
            int winningAmount = lottoWinningAmount(lottos.get(quantity).getNumbers(), winningNumber, bonusNumber);
            totalWinningAmount += winningAmount;

            if(winningAmount == 5000){
                threeMatches++;
            }

            if(winningAmount == 50000){
                fourMatches++;
            }

            if(winningAmount == 1500000){
                fiveMatches++;
            }

            if(winningAmount == 30000000){
                fiveBonusMatches++;
            }

            if(winningAmount == 200000000){
                sixMatches++;
            }

        }

        totalReturnRate = (totalWinningAmount - (lottoQuantity*1000))/totalWinningAmount*100;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeMatches+"개");
        System.out.println("4개 일치 (50,000원) - " + fourMatches+"개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatches+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusMatches+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatches+"개");
        System.out.println("총 수익률은 "+ totalReturnRate +"%입니다.");
    }


}
