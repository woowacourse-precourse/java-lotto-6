package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoGameController {

    private Lotto lotto;
    private User user;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void start() throws IOException {

        setUser();
    }

    private void setUser() throws IOException {
        int lottoPurchaseMoney = getMoneyInput();
        user = new User(lottoPurchaseMoney);
    }

    private int getMoneyInput() throws IOException {

        String moneyInputErrorWarning = "[ERROR]로또 구입 금액으로 1000원 단위 이하는 입력 불가.";

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int lottoPurchaseMoney = Integer.parseInt(tk.nextToken());

        if(lottoPurchaseMoney%1000!=0) {
            throw new IllegalArgumentException(moneyInputErrorWarning);
        }

        return lottoPurchaseMoney;
    }
}
