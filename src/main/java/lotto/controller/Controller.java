package lotto.controller;

import lotto.service.*;
import lotto.view.Input_View;
import lotto.view.Output_View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class Controller {
    public Controller() {

    }

    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lotto_List;
    private static PlayerTickets playerTickets;
    private static Stats stats;

    private static final int lotto_purchase_unit = 1000;
    private static final int percent = 100;

    public void run() {
        try {
            play();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public int input_amount() {
        playerTickets = new PlayerTickets(Input_View.input_lotto_purchase_amount());
        return playerTickets.divide_per_lotto_purchase_unit();
    }

    public void play() {
        int count_tickets = input_amount();
        Output_View.print_ticket_counts(count_tickets);

        lotto_List = create_lotto_List(count_tickets);
        stats = check_bonus();

        total_result(lotto_List, stats, count_tickets);
    }

    private static Lotto create_lotto() {
        PickRandomNumbers pickRandomNumbers = new PickRandomNumbers();
        lotto = new ArrayList<>();

        lotto = pickRandomNumbers.pick_ticket();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private static List<Lotto> create_lotto_List(int count_tickets) {
        lotto_List = new ArrayList<>();
        for (int i = 0; i < count_tickets; i++) {
            lotto_List.add(create_lotto());
        }
        return lotto_List;
    }

    public Stats check_bonus() {
        Lotto lotto = new Lotto(Input_View.input_lotto_winning_numbers());
        List<Integer> winning_numbers = lotto.get_lotto_numbers();

        int bonus = Input_View.input_lotto_bonus_number();
        lotto.validate_bonus_number(winning_numbers,bonus);
        stats = new Stats(new Lotto(winning_numbers), bonus);

        return stats;
    }

    private void total_result(List<Lotto> lotto_List, Stats winning_stats, int amount) {
        Map<Prizes, Integer> result = create_result();
        Prizes prize;

        Output_View.print_winning_stat_message();
        for (int i = 0; i < lotto_List.size(); i++) {
            prize = winning_stats.check_match(lotto_List.get(i));
            result.put(prize, result.get(prize) + 1);
        }
        print_result(result);
        print_earning_rate(result, amount);
    }

    private void print_earning_rate(Map<Prizes, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Prizes rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.get_count_prize_numbers()) / (lottoAmount * lotto_purchase_unit) * (result.get(
                            rank)) * (percent));

        }
        Output_View.print_earning_rate(EarningRate);
    }


    private Map<Prizes, Integer> create_result() {
        Map<Prizes, Integer> result = new LinkedHashMap<>();

        for (Prizes prize : Prizes.values()) {
            result.put(prize, 0);
        }
        return result;
    }

    private void print_result(Map<Prizes, Integer> result) {
        for (int i = Prizes.values().length - 1; i >= 0; i--) {
            Prizes.values()[i].print_MESSAGE(result.get(Prizes.values()[i]));
        }
    }


}
