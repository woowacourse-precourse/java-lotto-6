package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class User {

    static List<Integer> userLotto = new ArrayList<>();
    static int bonusNumber;
    static private final int[] userLottoResult = new int[8];



    public static void inputLottoNumber(){

        System.out.println("당첨 번호를 입력해 주세요.");
        while(true){
            String input = Console.readLine();
            String[] userInput = input.split(",");
            try{
                for(String temp : userInput){
                    int number = Integer.parseInt(temp);
                    checkNumberRange(number);
                    userLotto.add(number);
                }
                userLotto.sort(Comparator.naturalOrder());
                break;
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] 유효한 정수를 입력하세요.");
            }


        }
        Lotto.checkItemUnique(userLotto);
    }

    public static void checkNumberRange(int number){
        if(number<1 || number>45){
            throw new IllegalArgumentException();
        }
    }


    public static void inputBonusNumber(){

        System.out.println("보너스 번호를 입력해 주세요.");
        int number;
        while(true) {
            try {
                String input = Console.readLine();
                number = Integer.parseInt(input);
                checkNumberRange(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효한 정수를 입력하세요.");
            }
        }
        bonusNumber = number;

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

    public static double returnPercent(int profit, int expense){

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
