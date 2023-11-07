package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int price = 0;
    private List<Lotto> lottoList = new ArrayList<>();

    public User(int price) {
        this.price = price;
    }

    public void addLotto(Lotto lotto){
        lottoList.add(lotto);
    }

}
