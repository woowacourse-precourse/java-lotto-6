package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    static final int firstWinningAmount = 2000000000;
    static final int secondWinningAmount = 30000000;
    static final int thirdWinningAmount = 1500000;
    static final int fourthWinningAmount = 50000;
    static final int fifthWinningAmount = 5000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //1. 사용자로부터 로또 구입 금액을 입력받고, 로또 구입 금액에 해당하는 만큼 로또를 발행한다.(로또 1장의 가격은 1,000원)
        System.out.println("구입금액을 입력해 주세요.");
        long userInputAmount = getUserInputAmount();

        int lottoCount = (int)(userInputAmount/1000);
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);

        List<Lotto> lottos = getLotto(lottoCount);
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }

        //2. 사용자로부터 당첨번호, 보너스번호를 입력받아 저장한다.
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = getWinningLotto();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber();

        //3. 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
        checkWinning(lottos, winningLotto, bonusNumber, userInputAmount);
    }

    public static boolean checkWinning(List<Lotto> lottos, Lotto winningLotto, int bonusNumber, long userInputAmount){
        long totalWinningAmount = 0L;
        int[] totalWinningCount = {0,0,0,0,0,0};

        for(Lotto lotto : lottos){
            int rank = getLottoRank(lotto, winningLotto, bonusNumber);
            totalWinningAmount += getWinningAmount(rank);
            totalWinningCount[rank]++;
        }

        printWinningInfo(totalWinningCount);
        printTotalReturn(totalWinningAmount, userInputAmount);

        return true;
    }

    public static void printWinningInfo(int[] totalWinningCount){
        for (int i = 5; i >= 1; i--) {
            if (i == 5) System.out.printf("3개 일치 (%d원) - %d개\n", fifthWinningAmount, totalWinningCount[i]);
            else if (i == 4) System.out.printf("4개 일치 (%d원) - %d개\n", fourthWinningAmount, totalWinningCount[i]);
            else if (i == 3) System.out.printf("5개 일치 (%d원) - %d개\n", thirdWinningAmount, totalWinningCount[i]);
            else if (i == 2) System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개\n", secondWinningAmount, totalWinningCount[i]);
            else if (i == 1) System.out.printf("6개 일치 (%d원) - %d개\n", firstWinningAmount, totalWinningCount[i]);
        }
    }

    public static void printTotalReturn(long totalWinningAmount, long userInputAmount){
        System.out.printf("총 수익률은 %.2f%%입니다.",(totalWinningAmount/userInputAmount)*100.0);
    }

    public static int getWinningAmount(int rank) {
        if(rank == 1) return firstWinningAmount;
        else if(rank == 2) return secondWinningAmount;
        else if(rank == 3) return thirdWinningAmount;
        else if(rank == 4) return fourthWinningAmount;
        else if(rank == 5) return fifthWinningAmount;

        return 0;
    }

    public static int getLottoRank(Lotto lotto, Lotto winningLotto, int bonusNumber){
        boolean bonusNumberCorrect = false;
        int correctCount = getCorrectCount(lotto, winningLotto);

        if(lotto.getNumbers().contains(bonusNumber)){
            bonusNumberCorrect = true;
        }

        if(correctCount == 6) return 1;
        else if(correctCount == 5 && bonusNumberCorrect) return 2;
        else if(correctCount == 5) return 3;
        else if(correctCount == 4) return 4;
        else if(correctCount == 3) return 5;

        return 0;
    }

    public static int getCorrectCount(Lotto lotto, Lotto winningLotto){
        int correctCount = 0;
        for(int winningNumber : winningLotto.getNumbers()){
            if(lotto.getNumbers().contains(winningNumber)){
                correctCount++;
            }
        }

        return correctCount;
    }

    public static int getBonusNumber(){
        String userInput;
        while(true) {
            try {
                userInput = readLine().trim();
                bonusNumberValidate(userInput);
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 보너스 번호(1~45)를 숫자로 입력해주세요.");
            }
        }

        return Integer.parseInt(userInput);
    }

    public static void bonusNumberValidate(String bonusNumber){
        if(!isNumeric(bonusNumber)){
            throw new IllegalArgumentException();
        }
        if(!inLottoNumberRange(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }

    public static boolean inLottoNumberRange(String number){
        if(Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45){
            return false;
        }

        return true;
    }

    public static Lotto getWinningLotto() {
        Lotto winningLotto;
        while(true) {
            try {
                winningLotto = new Lotto(getWinningNumbers());
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 6개의 당첨 번호(1~45)를 입력해주세요.");
            }
        }

        return winningLotto;
    }

    public static List<Integer> getWinningNumbers() {
        String userInput;
        String[] splittedNumber;
        while(true) {
            try {
                userInput = readLine().trim();
                splittedNumber = userInput.split(",");
                splittedNumberValidate(splittedNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 당첨 번호(1~45)를 숫자로 입력해주세요.");
            }
        }

        return stringArrayToIntegerList(splittedNumber);
    }

    public static List<Integer> stringArrayToIntegerList(String[] numbers){
        List<Integer> winningNumbers = new ArrayList<>();
        for(String number : numbers){
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    public static void splittedNumberValidate(String[] splittedNumber){
        for(String number : splittedNumber){
            if(!isNumeric(number)){
                throw new IllegalArgumentException();
            }
            if(!inLottoNumberRange(number)){
                throw new IllegalArgumentException();
            }
        }
    }

    public static long getUserInputAmount() {
        String userInput;
        while(true) {
            try {
                userInput = readLine().trim();
                inputAmountValidate(userInput);
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 금액을 1,000원 단위 숫자로 입력해주세요.");
            }
        }

        return Long.parseLong(userInput);
    }

    public static void inputAmountValidate(String userInput){
        if(!isNumeric(userInput)){
            throw new IllegalArgumentException();
        }
        if(!hasRemainder(userInput)){
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumeric(String userInput){
        try {
            Long.parseLong(userInput);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean hasRemainder(String userInput){
        if( !((Long.parseLong(userInput) % 1000L) == 0) ){
            return false;
        }
        return true;
    }

    public static List<Lotto> getLotto(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<lottoCount; i++){
            lottos.add(new Lotto(pickUniqueNumbersInRange(1,45,6)));
        }

        return lottos;
    }
}
