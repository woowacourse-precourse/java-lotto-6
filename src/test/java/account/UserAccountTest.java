package account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserAccountTest {
    @ParameterizedTest
    @ValueSource(ints = {1001, 10002, 100003})
    void accountValidate_should_be_divided_by_1000(int invalidAccount) {
        assertThatThrownBy(() -> new UserAccount(invalidAccount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000, 2000, 20000, 3000, 30000})
    void lottoGame_trial_count(int inputMoney) {
        UserAccount userAccount = new UserAccount(inputMoney);
        assertThat(userAccount.getTrialCount()).isEqualTo(inputMoney / 1000);
    }
}