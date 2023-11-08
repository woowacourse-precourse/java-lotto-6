package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Judgment{
    private int bonus;
    Lotto lotto;

    public void getLotto(){
        while(true) {
            try {
                lotto = new Lotto(inputNumbers());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println("[ERROR] 잘못된 로또 개수가 입력되었습니다. ");
            }
        }

        inputBonusNumber();
    }

    public List<Integer> inputNumbers(){
        List<Integer> numbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                numbers = splitNumbers(Console.readLine());
                isInRange(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
        }
        return numbers;
    }

    public void inputBonusNumber(){
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonus = Integer.parseInt(Console.readLine());
                isInRange(bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
        }
    }

    public List<Integer> splitNumbers(String numbers){
        String[] splitComma = numbers.split(",");

        int[] intArray = Arrays.stream(splitComma)
                .mapToInt(Integer::parseInt)
                .toArray();

        return Arrays.stream(intArray).boxed().collect(Collectors.toList());
    }

    public void isInRange(List<Integer> numbers){
        for(int number : numbers){
            if(number < 1 || number > 45)
                throw new IllegalArgumentException();
        }
    }
    public void isInRange(int number){
            if(number < 1 || number > 45)
                throw new IllegalArgumentException();
    }

    public static int divisibleByThousand(int amount){
        int remain = amount % 1000;
        int numberOfTickets = amount / 1000;

        if(remain != 0){
            throw new IllegalArgumentException();
        }

        return numberOfTickets;
    }

    public static void lottoSort(List<Integer> ticket) {
        Collections.sort(ticket);
    }

    public void printAll() {
        System.out.println(bonus);
        lotto.printNumbers();
    }

}
