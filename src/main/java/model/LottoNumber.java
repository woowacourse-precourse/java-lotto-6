package model;

import java.util.ArrayList;
import java.util.List;
import util.NumberGenerator;

public class LottoNumber {

    NumberGenerator numberGenerator = new NumberGenerator();
    public List<Integer> number = new ArrayList<>();
    public LottoNumber(){
        CreateLottoNumber();
    }

    public void CreateLottoNumber(){
        number = numberGenerator.generate();
    }

}
