package lotto.model;

import camp.nextstep.edu.missionutils.Console;

public class UserWallet {

    private final UserWalletValidator userWalletValidator= new UserWalletValidator();
    private int myMoney;
    UserWallet(){
        System.out.println("구입금액을 입력해 주세요.");
        myMoney = validateMoney(Console.readLine());
    }

    public int buyLotto(){
        return useMoney(myMoney);
    }

    private int useMoney(int usedMoney){
        myMoney -= usedMoney;
        return usedMoney;
    }

    private int validateMoney(String validateLine){
//        userWalletValidator.;
        return 0;
    }







}
