package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Rules.*;


public class InputData {
    //입력을 받기 위한 함수들의 집합
    static long amount;//티켓의 수량
    static ArrayList<Integer> number_list;//입력받은 번호의 리스트
    static int bonus_number;//보너스 번호

    InputData(){
        this.amount=amount;
        this.number_list=number_list;
        this.bonus_number=bonus_number;
    }


    public static void inputPrice(){//구입금액 입력 함수
        long price=0;
        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            String input_price=readLine();

            if(commonException(input_price)||remainderIsNot0(Long.parseLong(input_price))||numberIsNegativeNumber(Long.parseLong(input_price))){//함수가 true면 재시작해서 다시 입력받음
                continue;
            }

            price=Long.parseLong(input_price);
            amount=price/1000;
            return;
        }
    }


    private static boolean commonException(String str){//공통 예외처리 함수
        return inputIsNull(str)||notNumber(str);
    }


    public static void inputNumbers(){//로또 번호 6개 입력
        while(number_list==null||number_list.size()!=6){
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String numbers=readLine();

            List<String> numbers_split= Arrays.asList(numbers.split(","));
            if(inputIsNull(numbers)||amountIsNot6(numbers)||eachNumberIsStandard(numbers_split)||compareSixNumbers(numbers_split))//예외가 발생하면 다시 실행
                continue;

        }
        //Lotto lotto=new Lotto(number_list);
    }


    //두 개의 리스트를 비교해
    public static boolean compareSixNumbers(List<String> numbers_split){
        number_list.add(Integer.parseInt(numbers_split.get(0)));
        for(int i=1;i<6;i++){
            if(numberIsAlreadyExist(number_list,Integer.parseInt(numbers_split.get(i)))) {
                number_list.clear();
                return true;
            }
            number_list.add(Integer.parseInt(numbers_split.get(0)));
        }
        return false;
    }




    public static boolean eachNumberIsStandard(List<String> numbers_split){
        for(int i=0;i<6;i++){
            //각 원소들이 비어있거나 1과 45의 수가 아닐 경우 다시 시작
            if(notNumber(numbers_split.get(i))||numberIsNotBetween1And45(Integer.parseInt(numbers_split.get(i))))
                return true;
        }
        return false;
    }


    public static void inputBonusNumber(){//보너스 번호 입력
        while(bonus_number==0){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String input_bonus_number=readLine();

            if(commonException(input_bonus_number)||numberIsNotBetween1And45(Integer.parseInt(input_bonus_number)))
                continue;

            if(!numberIsAlreadyExist(number_list,Integer.parseInt(input_bonus_number)))//중복되면 true
                bonus_number=Integer.parseInt(input_bonus_number);

        }
    }


}
