# 로또 게임

## 기능 목록

1. ~~로또 구입 금액 입력 - view - InputView - purchasingAmount~~
2. ~~1000원 단위 아니면 오류 발생 - Model - Purchase - validateUnit~~
3. ~~테스트 코드 구현~~
3. ~~문자 입력시 오류 발생 - Model - Purchase - validateNum~~
4. ~~테스트 코드 구현~~
3. ~~로또 구입 개수 확인 - Model - Purchase - pieces~~
4. ~~테스트 코드 구현~~
3. ~~1 ~ 45 숫자 중 중복 없는 6개의 숫자 List에 생성 - Modle - RandomLotto - generateNum~~
4. ~~랜덤 숫자 정렬하기 - Model - RandomLotto - listSort~~
5. ~~테스트 코드 구현~~
6. ~~구매 개수 출력 - View - outputView - purchasePieces~~
4. ~~로또 구매 번호 출력 - View - outputView - purchaseNum~~
5. ~~당첨번호 입력 - View - inputView - winNum~~
6. ~~쉼표로 분리된 숫자 Integer로 변환 후 list에 담기~~
6. ~~Lotto클래스로 당첨번호 6자리인지 확인 - Model - Lotto - validate~~
6. 당첨번호 HashSet에 넣기 - Model - Lotto - winNumIntersection
7. 보너스 번호 입력 - View - inputView - bonusNum
8. 보너스 번호 1개 List에 넣기 - Model - Lotto - bonusNumIntersection
9. 당첨번호랑 로또번호 비교하기 Set교집합 - Model - Lotto - winNumIntersection
10. 당첨번호랑 보너스번호 비교하기 list contain - Model - Lotto - bonusNumIntersection
11. 당첨 통계 계산 - Model - Result - statistics
10. 당첨 통계 출력 - View - outputView - statistics
11. 수익률 계산 - Model - Result - profit
11. 수익률 출력 - View - output - profit



## 기능 요구 사항

로또 번호의 숫자 범위는 1~45까지이다.

1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.

당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

1등: 6개 번호 일치 / 2,000,000,000원

2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원

3등: 5개 번호 일치 / 1,500,000원

4등: 4개 번호 일치 / 50,000원

5등: 3개 번호 일치 / 5,000원

로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.

로또 1장의 가격은 1,000원이다.

당첨 번호와 보너스 번호를 입력받는다.

사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역

수익률을 출력하고 로또 게임을 종료한다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고

"[ERROR]"로 시작하는 에러 메시지를 출력 

그 부분부터 입력을 다시 받는다.

Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.