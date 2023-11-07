package lotto.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLotto {
    private int price;
    private List<Integer> userLotto;
    private static final String BUY_PRICE_ERROR="[ERROR] 금액은 1000원 단위로 입력해주세요";
    private static final String LOTTO_LENGTH_ERROR="[ERROR] 로또 번호는 6개만 입력 해주세요";
    private static final String LOTTO_DUPLICATE_ERROR="[ERROR] 로또 번호를 중복해서 입력하지마세요";

    public UserLotto(String buyPrice,String userLottoNumber){
        setPrice(buyPrice);
        validateUserPriceLotto(price);
        userLotto = new ArrayList<>();
        setUserLotto(userLottoNumber);
        duplicateUserLotto(userLotto);
        validateSizeUserLotto(userLotto);
    }
    public void setPrice(String buyPrice){
        price = Integer.parseInt(buyPrice);
    }
    public int getPrice(){
        return price;
    }
    private void validateUserPriceLotto(int buyPrice){
        if (buyPrice % 1000 != 0){
            throw new IllegalArgumentException(BUY_PRICE_ERROR);
        }
    }
    public void setUserLotto(String userLottoNumber){
        String[] splitUserLotto = userLottoNumber.split(",");
        for (int i = 0; i < splitUserLotto.length; i++) {
            userLotto.add(Integer.parseInt(splitUserLotto[i]));
        }
    }
    private void validateSizeUserLotto(List<Integer> userLotto){
        if (userLotto.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR);
        }
    }
    private void duplicateUserLotto(List<Integer> userLotto){
        for (int i = 0; i < userLotto.size(); i++) {
            if(userLotto.contains(userLotto.get(i))){
                throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR);
            }
        }
    }
    public List<Integer> getUserLotto(){
        return userLotto;
    }
}
