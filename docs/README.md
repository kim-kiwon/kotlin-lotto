## Kotlin-Lotto
### Todo
- [x] Add LottoGenerator
- [x] Add UserViewer
- [ ] Add UserInputHandler that receive money, winning number and bonus number
- [ ] Add LottoResult
- [ ] Add LottoResults
- [ ] Add lottoComparator

### 책임 분배
- LottoGenerator
  - 유틸성 클래스. 랜덤한 로또 넘버를 생성한다.
  - 로또 넘버는 Lotto 타입으로 반환한다
- UserViewer
  - 유틸성 클래스. 사용자에게 메시지를 출력한다
- UserInputHandler
  - 유틸성 클래스. 사용자 입력을 받아 처리한다.
- LottoComparator
  - 당첨 번호를 필드로 갖는다.
  - 사용자 입력과 당첨번호를 비교하여 결과를 반환한다.
  - 결과는 LottoResult 형태로 반환한다.
- LottoResult
  - 로또 당첨결과 Enum
  - FIRST, SECOND, ... NONE 을 갖는다
- LottoResults
  - LottoResult 를 저장하는 일급 컬렉션
  - toString 에서 결과 통계를 출력한다