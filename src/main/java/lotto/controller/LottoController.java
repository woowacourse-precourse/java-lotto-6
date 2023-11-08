package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.model.CreateLotto;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.User;
import lotto.model.Winning;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private Lotto lotto;
    private User user;
    private List<Lotto> lotto_list;
    private static Winning winning;
    private final int MIN_PRICE = 1000;
    private final int PERCENTAGE = 100;

    public LottoController() {
    }

    public void run() {
        while (true) {
            try {
                start();
                return;
            } catch (IllegalArgumentException e) {

            }
        }

    }

    public void start() {
        int ticket_amount = User_Amount();
        Output.show_Ticket_Count(ticket_amount);
        lotto_list = make_Lotto_List(ticket_amount);
        winning = Winning_Numbers();
        lotto_Result(lotto_list, winning, ticket_amount);
    }

    public int User_Amount() {
        try {
            user = new User(Input.set_Price());
            return user.calculate_Count();
        } catch (IllegalArgumentException e) {
            return User_Amount();
        }

    }

    private List<Lotto> make_Lotto_List(int ticket) {

        List<Lotto> temp_lotto_list = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            temp_lotto_list.add(make_Lotto());
        }
        return temp_lotto_list;

    }

    private Lotto make_Lotto() {
        CreateLotto create = new CreateLotto();
        List<Integer> temp_lotto = new ArrayList<>();

        temp_lotto = create.set_Lotto();
        System.out.println(temp_lotto);
        return new Lotto(temp_lotto);

    }

    private Winning Winning_Numbers() {
        Lotto winning_lotto = new Lotto(Input.set_Number());
        List<Integer> winning_list = winning_lotto.getLotto();

        int bonus = Input.set_Bonus();
        winning_lotto.validate_Bonus(winning_list, bonus);
        Winning temp_winning = new Winning(new Lotto(winning_list), bonus);
        return temp_winning;
    }

    public void lotto_Result(List<Lotto> lotto_list, Winning winning, int amount) {
        Map<Result, Integer> map = set_Result();
        Result result;
        Output.show_Calcultate();
        for (int i = 0; i < lotto_list.size(); i++) {
            result = winning.match(lotto_list.get(i));
            map.put(result, map.get(result) + 1);
        }
        printResult(map);
        printEarningRate(map, amount);
    }

    private void printResult(Map<Result, Integer> map) {
        for (int i = Result.values().length - 1; i >= 0; i--) {
            Result.values()[i].show_Result(map.get(Result.values()[i]));
        }
    }

    private void printEarningRate(Map<Result, Integer> map, int lottoAmount) {
        double earn = 0.0;
        for (Result r : map.keySet()) {
            earn += ((double) (r.get_Price()) / (lottoAmount * MIN_PRICE) * (map.get(
                    r)) * (PERCENTAGE));

        }
        Output.show_Profit_Rate(earn);
    }

    public Map<Result, Integer> set_Result() {
        Map<Result, Integer> map = new LinkedHashMap<>();
        for (Result r : Result.values()) {
            map.put(r, 0);
        }
        return map;
    }
}
