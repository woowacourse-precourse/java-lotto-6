## View 생성
inputView
- 구입금액 입력 받기
- 당첨 번호 입력 받기
- 보너스 번호 입력 받기

outputView
- 빈칸 출력
- 발행한 로또 개수 출력
- 발행된 로또 리스트 출력
- 에러메시지를 받아 출력
- "당첨 통계", "---" 출력
- "Result"의 값을 받아 결과값 출력

## 구입금액을 통한 로또 생성
MyLotto
- "Service package"에 랜덤값 생성 클래스와 로직
- "LottoController"에 로또 발급 로직 작성 ("Lotto", "Issuance" 클래스를 통해)
- 오름차순으로 로또를 "MyLotto"에 리스트에 담아줌
- 리스트의 값을 출력해주는 메서드와 발행한 로또 개수를 "outputView"에서 가져와서 출력