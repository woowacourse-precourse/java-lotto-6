package constant;

public enum ConfigMessage {
    DELIMITER(","),
    FIFTH_MATCH("3개 일치 (5,000원) - %d개"),
    FOURTH_MATCH("4개 일치 (50,000원) - %d개"),
    THIRD_MATCH("5개 일치 (1,500,000원) - %d개"),
    SECOND_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_MATCH("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    ConfigMessage(String message){
        this.message = message;
    }

    public String getValue(){
        return message;
    }
    @Override
    public String toString(){
        return message;
    }
}
