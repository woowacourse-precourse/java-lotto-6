package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.GenerateNumbers;

public class User {
    private int purchasePrice;

    private List<UserLotto> lottos = new ArrayList<>();

    public User(int purchasePrice){
       // lottos = new ArrayList<>();
        this.purchasePrice = purchasePrice;
        this.lottos = createLottos();
    }

    private List<UserLotto> createLottos(){
        return GenerateNumbers.generateLotto(getLottoQuantity());
    }

    private int getLottoQuantity(){
        return this.purchasePrice / 1000;
    }


    public List <UserLotto> getLottos(){
        return lottos;
    }

    public double getYieldOfLotto(double totalPrice){
        return (totalPrice / purchasePrice * 100);
    }


}
