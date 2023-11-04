package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Validator {
    private LottoGame lg;
    public boolean validatePriceNumber(String number, LottoGame lg){
        this.lg = lg;
        try{
            isNumber(number);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] 숫자만을 입력해야합니다.");
            lg.start(lg);
            return false;
        }
        return true;
    }
    public void isNumber(String number){
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i)<48 || number.charAt(i)>57) throw new IllegalArgumentException();
        }
    }
    public boolean validateThousands(int number, LottoGame lg){
        this.lg = lg;
        try{
            isThousands(number);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] 1000원 단위로 입력해야합니다.");
            lg.start(lg);
            return false;
        }
        return true;
    }
    public void isThousands(int number){
        if(number % 1000 != 0) throw new IllegalArgumentException();
    }
    public boolean validateWinningNumber(String number, LottoGame lg){
        this.lg = lg;
        try{
            isNumberAndComma(number);
            isLottoNumber(number);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] 1~45사이의 숫자 6개를 ,로 구분하여 입력하여야합니다.");
            lg.pickWinningNumber();
            return false;
        }
        return true;
    }
    public void isNumberAndComma(String number){
        for(int i = 0; i < number.length(); i++){
            if(!(number.charAt(i) == 44 || (number.charAt(i)<=57 && number.charAt(i)>=48))){
                throw new IllegalArgumentException();
            }
        }
    }
    public void isLottoNumber(String number){
        StringTokenizer st = new StringTokenizer(number,",");
        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            int lottoNumber = Integer.parseInt(st.nextToken());
            list.add(lottoNumber);
        }
        new Lotto(list);
    }
    public boolean validateBonusNumber(String number, LottoGame lg){
        this.lg = lg;
        try {
            isNumber(number);
            int num = Integer.parseInt(number);
            if(num > 45 || num < 1) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR]1~45 사이의 숫자만 입력해주세요.");
            lg.pickBonusNumber();
            return false;
        }
        return true;
    }
}
