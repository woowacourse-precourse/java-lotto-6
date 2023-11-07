package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import lotto.model.MyLottoNumber;
public class MyLottoNumbers {

    private final List<MyLottoNumber> myLottoNumbers;

    private MyLottoNumbers(int NumberOfLotto){
        List<MyLottoNumber> myLottoNumbers = addMyNumbers(NumberOfLotto);
        this.myLottoNumbers = myLottoNumbers;
    }

    public static MyLottoNumbers generateLottoList(int NumberOfLotto){
        return new MyLottoNumbers(NumberOfLotto);
    }

    private List<MyLottoNumber> addMyNumbers(int NumberOfLotto){
        List<MyLottoNumber> myLottoNumbers = new ArrayList<>();
        for(int i = 0 ; i < NumberOfLotto ; i++){
            myLottoNumbers.add(MyLottoNumber.generateLotto());
        }
        return myLottoNumbers;
    }

    public List<MyLottoNumber> getMyLottoNumbers(){
        return Collections.unmodifiableList(myLottoNumbers);
    }


}
