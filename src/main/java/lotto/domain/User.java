package lotto.domain;

public class User { //유저의 돈

    public static Integer PaperNumber(String input) {
        MoneyValidate(input);
        unitValidate(input);
        Integer paper = Integer.parseInt(input) / 1000;
        System.out.println(paper + "개를 구매했습니다.");
        return paper;
    }

    public static void MoneyValidate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
    public static void unitValidate(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            System.out.println("[ERROR] 1,000 단위로만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
