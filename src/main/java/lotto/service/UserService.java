package lotto.service;

import lotto.domain.Money;
import lotto.domain.User;
import lotto.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final LottoService lottoService;

    public UserService(UserRepository userRepository, LottoService lottoService) {
        this.userRepository = userRepository;
        this.lottoService = lottoService;
    }

    public void saveUser(int money) {
        User user = new User(new Money(money));
        userRepository.save(user);
    }

    public int buyLotto() {
        User user = userRepository.find();
        return lottoService.sellTo(user);
    }
}
