package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.*;
import lotto.Application.Jackpot_Money;

public class Base_Func {

    public static int Input_Purchase_Price() {
        System.out.println("구입금액을 입력해 주세요.");
        String tmp_input = Console.readLine();
        int price = -1;
        try {
            price = Integer.parseInt(tmp_input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 오류 입니다.");
        }
        return price;
    }

    public static int Purchase_Lotto_Number(int price) {
        try {
            if (price % 1000 != 0) {
                throw new IllegalStateException("[ERROR] 로또 금액이 1000으로 나누어 지지 않습니다.");
            }
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }

        return price / 1000;
    }

    public static void Print_Purchased_Lotto_list(ArrayList<Lotto> Buy_lotto) {
        System.out.println("\n" + Buy_lotto.size() + "개를 구매했습니다.");
        for (Lotto buyLotto : Buy_lotto) {
            System.out.println(buyLotto.Get_numbers());
        }
    }

    public static List<Integer> Input_Win_Lotto_List() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        String tmp_input = Console.readLine();
        String[] tmp_arr = tmp_input.split(",");
        List<Integer> ret_list = new ArrayList<>();
        try {
            for (String num : tmp_arr) {
                int tmp_num = Integer.parseInt(num);
                ret_list.add(tmp_num);
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 오류 입니다.");
        }

        return ret_list;
    }

    public static int Input_Win_Lotto_Bonus_number() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String tmp_input = Console.readLine();
        int price = -1;
        try {
            price = Integer.parseInt(tmp_input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 오류 입니다.");
        }
        return price;
    }

    public static void Print_Jackpot_List(int[] Jackpot_list) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + Jackpot_list[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + Jackpot_list[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Jackpot_list[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Jackpot_list[7]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Jackpot_list[6] + "개");
    }

    public static void Print_Earning_Rate(int[] Jackpot_list, int purchase_num) {
        int money = 0;
        money += Jackpot_Money.JP_3.get_money() *Jackpot_list[3];
        money += Jackpot_Money.JP_4.get_money() *Jackpot_list[4];
        money += Jackpot_Money.JP_5.get_money() *Jackpot_list[5];
        money += Jackpot_Money.JP_6.get_money() *Jackpot_list[6];
        money += Jackpot_Money.JP_7.get_money() *Jackpot_list[7];
        double rate = (double) money /purchase_num*100;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("총 수익률은 "+ df.format(rate) +"%입니다.");
    }
}
