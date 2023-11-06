package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoGameController {

    private Lotto lotto;
    User user;
    View view = new View();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void start() throws IOException {

        setUser();
        setLotto();
    }

    private void setLotto() {

        int lottoAmount = user.getAmountLotto();
        List<List<Integer>> allLottos = makeLottoNumbers(lottoAmount);
        
        for (List<Integer> numbers: allLottos){

            Lotto lotto = new Lotto(numbers);
        }

    }

    private List<List<Integer>> makeLottoNumbers(int lottoAmount) {

        List<List<Integer>> allNumbers = new ArrayList<>();

        for(int i = 0; i< lottoAmount;i++){

            allNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }

        return allNumbers;
    }

    private void setUser() throws IOException {

        view.printAskMoneyInput();

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int inputMoney = Integer.parseInt(tk.nextToken());

        user = new User(inputMoney);
    }

}
