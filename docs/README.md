# :notebook_with_decorative_cover: 우아한테크코스 프리코스 3주차 : 로또

## 목차

- [1. 구현 기능 목록](#ballotboxwithcheck-구현-기능-목록)
- [2. 문제 해결 과정](#bookmark_tabs-문제-해결-과정)
- [3. 다음 미션에 적용할 학습 내용](#ledger-다음-미션에-적용할-학습-내용)

# :ballot_box_with_check: 구현 기능 목록
- [ ] controller Package
    - [ ] LottoController
        - view Package와 domain Package의 데이터를 전달하며 값을 출력하는 클래스
        - 프로그램을 실행하는 `run` 메서드


- [ ] domain Package
    - [ ] LottoJudge
        - 당첨 번호와 구매 번호의 매칭을 판단하는 클래스
    - wrapper Package 
        - [ ] Money
            - 구입 금액에 대한 유효성 검사와 구입 금액에 따른 티켓 수 반환을 진행하는 클래스
            - 객체를 생성하고 반환하는 create 메서드
            - 구입 금액이 0원 이하인지 확인하는 `validateMoney` 메서드
            - 구매 금액에 따른 티켓 수를 반환하는 `getTicket` 메서드
        - [ ] Lotto
            - 모든 로또 번호 리스트들에 대한 유효성 검사와 로또 번호의 오름차순 값을 반환하는 일급 컬렉션
            - 객체를 생성하고 반환하는 create 메서드
            - 로또 번호가 6개 맞는지 확인하는 `validateSize` 메서드
            - 중복되는 로또 번호가 있는지 확인하는 `validateDuplicate` 메서드
            - 로또 번호가 1 ~ 45 사이의 숫자가 맞는지 확인하는 `validateRange` 메서드
            - 로또 번호의 오름차순 값을 반환하는 `sortLottoNumbers` 메서드
        - [ ] BuyLottos
            - 구입한 로또에 대한 정보를 갖고있는 클래스
            - 객체를 생성하고 반환하는 create 메서드
            - 구매한 로또를 반환하는 `getBuyLottos` 메서드
        - [ ] LottoWithBonus
            - 당첨 로또와 보너스 번호에 대한 유효성 검사와 반환을 진행하는 클래스 
            - 객체를 생성하고 반환하는 create 메서드
            - 로또 번호와 보너스 번호가 중복되는지 확인하는 `validateDuplicate` 메서드
            - 보너스 번호가 1 ~ 45 사이인지 확인하는 `validateRange` 메서드
            - 로또 객체를 반환하는 `getLotto` 메서드
            - 보너스 번호를 반환하는 `getBonusNumber` 메서드


- [ ] handler Package
    - [ ] InputHandler
        - view Package의 ConsoleInput의 확장성과 변경 용이성을 위한 인터페이스
        - `inputMoney` 메서드의 추상화
        - `inputWinningLotto` 메서드의 추상화
        - `inputBonusLotto` 메서드의 추상화
    - [ ] OutputHandler
        - view Package의 ConsoleOutput의 확장성과 변경 용이성을 위한 인터페이스
        - `printInputMoneyMessage` 메서드의 추상화
        - `printBuyLottoList` 메서드의 추상화
        - `printInputWinningLottoMessage` 메서드의 추상화
        - `printInputBonusLottoMessage` 메서드의 추상화
        - `printLottoResult` 메서드의 추상화
        - `printProfit` 메서드의 추상화
    - [ ] ErrorHandler
        - Enum 클래스를 활용하여 프로그램에서 발생하는 에러 코드들을 관리하는 클래스
        - ErrorMessage와 함께 `IllegalArgumentException` 예외를 발생시키는 `getException` 메서드
    - [ ] ConstantsHandler
        - 프로그램내의 상수들을 관리하는 클래스
    - [ ] InputValidator
        - 입력에 대한 유효성 검사를 관리하는 클래스
    - [ ] LottoHandler
        - 로또 당첨 상태를 Enum으로 관리하는 클래스


- [ ] service Package
    - [ ] LottoService
        - 로또 게임에 대한 비즈니스 로직을 담당하는 클래스


- [ ] view Package
    - [ ] ConsoleInput
        - 입력을 담당하는 클래스
        - 로또 구입 금액을 입력하는 `inputMoney` 메서드 구현
        - 당첨 번호를 입력하는 `inputWinningLotto` 메서드 구현
        - 보너스 번호를 입력하는 `inputBonusLotto` 메서드 구현
        - string 타입을 List 컬렉션 타입으로 변환하는 `stringToList` 메서드 구현
        - string 타입을 int 타입으로 변환하는 `stringToInt` 메서드 구현
    - [ ] ConsoleOutput
        - 출력을 담당하는 클래스
        - 로또 구입 금액 입력을 요청하는 `printInputMoneyMessage` 메서드 구현
        - 구입한 로또 리스트를 보여주는 `printBuyLottoList` 메서드 구현
        - 당첨 번호 입력을 요청하는 `printInputWinningLottoMessage` 메서드 구현
        - 보너스 번호 입력을 요청하는 `printInputBonusLottoMessage` 메서드 구현
        - 당첨 통계를 보여주는 `printLottoResult` 메서드 구현
        - 수익률을 보여주는 `printProfit` 메서드 구현

---

# :bookmark_tabs: 문제 해결 과정

---

# :ledger: 다음 미션에 적용할 학습 내용