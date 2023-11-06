
## 📝 구현할 기능 목록

- Lotto Purchase
- Lotto Number Generation
- Winning Number Draw
- Winning Confirmation
- Input/Output Handling

## 🎮 게임 진행 방식 (UI)

1. 로또를 구매한다.
2. 당첨번호를 입력한다.
3. 보너스 번호를 입력한다.
4. 당첨 내역을 출력한다.
5. 총 수익률을 출력한다.

## 🚀 테스트

- [ ] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

## ♻️ 리펙터링

- [ ] indent(인덴트, 들여쓰기) depth를 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [ ] else 예약어를 쓰지 않는다. switch/case도 허용하지 않는다.
- [ ] Java Enum을 적용한다.
- [ ] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.(`test/java/lotto/LottoTest`를 참고)