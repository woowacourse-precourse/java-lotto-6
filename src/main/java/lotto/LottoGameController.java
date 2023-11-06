package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LottoGameController {

    private List<Lotto> lottos = new ArrayList<>();
    User user;
    View view = new View();



    public void start(){

        setUser();
        setLotto();
    }

    private void setLotto() {

        int lottoAmount = user.getAmountLotto();
//        List<List<Integer>> allLottos = makeLottoNumbers(lottoAmount);
        view.printPurchasedLottoAmount(lottoAmount);

        for (int i = 0; i<lottoAmount;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));

            view.printPurchasedLottoNumbers(lottos.get(i));

        }
    }

//    private List<List<Integer>> makeLottoNumbers(int lottoAmount) {
//
//        List<List<Integer>> allNumbers = new ArrayList<>();
//
//        for(int i = 0; i< lottoAmount;i++){
//
//            allNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
//        }
//
//        return allNumbers;
//    }

    private void setUser() {
        Scanner sc = new Scanner(System.in);

        view.printAskMoneyInput();

        StringTokenizer tk = new StringTokenizer(sc.next());
        int inputMoney = Integer.parseInt(tk.nextToken());

        user = new User(inputMoney);
    }

}
