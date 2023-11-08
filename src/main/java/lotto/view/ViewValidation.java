package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewValidation implements ILottoInputValidation, IMoneyValidation, IBonusValidation{

    private final String DUPLICATIONERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final String LENGHTERROR = "[ERROR] 로또 번호의 크기는 6개여야 합니다.";
    private final String NUMBERERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final String MONEYSTRINGERROR = "[ERROR] 돈은 숫자여야 합니다.";
    private final String MONEYNULLERROR = "[ERROR] 돈을 투입해야합니다.";
    private final String MONEYUNITERROR = "[ERROR] 돈은 1000원 단위만 입력 가능합니다.";

    private final int LOTTOLENGHT = 6;
    private final int MONEYUNIT = 1000;
    private final int MAXRANGE = 45;
    private final int MINRANGE = 0;
    private final int ZERO = 0;
    private final int NINE = 0;


    @Override
    public void lottoLengthError(String str) throws IllegalArgumentException{
        if (stringToArrayList(str).size() != LOTTOLENGHT) {
            throw new IllegalArgumentException(LENGHTERROR);
        }
    }
    @Override
    public void lottoDuplictionError(String str) throws IllegalArgumentException {
        List<String> stringList  = stringToArrayList(str);
        Set<String> uniqeString = new HashSet<>(stringList);
        if (stringList.size() != uniqeString.size()) {
            throw new IllegalArgumentException(DUPLICATIONERROR);
        }
    }
    @Override
    public void lottoNumberError(String str) throws IllegalArgumentException {
        List<String> stringList  = stringToArrayList(str);
        stringList.stream()
                .filter(this::isNotRange)
                .findAny()
                .ifPresent( (string) -> { throw new IllegalArgumentException(NUMBERERROR); }
                );
    }

    private boolean isNotRange(String str) {
        int test;
        for (int i = 0 ; i< str.length();i++) {
            test = str.charAt(i) - '0';
            if (test < MINRANGE || test > MAXRANGE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void moneyUnitError(String str) throws IllegalArgumentException{
        int strToNumber = Integer.parseInt(str);
        if (strToNumber%MONEYUNIT != ZERO){
            throw new IllegalArgumentException(MONEYUNITERROR);
        }

    }
    @Override
    public void moneyNullError(String str) throws IllegalArgumentException{
        if (str.isEmpty()) {
            throw new IllegalArgumentException(MONEYNULLERROR);
        }
    }
    @Override
    public void moneyStringError(String str) throws IllegalArgumentException{
        int test;
        for (int i = 0 ; i< str.length();i++) {
            test = str.charAt(i) - '0';
            if (test < ZERO || test > NINE) {
                throw new IllegalArgumentException(MONEYSTRINGERROR);
            }
        }
    }
    private ArrayList<String> stringToArrayList(String str){
        String[] strList = str.split(",");
        return new ArrayList<String>(Arrays.asList(strList));
    }
}
