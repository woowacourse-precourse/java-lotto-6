package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String PRINT_MATCHING_THREE = "3개 일치 (5,000원) - ";
    private static final String PRINT_MATCHING_FOUR = "4개 일치 (50,000원) - ";
    private static final String PRINT_MATCHING_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String PRINT_MATCHING_FIVEBONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_MATCHING_SIX = "6개 일치 (2,000,000,000원) - ";
    private final List<Integer> numbers;
    public List<Integer> matchingNumbers;
    public List<String> matchingComment;
    public float rateOfReturn=0;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkForDuplicates(numbers);

        this.numbers = numbers;
        insertMatchingNumbers();
        insertComment();
    }
    public void insertMatchingNumbers(){
        matchingNumbers=new ArrayList<>();
        for(int i=0;i<5;i++){
            matchingNumbers.add(0);
        }
    }
    public void insertComment(){
        matchingComment=new ArrayList<>();
        matchingComment.add(PRINT_MATCHING_THREE);
        matchingComment.add(PRINT_MATCHING_FOUR);
        matchingComment.add(PRINT_MATCHING_FIVE);
        matchingComment.add(PRINT_MATCHING_FIVEBONUS);
        matchingComment.add(PRINT_MATCHING_SIX);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkForDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void saveMatchingNumbers(List<Paper> papers){
        for(Paper i : papers){
            if(i.getCorrespondNum()==MatchingNumber.Three.getValue()){
                matchingNumbers.set(0,matchingNumbers.get(0)+1);
            }
            if(i.getCorrespondNum()==MatchingNumber.Four.getValue()){
                matchingNumbers.set(1,matchingNumbers.get(1)+1);
            }
            if(i.getCorrespondNum()==MatchingNumber.Five.getValue()){
                matchingNumbers.set(2,matchingNumbers.get(2)+1);
            }
            if(i.getCorrespondNum()==MatchingNumber.FiveBonus.getValue()){
                matchingNumbers.set(3,matchingNumbers.get(3)+1);
            }
            if(i.getCorrespondNum()==MatchingNumber.Six.getValue()){
                matchingNumbers.set(4,matchingNumbers.get(4)+1);
            }
        }
    }

    public void saveRateOfReturn(List<Paper> papers,int inputMoney){
        int totalMoney=0;
        for(Paper i : papers){
            totalMoney+=i.getWinMoney();
        }
        rateOfReturn= (float) totalMoney/inputMoney*100;
        rateOfReturn= (float) Math.round(rateOfReturn * 100) /100;
    }

    public void printMatchingNumbers(){
        for(int i =0;i<matchingComment.size();i++){
            System.out.print(matchingComment.get(i));
            System.out.println(matchingNumbers.get(i)+"개");
        }
    }

    public void printRateOfReturn(){
        System.out.println("총 수익률은 "+rateOfReturn+"%입니다.");
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }
}
