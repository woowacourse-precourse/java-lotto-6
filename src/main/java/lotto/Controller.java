package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private final Service service;
    static int bonusNum;

    public Controller() {
        this.service = new Service();
    }

    public void buyingLotto() {
        System.out.println("구입금액을 입력해 주세요");
        int price = Integer.parseInt(Console.readLine());
        int amount= price/1000;
        System.out.println(amount+"개를 구매했습니다.");
        List<List<Integer>> lottoNum = service.lottoDraw(amount);
        for (List<Integer> num : lottoNum) {
            System.out.println("[" + num.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]");
        }
    }

    public Lotto drawLottoWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] split = Console.readLine().split(",");
        System.out.println("보너스 번호를 입력해 주세요");
        bonusNum = Integer.parseInt(Console.readLine());
        return service.saveWinningNumbers(split);
    }
}