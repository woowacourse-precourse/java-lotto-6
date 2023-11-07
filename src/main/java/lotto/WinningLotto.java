package lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    private int bonus;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    void setBonus(int bonus){
        this.bonus = bonus;
    }

    int getBonus(){
        return this.bonus;
    }
}
