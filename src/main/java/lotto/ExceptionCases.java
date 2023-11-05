package lotto;

public class ExceptionCases {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public boolean LottoPriceCheck(String s){
        int i;
        if( CheckBlank(s)){
            return true;
        }
        try {
            i = Integer.parseInt(s);
        }catch (NumberFormatException e){
            return CheckFormat();
        }
        if(CheckZeroMinus(i)){
            return true;
        }
        return CheckPrice(i);
    }
    public boolean CheckBlank(String s){
        if(s.isBlank()){
            try {
                throw new IllegalArgumentException(ERROR_MESSAGE + "공백은 입력할 수 없습니다.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }
    private boolean CheckFormat() {
        try {
            throw new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 형식의 입력입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
    public boolean CheckPrice(int i){
        if(i%1000!=0){
            try {
                throw new IllegalArgumentException(ERROR_MESSAGE + "구입금액은 1000원 단위입니다.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return true;
            }
        }

        return false;
    }
    public boolean CheckZeroMinus(int i){
        if(i<=0){
            try {
                throw new IllegalArgumentException(ERROR_MESSAGE + "구입금액이 옳지 않습니다.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }
}

