package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int price = 0;
    private List<Lotto> lottoList = new ArrayList<>();
    private int fifth = 0;
    private int fourth = 0;
    private int third = 0;
    private int second = 0;
    private int first = 0;

    public User(int price, List<Lotto> lottos) {
        this.price = price;
        this.lottoList = lottos;
    }

    public void addLotto(Lotto lotto){
        lottoList.add(lotto);
    }

    public void checkRanking(String ranking){
        if(ranking.equals("fifth")){
            this.fifth++;
        }else if(ranking.equals("fourth")){
            this.fourth++;
        }else if(ranking.equals("third")){
            this.third++;
        }else if(ranking.equals("second")){
            this.second++;
        }else if(ranking.equals("first")){
            this.first++;
        }
    }

    public int getFifth() {
        return fifth;
    }

    public int getFourth() {
        return fourth;
    }

    public int getThird() {
        return third;
    }

    public int getSecond() {
        return second;
    }

    public int getFirst() {
        return first;
    }

}
