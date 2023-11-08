package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;


    private static final int MIN = 1;
    private static final int MAX = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        between_number(numbers);
        Find_Duplicates(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private static void between_number(List<Integer> numbers){
        for (int i=0; i<numbers.size(); i++){
            if(numbers.get(i)>MAX||numbers.get(i)<MIN){
                throw new IllegalArgumentException();
            }
        }
    }

    private static void Find_Duplicates(List<Integer> numbers){
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            duplicates.add(numbers.get(i));
        }
        if(duplicates.size() !=6){
            throw new IllegalArgumentException();
        }
    }

    public static int bonusNum(String bonusNum){
        String pattern = "^[0-9]*$";
        boolean result = Pattern.matches(pattern, bonusNum);
        if(result == false){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(bonusNum);
    }

    public void checkMatch(List<List<Integer>> myList, int bonusNumber) {
        int[] winning_check = new int[8];
        for (int j = 0; j < 8; j++) {
            winning_check[j] = 0;
        }
        for (int i = 0; i < myList.size(); i++) {
            boolean bonus_check = false;
            int finalI = i;
            List<Integer> matchList = this.numbers.stream().filter(o->(myList.get(finalI)).stream()
                    .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
            int aFrequency = matchList.size();
            if(aFrequency == 3){
                winning_check[3] = winning_check[3]+1;
            }
            if(aFrequency == 4){
                winning_check[4] = winning_check[4] +1;
            }
            if(aFrequency == 5){
                bonus_check = myList.get(i).contains(bonusNumber);
            }
            if(bonus_check==true){
                winning_check[6]++;
            }
            if(aFrequency == 5&&bonus_check==false){
                winning_check[5]++;
            }
            if(aFrequency == 6){
                winning_check[7]++;
            }
        }
        
        System.out.println("당첨 통계");
        System.out.println("---");
            System.out.println("3개 일치 (5,000)원 - " + winning_check[3] + "개");
            System.out.println("4개 일치 (50,000)원 - " + winning_check[4] + "개");
            System.out.println("5개 일치 (1,500,000)원 - " + winning_check[5] + "개");
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winning_check[6] + "개");
            System.out.println("6개 일치 (2,000,000,000원) - " + winning_check[7] + "개");


        }
    }

