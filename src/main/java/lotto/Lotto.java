package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public List<Paper> papers;
    public List<Integer> matchingNumbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        papers=new ArrayList<>();
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

    // TODO: 추가 기능 구현
    public void createPapers(int n,int bonusNumber){
        for(int i = 0; i<n;i++){
            Paper paper=new Paper();
            paper.checkCorrespondNum(numbers,bonusNumber);
            paper.checkWinMoney();
            papers.add(paper);
        }
    }

    public void saveMatchingNumbers(){
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

    public void printPapers(){
        for(Paper i : papers){
            System.out.println(i.getNumber());
        }
    }

    public void printMatchingNumbers(){
        for(int i : matchingNumbers){
            System.out.println(i);
        }
    }
}
