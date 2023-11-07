package lotto.Model;

public class Prize {
    public static String getPrize(String key) {
        switch (key) {
            case "3":
                return "5,000";
            case "4":
                return "50,000";
            case "5":
                return "1,500,000";
            case "5.1":
                return "30,000,000";
            case "6":
                return "2,000,000,000";
            default:
                return "0";
        }
    }
}
