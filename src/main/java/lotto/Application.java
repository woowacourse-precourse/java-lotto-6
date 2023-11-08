package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private static int moneyValidate(){
        int money;

        while(true){
           try{
               System.out.println("구입금액을 입력해 주세요.");
               money =Integer.valueOf(Console.readLine());

               if ( (money % 1000) != 0) {
                   throw new IllegalArgumentException("[ERROR]1,000원 단위로 입력하세요.");
               }
               break;
           }catch (NumberFormatException e){
               throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
           }
        }
        return money;
    }

    private static List<Lotto> generateLottes(int trial){
        List<Lotto> Lottos = new ArrayList<>();

        for(int i=0; i< trial; i++){
            List<Integer> lottsnumber = new ArrayList<>();
            while(lottsnumber.size() < 6){
                int number =  Randoms.pickNumberInRange(1,45);
                if(!lottsnumber.contains(number)){
                    lottsnumber.add(number);
                }
            }
            Lottos.add(new Lotto(lottsnumber));
        }
        return Lottos;
    }

    private  static void printLottes(List<Lotto> lottos,int ticket){
        System.out.println(ticket+ "개를 구매했습니다.");
        for(int i=0; i< ticket;i++)
            lottos.get(i).printLotto();
    }

    private static String[] getWinningnumber(){
        String input;
        String[] numbers;
        while(true){
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                input = Console.readLine();
                numbers = input.split(",");

                if(numbers.length != 6){
                    throw new IllegalArgumentException("6개의 당첨 번호를 입력하세요.");
                }
                break;
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
            }
        }
        return numbers;
    }

    private static int getBonceNumber(List<Integer> winningnumber){
        int input;
        while (true){
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                input=  Integer.valueOf(Console.readLine());
                if(winningnumber.contains(input)){
                    throw new IllegalArgumentException("[ERROR] 중복된 번호입니다.");
                }
                break;
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
            }
        }
        return input;
    }

    private  static List<Integer> stringToList(String[] input){
        List<Integer> List = new ArrayList<>();
        List<Integer> integerList = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return List;
    }

    private  static  void resultPrint(int tiral, List<Lotto> lottos,List<Integer> winningnumber ){
        System.out.println("당첨 통계\n"+ "---");
        for(int i =0; i < tiral; i++){
            Lotto lottoticket =  lottos.get(i);
            int matchednumber = checkNumber(lottoticket,winningnumber);

        }


    }

    private  static int checkNumber(Lotto lottoticket,List<Integer> winningnumber ){
        return (int) lottoticket.stream().filter(winningnumber::contains).count();
    }
    private static void printCheckNumber(){

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        int ticket;
        int bouncenumber;
        List<Lotto> lottes;
        List<Integer> winningnumber;

        money = moneyValidate();
        ticket = money /1000;
        lottes = generateLottes(ticket);

        printLottes(lottes,ticket);

        winningnumber = stringToList(getWinningnumber());

        winningnumber.add(getBonceNumber(winningnumber));

        resultPrint();
    }

}
