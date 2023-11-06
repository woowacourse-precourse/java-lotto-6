package model;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private final List<Integer> winningDetails = new ArrayList<>();

    private int fifth = 0;
    private int fourth = 0;
    private int third = 0;
    private int second = 0;
    private int first = 0;

    public void addRank(int rank){
        winningDetails.add(rank);
    }

    public List<Integer> getWinningDetails() {
        return winningDetails;
    }

    public void printResult(){ //임시
        System.out.println("3개 일치 (5,000원) - "+fifth+"개");
        System.out.println("4개 일치 (50,000원) - "+fourth+"개");
        System.out.println("5개 일치 (1,000,000원) - "+third+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+second+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+first+"개");
    }
    public void calculateResult(){
        for(int win : winningDetails){
            matchRank(win);
        }
    }

    private void matchRank(int win){
        switch (win){
            case 3 :
                fifth++;
                break;
            case 4:
                fourth++;
                break;
            case 5:
                third++;
                break;
            case 6:
                first++;
                break;
            case 7:
                second++;
                break;
        }
    }
}
