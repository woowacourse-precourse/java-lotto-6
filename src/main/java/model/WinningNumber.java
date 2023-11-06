package model;

import java.util.ArrayList;
import java.util.List;
import util.NumberGenerator;

public class WinningNumber {

    NumberGenerator numberGenerator = new NumberGenerator();
    public List<Integer> number = new ArrayList<>();
    public WinningNumber(){
        setWinningNumber();
    }

    public void setWinningNumber(){
        number = numberGenerator.generate();
    }

}
