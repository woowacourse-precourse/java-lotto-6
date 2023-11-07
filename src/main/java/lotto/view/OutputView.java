package lotto.view;

import lotto.model.MyLottoNumber;
import lotto.model.MyLottoNumbers;

import static lotto.util.Phrase.OutputPhrase.BUY_HOWMUCH;

public class OutputView {


    public void printNumberOfLotto(int NumberOfLotto) {
        System.out.printf(BUY_HOWMUCH.printMessage(), NumberOfLotto);
    }

    public void printMyNumbers(MyLottoNumbers myLottoNumbers) {
        for(MyLottoNumber myLottoNumber : myLottoNumbers.getMyLottoNumbers()){
            System.out.println((myLottoNumber.toString()));
        }


    }
}