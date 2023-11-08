package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayLotto {

    private int amount;
    private List<Lotto> lottos;
    private Wining wining;
    private Referee referee;

    public PlayLotto() {
    }

    public void typeAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        validateAmount(price);
        amount = price / 1000;
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원의 배수여야 합니다.");
        }
    }

    public void buyLottos() {
        List<Lotto> games = new ArrayList<>();
        for (int i=0; i<amount; i++){
            games.add(buyLotto());
        }
        lottos = games;
    }

    private Lotto buyLotto(){
        List<Integer> game = new ArrayList<>();
        for (int i=0; i<6; i++){
            game.add(Randoms.pickNumberInRange(1, 45));
            validateDuplicated(game);
            Collections.sort(game);
        }
        return new Lotto(game);
    }

    private void validateDuplicated(List<Integer> game) {
        long size = game.stream().distinct().count();

        if (size != 6){
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumbers() {
        System.out.println(amount+"개를 구매했습니다.");

        for (int i=0; i<lottos.size(); i++){
            lottos.get(i).printLottoNumber();
        }
    }

    public void typeWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> line = Arrays.stream(Console.readLine().split("," ))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        wining.setWinningNumber(line);
    }

    public void typeBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        wining.setBonusNumber(Integer.parseInt(Console.readLine()));
    }

    public void printResult() {
        referee.printResult();
    }

    public void printRateOfReturn() {
        referee.calculateRateOfReturn();
    }
}
