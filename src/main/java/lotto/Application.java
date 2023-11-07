package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount=getPurchaseAmount();
        List<Lotto> lottos=generateLotto(purchaseAmount);

        List<Integer> winningNumbers=getWinningNumbers();
        int bonusNumber=getBonusNumber();

        printLottoNumbers(lottos);
        printWinningStatistics(lottos,winningNumbers,bonusNumber);


    }

    public static int getPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String input = Console.readLine();
                purchaseAmount = Integer.parseInt(input);
                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수여야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자 형식이 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private static List<Integer> getWinningNumbers() {
        while(true){
            System.out.println("당첨 번호를 입력해 주세요.");
            try{
                String input=Console.readLine();
                List<Integer> numbers=parseCommaSeperatedNumbers(input);
                if (numbers.size() !=6){
                    throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호를 입력해주세요.");
                }

                Set<Integer> numberSet=new HashSet<>(numbers);

                if (numberSet.size() !=6){
                    throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 입력되었습니다.");
                }
                return numbers;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private  static int getBonusNumber() {
        while(true){
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int bonusNumber=Integer.parseInt(Console.readLine());
                if (bonusNumber<1 || bonusNumber>45){
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private static List<Lotto> generateLotto(int purchaseAmount) {
        int numberOfLottos=purchaseAmount/1000;
        List<Lotto> lottos=new ArrayList<>();

        for(int i=0;i<numberOfLottos; i++){
            List<Integer> numbers=generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }

        System.out.println(numberOfLottos+"개를 구매했습니다.");
        return lottos;
    }
    private  static  List<Integer> generateLottoNumbers(){
        List<Integer> numbers=Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers;
//
    }

    private static void printLottoNumbers(List<Lotto> lottos){
        for (Lotto lotto: lottos){
            List<Integer> numbers=lotto.getNumbers();
            System.out.println(numbers);
        }
    }
    //발행 로또에 당첨 번호 있는지 확인
    private static int countMatchingNumbers(List<Integer> numbers,List<Integer> winningNumbers){
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }
    private static void printWinningStatistics(List<Lotto> lottos,List<Integer> winningNumbers,int bonusNumber) {
        int[] matchingCounts=new int[8];
        int[] prizes=new int[] {0,0,0,5000,50000,1500000,30000000,2000000000};
        //String[] prizesToPrint=new String[] {"0","0","0","5,000","50,000","1,500,000","30,000,000","2,000,000,000"};


        for (Lotto lotto:lottos) {
            List<Integer> numbers=lotto.getNumbers();
            int matchingCount=countMatchingNumbers(numbers,winningNumbers);
            boolean hasBonusNumber=numbers.contains(bonusNumber);

            matchingCounts[matchingCount]++;

            if (matchingCount==5 && hasBonusNumber) {
                matchingCounts[6]++;
            }
        }

        //당첨 통계 한 번만 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i=3; i<=7; i++){
            String message = "";
            if (i == 6) {
                message = "5개 일치, 보너스 볼 일치";
            }
            if (i == 7) {
                message = "6개 일치";
            }
            if (i != 6 && i != 7) {
                message = i + "개 일치";
            }
            message += " (" + String.format("%,d", calculatePrize(i, prizes)) + "원) - " + matchingCounts[i] + "개";
            System.out.println(message);

        }

        //수익률 출력
        double totalPrize=calculateTotalPrize(matchingCounts,prizes);
        double totalPurchaseAmount=lottos.size()*1000.0;
        double profitRate=(totalPrize/totalPurchaseAmount)*100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n",profitRate);
    }
    private static int calculatePrize(int matchingCount,int[] prizes){
        return prizes[matchingCount];
    }
    private static double calculateTotalPrize(int[] matchingCounts,int[] prizes){
        double totalPrize=0.0;
        for (int i=3;i<=7;i++){
            totalPrize+=matchingCounts[i]*prizes[i];
        }
        return totalPrize;
    }

    private static List<Integer> parseCommaSeperatedNumbers(String input){
        String[] tokens=input.split(",");
        //일단 테스트 해보고 수정
        try{
            return Arrays.stream(tokens)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 잘못된 번호 형식입니다.");
        }
    }



}
