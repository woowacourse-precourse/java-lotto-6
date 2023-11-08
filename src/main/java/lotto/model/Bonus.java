package lotto.model;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


    public boolean isMatchingBonus(MyLottoNumber myLottoNumber){
        return myLottoNumber.getMyLottoNumber().contains(this.bonusNumber);
    }
}