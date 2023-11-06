package lotto;

public class Application {
    public static void main(String[] args) {
        UserInput input = new UserInput();
        int money = -1, bonus;
        UserLotto user;
        Lotto winLotto;
        Lottery LT;

        money = input.Money();
        user = new UserLotto(money / 1000);
        user.showUser();
        winLotto = input.WinLotto();
        bonus = input.Bonus(winLotto);
        LT = new Lottery(winLotto, bonus, user, money);
        LT.showResult();
    }
}
