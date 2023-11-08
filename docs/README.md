# ✅ 기능 구현 리스트

### 🔍 핵심기능
- [X] 로또 구입 금액 입력
  - [X] 1000원 단위 입력값 검증
- [X] 당첨 번호 및 보너스 번호 입력
  - [X] 당첨번호 입력값 검증, 번호는 쉼표 구 
- [X] 당첨 내역 및 수익률 출력 -> 로또 게임 종료
- [X] 사용자의 잘못된 입력값 검증
  - [X] ERROR로 시작되는 에러메시지
  - [X] ```IllegalArgumentException``` 또는 ```IllegalStateException```과 같은 명확한 유형의 예외처리
  - [X] 틀린 곳부터 다시 입력받기

### 🔍 프로그래밍 요구사항
- [X] ```Random``` 및 ```Console``` API 활용
   - [X] ```pickUniqueNumbersInRange()``` 활용
   - [X] ```readLine()``` 활용
- [X] 제공된 ```Lotto``` 클래스 활용 구현
- [X] 도메인 로직에 단위테스트 구현