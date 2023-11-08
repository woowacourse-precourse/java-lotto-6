package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.awt.font.GlyphJustificationInfo;
import java.text.DecimalFormat;
import java.util.*;
import lotto.Application.Jackpot_Money;

public class Base_Func {

    public static int Input_Purchase_Price_Return_Number() {
        System.out.println("구입금액을 입력해 주세요.");
        String tmp_input = Console.readLine();
        int price = -1;
        try {
            price = Integer.parseInt(tmp_input);
            if (price % 1000 != 0) {
                throw new IllegalStateException("[ERROR] 로또 금액이 1000으로 나누어 지지 않습니다.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 오류 입니다.\n");
            return Input_Purchase_Price_Return_Number();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return Input_Purchase_Price_Return_Number();
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
        List<Integer> win_list = new ArrayList<>();
        try {
            for (String num : tmp_arr) {
                win_list.add(Integer.parseInt(num));
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 오류 입니다.");
            return Input_Win_Lotto_List();
        }
        return Lotto_List_Number_Check(win_list);
    }

    public static List<Integer> Lotto_List_Number_Check(List<Integer> list){
        try {
            for(int i=0;i <list.size(); i++){
                if (list.get(i) < 1 || list.get(i) > 45)
                    throw new IllegalArgumentException("[ERROR] 1~45 범위를 벗어난 입력이 있습니다.");
                for(int t=i+1; t<list.size(); t++){
                    if(list.get(i) == list.get(t))
                        throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Input_Win_Lotto_List();
        }
        return list;
    }

    public static int Input_Win_Lotto_Bonus_number() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String tmp_input = Console.readLine();
        int bonus_num = -1;
        try {
            bonus_num = Integer.parseInt(tmp_input);
            if(bonus_num<1 || bonus_num>45){
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 오류 입니다.");
            return Input_Win_Lotto_Bonus_number();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 1~45 범위를 벗어난 입력입니다.");
            return Input_Win_Lotto_Bonus_number();
        }
        return bonus_num;
    }

    public static void Print_Jackpot_List(int[] Jackpot_list) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + Jackpot_list[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + Jackpot_list[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Jackpot_list[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Jackpot_list[7] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Jackpot_list[6] + "개");
    }

    public static void Print_Earning_Rate(int[] Jackpot_list, int purchase_num) {
        int money = 0;
        money += Jackpot_Money.JP_3.get_money() * Jackpot_list[3];
        money += Jackpot_Money.JP_4.get_money() * Jackpot_list[4];
        money += Jackpot_Money.JP_5.get_money() * Jackpot_list[5];
        money += Jackpot_Money.JP_6.get_money() * Jackpot_list[6];
        money += Jackpot_Money.JP_7.get_money() * Jackpot_list[7];
        if (money == 0) {
            System.out.println("총 수익률은 0.0%입니다.");
            return;
        }

        double rate = ((double) money) / ((double) purchase_num) * 100;
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("총 수익률은 " + df.format(rate) + "%입니다.");
    }

    /* 문제를 잘못 읽고 구현한 부분 이지만 나중에 한번 리마인드를 위해 남겨 둔다.
    public static String Earning_Rate_Float_to_String(double rate) {
        DecimalFormat df = new DecimalFormat("0.00");
        String tmp_str = df.format(rate);
        if (tmp_str.charAt(tmp_str.length() - 1) - '0' == 0) {
            tmp_str = tmp_str.substring(0, tmp_str.length() - 1);

            if (tmp_str.charAt(tmp_str.length() - 1) - '0' == 0) {
                tmp_str = tmp_str.substring(0, tmp_str.length() - 2);
            }
        }
        return tmp_str;
    }*/
}
