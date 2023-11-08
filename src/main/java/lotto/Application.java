package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
        int numberOfTickets=buyTickets();
        System.out.println("\n"+numberOfTickets+"개를 구매했습니다.");
        List<List<Integer>> ticketsNumbers = creatingTickets(numberOfTickets);
        List<Integer> winningNumbers = inputWinningNum();
        int bonusNumber = inputBonusNum(winningNumbers);
        Integer[] results = new Integer[numberOfTickets];
        int bonus5Count = 0;
        for(int i=0;i<numberOfTickets;i++){
            results[i]=checkingResult(ticketsNumbers.get(i),winningNumbers);
            if(results[i]==5 && ticketsNumbers.get(i).contains(bonusNumber)){
                bonus5Count++;}}
//        System.out.println(Arrays.toString(results));
        showResult(results,bonus5Count);
    }

//    로또 구입 금액을 입력 받아 예외 처리 후 로또 개수 반환
    public static int buyTickets(){
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            String input = Console.readLine();
            if (isValidMoney(input)) {
                return Integer.parseInt(input) / 1000;
            }
        }
    }
    private static boolean isValidMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 정수를 입력해주세요");
            return false;

        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 1000원단위로 입력해주세요");
            return false;
        }
    }


//    입력 받은 정수 만큼 티켓 번호 생성 후 출력
    public static List<List<Integer>> creatingTickets(int number){
        List<List<Integer>> resultLists = new ArrayList<>();
        for(int i=0;i<number;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> mutableNumbers = new ArrayList<>(numbers);
            Collections.sort(mutableNumbers);
//            Collections.sort(numbers);
            System.out.println(mutableNumbers);
            resultLists.add(mutableNumbers);
        }
        System.out.println();
        return resultLists;

    }

//    당첨 번호 입력 받아 예외 처리 후 반환
    public static List<Integer> inputWinningNum(){
        List<Integer> winningList = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        while(true) {
            String input = Console.readLine();
            if(isValidNumbers(input)){
                return Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            }
        }
    }
    public static boolean isValidNumbers(String input){
        List<Integer> winningList = new ArrayList<>();
        try {String[] inputArray = input.split(",");
            for (String i : inputArray) {winningList.add(Integer.parseInt(i.trim()));}
            Lotto winningListCheck = new Lotto(winningList);return true;}
        catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 정수여야 합니다");}
        catch (IllegalArgumentException e1) {
            System.out.println("[ERROR] 6개의 수를 뽑아야합니다");}
        catch (IllegalStateException e2) {
            System.out.println("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다");}
        catch (IllegalCallerException e3) {
            System.out.println("[ERROR] 로또 번호는 중복되지 않아야합니다");}
        winningList.clear();return false;
    }


//    보너스 번호 입력 받아 예외 처리 후 반환
    public static int inputBonusNum(List<Integer> winningList){
        System.out.println("보너스 번호를 입력해 주세요.\n");
        while (true) {
            String input = Console.readLine();
            if(isValidNumber(input,winningList)){
                return Integer.parseInt(input);
            }
        }
    }
    public static boolean isValidNumber(String input,List<Integer> winningList) {
        try {int number = Integer.parseInt(input);
            if (number < 1 || number > 45) {
                throw new IllegalStateException();}
            if (winningList.contains(number)) {
                throw new IllegalArgumentException();}
            Lotto winningListCheck = new Lotto(winningList);
            return true;}
        catch (NumberFormatException e1) {System.out.println("[ERROR] 정수를 입력해주세요");}
        catch (IllegalStateException e2) {System.out.println("[ERROR] 보너스번호는 1부터 45사이의 숫자여야 합니다");}
        catch (IllegalArgumentException e3) {System.out.println("[ERROR] 보너스번호는 당첨번호와 중복되지 않아야 합니다");}
        return false;
    }

//    결과를 입력 받아 당첨 개수 확인
    public static int checkingResult(List<Integer> ticketNum, List<Integer> winningList){
        int count = 0;

        for (int number : winningList ){
            if(ticketNum.contains(number)){
                count++;
            }
        }
        return count;
    }

    public static void showResult(Integer[] results, Integer bonus5count){
//        List<Integer> resultslist = Arrays.asList(results);
        int three=Collections.frequency(Arrays.asList(results), 3);
        int four=Collections.frequency(Arrays.asList(results), 4);
        int five=Collections.frequency(Arrays.asList(results), 5)-bonus5count;
        int fiveBonus=bonus5count;
        int six=Collections.frequency(Arrays.asList(results), 6);
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n".formatted(three));
        System.out.printf("4개 일치 (50,000원) - %d개\n".formatted(four));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n".formatted(five));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n".formatted(fiveBonus));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n".formatted(six));
        System.out.print("총 수익률은 "+(100*(5*three+50*four+1500*five+30000*fiveBonus+2000000*six)/(float)results.length)+"%입니다.");
    }

}
