package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.util.Validator;

public class View {
    public long inputLottoBuyCash(){
        String input=readLine();

        Validator.INSTANCE.numberValidate(input);

        return Long.parseLong(input);
    }

    public void printUserLottos(List<Lotto> userLottos){
        System.out.println(userLottos.size()+"개를 구매했습니다.");
        userLottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto){
        System.out.println(lotto.getNumbersMessage());
    }
}
