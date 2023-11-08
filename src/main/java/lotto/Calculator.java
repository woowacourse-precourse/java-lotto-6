package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final Integer BONUS = 7;
    public static Integer setPrice() {
        while (true) {
            try {
                String money = inputConsole();
                Integer number = Integer.parseInt(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자만 입력하세요.");
            }
        }
    }

    public static List<Lotto> LottoInitialize(Integer cost){
        List<Lotto> tickets = setLottoTicketing(cost);
        System.out.println(tickets);
        return tickets;
    }
    public static List<Lotto> setLottoTicketing(Integer cost){
        Integer n = getCount(cost);
        List<Lotto> list = new ArrayList<Lotto>();
        for(int i = 0 ; i < n ; i++){
            list.add(ticketing());
        }
        return list;
    }
    public static Lotto ticketing(){
        List<Integer> numbers = new ArrayList<Integer>();
        while(numbers.size() < 6){
            Integer randomNumber = Randoms.pickNumberInRange(1,45);
            if(!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        Lotto ticket = new Lotto(numbers);
        return ticket;
    }
    public static Integer getCount(Integer cost){
        return cost / 1000;
    }








    public static String inputConsole() {
        String line = Console.readLine().trim().replaceAll(" ", "");
        return line;
    }

    public static Lotto drawWinner() {
        List<Integer> list = new ArrayList<Integer>();
        String number[] = inputConsole().split(",");
        for (String splitNumber : number) {
            Integer eachNumber = Integer.parseInt(splitNumber);
//            if(Exceptions.checkDuplicate(list,eachNumber)){
//                drawWinner();
//            }
            Exceptions.checkDuplicate(list,eachNumber);
            list.add(eachNumber);
        }
        Exceptions.checkSize(list);
        return new Lotto(list);
    }

    public static Integer drawBonus() {
        String bonus = inputConsole();
        Exceptions.checkString(bonus);
        return Integer.parseInt(bonus);
    }

//    public static Integer checkContainResult(Integer bonus, List<Lotto> tickets, Lotto winLottery){
//        for(Lotto lotto : tickets){
//
//        }
//    }

    public static Integer calContainsInTicket(Integer bonus, Lotto ticket, Lotto winLottery){
        Integer count = 0;
        List<Integer> userNumbers = ticket.getNumbers();
        List<Integer> winNumber = winLottery.getNumbers();
        for(int i = 0 ; i < ticket.getNumbers().size() ; i++){
            if(userNumbers.contains(winNumber.get(i))){
                count++;
            }
        }
        if(count.equals(5) && userNumbers.contains(bonus)){
            return BONUS;
        }
        return count;
    }

    public static Integer getArrayIndex(Integer count){
        if(count == 3){
            return 1;
        } else if( count == 4){
            return 2;
        } else if (count == 5){
            return 3;
        } else if(count == 7){
            return 4;
        }else if(count == 6){
            return 5;
        }else if(count == 0 || count == 1 || count == 2){
            return 0;
        }
        return null;
    }

    public static List<Integer> setPrize(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(5000);
        list.add(50000);
        list.add(1500000);
        list.add(30000000);
        list.add(2000000000);
        return list;
    }


    public Integer getProfit(List<Integer> resultList, List<Integer> prizeMoney){
        Integer profit = 0 ;
        for(int i = 0; i < resultList.size(); i++){
            profit += resultList.get(i) * prizeMoney.get(i);
        }
        return profit;
    }


    public static Double getMargin(Integer cost, Integer profit){
        Double margin = Double.valueOf(profit) / Double.valueOf(cost) * 100;
        return margin;
    }



}
