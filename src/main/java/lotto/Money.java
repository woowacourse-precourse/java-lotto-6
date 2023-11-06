package lotto;

import lotto.constant.Constant;

import static lotto.common.Common.strToInt;

public class Money {

    int val;

    private void vaildMoney(int money){
        int remain = money % 1000;

        if (remain != 0) {
            throw new IllegalArgumentException(Constant.error
                    + Constant.invaildMoney);
        }
    }


    private void vaildString(String s){
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(Constant.error
                        + Constant.notNumber);
            }
        }
    }

    public Money(){
        String strMoney = UserInput.inputMoney();

        vaildString(strMoney);
        int money = strToInt(strMoney);
        vaildMoney(money);
        this.val = money;
    }
}
