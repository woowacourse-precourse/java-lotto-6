package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    final int LOTTO_PRICE = 1000;
    final int LOTTO_NUMBER = 6;
    final int MIN_NUMBER = 1;
    final int MAX_NUMBER = 45;
    public static final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    int[] ranks = new int[5];
    int prices = 0;
    String getPriceFromUser(){
        System.out.println(Messages.ASK_PRICE.getMessage());

        return Console.readLine();
    }

    void validatePrice(String input){
        int amount = validateInteger(input);

        if((amount % LOTTO_PRICE) != 0){
            throw new IllegalArgumentException(Messages.AMOUNT_OF_MONEY_MUST_DIVIDED_THOUSAND.getMessage());
        }
    }

    public int validateInteger(String input) {
       try{
           return Integer.parseInt(input);
       }catch (NumberFormatException e){
           throw new IllegalArgumentException("[ERROR]"+ONLY_NUMBER_ERROR_MESSAGE,e);
       }
    }

    int changeInputToInt(String input){
        return Integer.parseInt(input);
    }

    void announcePurchase(int amount){
        System.out.println((amount / LOTTO_PRICE)+Messages.BUY_LOTTO_MESSAGE.getMessage());
    }
    List<Lotto> buyLotto(int amount){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < (amount / LOTTO_PRICE); i++){
            lottos.add(issueNewLotto());
        }

        return lottos;
    }

    Lotto issueNewLotto(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_NUMBER));
        return lotto;
    }

    void printLottos(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

    WinLotto getWinningNumber(){
        System.out.println(Messages.ASK_WINNING_NUMBER.getMessage());
        return validateWinningNumber(Console.readLine());
    }

   WinLotto validateWinningNumber(String input){
        List<Integer> numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().collect(
                Collectors.toList());
        WinLotto winLotto = new WinLotto(numbers);
        return winLotto;
    }

    int getBonusNumber(){
        System.out.println(Messages.ASK_BONUS_NUMBER.getMessage());

        try{
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(Messages.ONLY_NUMBER_ERROR_MESSAGE.getMessage());
        }

        return 0;
    }

    void validateBonusNumber(int bonusNumber, WinLotto lotto){
        if(bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER){
            throw new IllegalArgumentException(Messages.BONUS_RANGE_EXCEPTION_MESSAGE.getMessage());
        }
        if(lotto.isContainNumber(bonusNumber)){
            throw new IllegalArgumentException(Messages.BONUS_UNIQUE_NUMBER_EXCEPTION_MESSAGE.getMessage());
        }
    }

    void calculate(WinLotto winLotto, List<Lotto> lottos, int bonus){
        for(Lotto lotto : lottos){
            countToRank(compareLotto(winLotto, lotto, bonus));
        }
    }

    int[] compareLotto(WinLotto winLotto, Lotto lotto, int bonus){
        int matchCount = 0;
        int bonusCount = 0;

        List<Integer> winNubmers = winLotto.getWinNumbers();
        for(Integer n : winNubmers){
            if(lotto.isContainNumber(n)){
                matchCount++;
            }
        }

        if(lotto.isContainNumber(bonus)){
            bonusCount++;
        }

        return new int[] {matchCount,bonusCount};
    }

    void countToRank(int[] counts){
        if(counts[0] == 6){
            ranks[0]++;
        }
        if(counts[0] == 5 && counts[1] == 1){
            ranks[1]++;
        }
        if(counts[0] == 5 && counts[1] == 0){
            ranks[2]++;
        }
        if(counts[0] == 4){
            ranks[3]++;
        }
        if(counts[0] == 3){
            ranks[4]++;
        }
    }

    void printWinningStatistics(int money){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ranks[4]+"개");
        System.out.println("4개 일치 (50,000원) - "+ranks[3]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ranks[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ranks[1]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ranks[0]+"개");

        printRateOfReturn(money);
    }

    void printRateOfReturn(int money){
        DecimalFormat df = new DecimalFormat("#.##");
        int prize = getToTalPrize();
        double rateOfReturn = (double) prize/(double)money * 100.0;
        String result = df.format(rateOfReturn);
        System.out.println("총 수익률은 "+result+"%입니다.");
    }

    int getToTalPrize(){
        int prize = 0;
        prize += ranks[0]*2000000000;
        prize += ranks[1]*30000000;
        prize += ranks[2]*1500000;
        prize += ranks[3]*50000;
        prize += ranks[4]*5000;
        return prize;
    }
}
