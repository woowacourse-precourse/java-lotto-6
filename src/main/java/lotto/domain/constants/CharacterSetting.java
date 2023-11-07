package lotto.domain.constants;

public enum CharacterSetting {
    INPUT_DELIMITER(",");

    private final String settingCharacter;

    CharacterSetting(String settingCharacter) {
        this.settingCharacter = settingCharacter;
    }

    public String getCharacter() {
        return settingCharacter;
    }
}
