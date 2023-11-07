package Domain;

import Domain.Lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonus;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    int getBonus(){
        return this.bonus;
    }
}
