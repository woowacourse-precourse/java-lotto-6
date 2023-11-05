package lotto;

import java.util.ArrayList;
import java.util.List;

public class Papers {
    public List<Paper> papers=new ArrayList<>();
    public void createPapers(int n){
        for(int i = 0; i<n;i++){
            Paper paper=new Paper();
            papers.add(paper);
        }
    }
    public void creatCorrespondNum(List<Integer>numbers,int bonusNumber){
        for(Paper i : papers){
            i.checkCorrespondNum(numbers,bonusNumber);
        }
    }
    public void creatWinMoney(){
        for(Paper i : papers){
            i.checkWinMoney();
        }
    }

    public void printPapers(){
        System.out.println("\n"+papers.size()+"개를 구매했습니다.");
        for(Paper i : papers){
            i.printPaperNumbers();
        }
    }
}
