package model;


import java.util.ArrayList;

public class WinningNumber {

    ArrayList<Integer> winningNumber = new ArrayList<>();
    int bonusNumber;

    public WinningNumber(String[] winningNumberString){
        changeToArrayList(winningNumberString);
    }

    public void changeToArrayList(String[] winningNumberString){
        for(String numberString : winningNumberString){
            int number = Integer.parseInt(numberString);
            this.winningNumber.add(number);
        }
    }

    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }
}
