package lotto;
public class PriceValidator {
    private LottoGame lg = new LottoGame();
    public boolean validateNumber(String number){
        try{
            isNumber(number);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] 숫자만을 입력해야합니다.");
            lg.start();
            return false;
        }
        return true;
    }
    public void isNumber(String number){
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i)<48 || number.charAt(i)>57) throw new IllegalArgumentException();
        }
    }
    public boolean validateThousands(int number){
        try{
            isThousands(number);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] 1000원 단위로 입력해야합니다.");
            lg.start();
            return false;
        }
        return true;
    }
    public void isThousands(int number){
        if(number % 1000 != 0) throw new IllegalArgumentException();
    }
}
