package lotto.model;

public class UserLottoUtil {
    private static final String LOTTO_TYPE_ERROR="[ERROR]숫자만을 입력해주세요";
    public int validateNumber(String number){
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new NumberFormatException(LOTTO_TYPE_ERROR);
        }
    }

}
