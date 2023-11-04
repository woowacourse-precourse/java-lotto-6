package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public List<Integer> matchingNumbers;
    public float rateOfReturn=0;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        matchingNumbers=new ArrayList<>();
        for(int i=0;i<5;i++){
            matchingNumbers.add(0);
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void saveMatchingNumbers(List<Paper> papers){
        for(Paper i : papers){
            if(i.getCorrespondNum()==3){
                matchingNumbers.set(0,matchingNumbers.get(0)+1);
            }
            if(i.getCorrespondNum()==4){
                matchingNumbers.set(1,matchingNumbers.get(1)+1);
            }
            if(i.getCorrespondNum()==5){
                matchingNumbers.set(2,matchingNumbers.get(2)+1);
            }
            if(i.getCorrespondNum()==6){
                matchingNumbers.set(3,matchingNumbers.get(3)+1);
            }
            if(i.getCorrespondNum()==7){
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
        for(int i : matchingNumbers){
            System.out.println(i);
        }
    }

    public void printRateOfReturn(){
        System.out.println(rateOfReturn);
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }
}
