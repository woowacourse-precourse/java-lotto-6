package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayLotto {

    private List<Lotto> lottos;
    private Wining wining;
    private Referee referee;

    public PlayLotto() {
    }

    public int typeAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원의 배수여야 합니다.");
        }
    }

    public List<Lotto> buyLottos(int amount) {
        List<Lotto> games = new ArrayList<>();
        for (int i=0; i<amount; i++){
            games.add(buyLotto());
        }
        return games;
    }

    private Lotto buyLotto(){
        List<Integer> game = new ArrayList<>();
        for (int i=0; i<6; i++){
            game.add(Randoms.pickNumberInRange(1, 45));
        }
        return new Lotto(game);
    }

    public void printLottoNumbers() {
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
