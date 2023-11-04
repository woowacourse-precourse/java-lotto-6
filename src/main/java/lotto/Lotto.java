package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public List<Paper> papers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        papers=new ArrayList<>();
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
}
