package lotto.service;

public class Stats {

    private final int bonus;
    private final Lotto lotto;

    public Stats(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Prizes check_match(Lotto player_number) {
        int count_match_numbers = player_number.count_match_winning_numbers(lotto);
        boolean check_bonus = player_number.check_contain_numbers(bonus);
        return Prizes.return_prize(count_match_numbers,check_bonus);
    }
}
