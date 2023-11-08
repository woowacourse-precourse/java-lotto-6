package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class User {

    static List<Integer> userLotto = new ArrayList<>();
    static int bonusNumber;
    static private final int[] userLottoResult = new int[8];



    public static void inputLottoNumber(){

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
    // TODO: input이 숫자6개가 ,로 되어있는지, 1~45까지인지, 숫자와 컴마로만 이루어져있는지, 중복이 없는지 확인
        String[] userInput = input.split(",");
        for(String inputParsing : userInput){
            int number;
            try {
                number = Integer.parseInt(inputParsing);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException();
            }

            userLotto.add(number);

        }
        userLotto.sort(Comparator.naturalOrder());

    }

    public static void inputBonusNumber(){

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonus = Console.readLine();
        // TODO: 1~45의 정수 입력하는지 확인하기
        bonusNumber = Integer.parseInt(inputBonus);

    }

    public static void printLottoResult(){

        int profit = getProfit();
        System.out.println("당첨 통계");
        int i=3;
        for(LottoDescription description : LottoDescription.values()){

            System.out.println(description.getDescription()+userLottoResult[i++]+"개");

        }
        printProfit();

    }

    public static void printProfit(){

        System.out.println("총 수익률은 "+String.format("%.1f", returnPercent(getProfit(),Money.money))+"%입니다.");

    }

    public static int getProfit(){
        int[] profitMoney = {0,0,0,5000,50000,1500000,30000000,2000000000};
        int profit = 0;
        for(int i=0;i<userLottoResult.length;i++){

            profit += (userLottoResult[i]*profitMoney[i]);

        }
        return profit;

    }

    private static double returnPercent(int profit, int expense){

        return (double) profit / (double) expense * 100.0;


    }

    public  static void compareLottoNum(ArrayList<Lotto> lottos){

        for(Lotto lotto : lottos){

            compareLottoNumbers(lotto.getLottoNumbers());

        }

    }


    private static void compareLottoNumbers(List<Integer> numbers){


        int count=0;
        for(int number : numbers){

            if(findSameNumberInUserLotto(number)){

                count++;

            }

        }
        if(count==5 && numbers.contains(bonusNumber)){

            userLottoResult[++count]++;
            return;

        }
        if(count==6){

            count+=1;
            userLottoResult[count]++;
            return;

        }
        userLottoResult[count]++;

    }

    private static boolean findSameNumberInUserLotto(int number){

        for(int userNumber : User.userLotto){

            if(userNumber==number){
                return true;
            }

        }
        return false;

    }



}
