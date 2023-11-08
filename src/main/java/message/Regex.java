package message;

public enum Regex {
    ONLYNUMBER("^[0-9]*$"),
    ONETOFOURTYFIVE("^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$*$");
    private final String regex;
    Regex(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
