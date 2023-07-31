# KMS Sample

AWS Encryption SDK는 산업 표준과 모범 사례를 이용하여 모든 사람이 쉽게 데이터를 암호화하고 암호화 해제할 수 있도록 설계된 클라이언트 측 암호화 라이브러리입니다. 데이터를 가장 잘 암호화하고 해독하는 방법보다는 애플리케이션의 핵심 기능에 집중할 수 있습니다. AWS Encryption SDK는 Apache 2.0 라이선스에 따라 무료 제공됩니다.

AWS Encryption SDK는 사용자를 위해 다음과 같은 질문에 답해 줍니다.

- 어떤 암호화 알고리즘을 사용해야 합니까?
- 알고리즘은 어떻게, 또는 어떤 모드에서 사용해야 합니까?
- 암호화 키를 생성하려면 어떻게 해야 합니까?
- 암호화 키를 보호하려면 어떻게 해야 하며 어디에 저장해야 합니까?
- 암호화된 데이터를 이동하려면 어떻게 해야 합니까?
- 의도한 수신자가 암호화된 데이터를 읽을 수 있도록 하려면 어떻게 해야 합니까?
- 암호화된 데이터가 쓰여진 시점과 읽기 시점 사이에 수정되지 않도록 하려면 어떻게 해야 합니까?
- 데이터 키를 사용하려면 어떻게 해야 합니까?AWS KMS반환?

AWS 암호화 SDK를 사용하여 데이터를 보호하는 데 사용할 래핑 키를 결정하는 마스터 키 공급자(Java 및 Python) 또는 키 링(C, C#/.NET 및 JavaScript)을 정의합니다. 그런 다음 AWS 암호화 SDK에서 제공하는 간단한 방법을 사용하여 데이터를 암호화하고 해독합니다. AWS 암호화 SDK가 나머지 작업을 수행합니다.

AWS 암호화 SDK가 없으면 애플리케이션의 핵심 기능보다 암호화 솔루션을 구축하는 데 더 많은 노력을 기울일 수 있습니다. AWS 암호화 SDK는 다음을 제공하여 이러한 질문에 답합니다.

다음은 Encryption SDK와 KMS를 사용하여 TEXT를 암호화하고 복호화하는 예제입니다.

## 예제

예제는 로컬에서 동작합니다. 로컬에 KMS에 접근가능한 AWS Credentials이 필요합니다.

### pre install

Java 17필요합니다.
로컬에서 모든 동작을 실행합니다. 충분한 컴퓨팅리소스가 있는 인스턴스를 선택합니다.
cloud9 사용시 아래 명령을 실행합니다.

```bash=
yum install java -y
```

### Server start

터미널에서 아래 명령을 실행합니다.

```bash=
./script/server_start.sh
```

### Frontend Start

새 터미널에서 아래 명령을 실행합니다.

```bash=
./script/front_start.sh
```

### 서버 접속

localhost:8080 접속합니다.
Cloud9을 사용하는 경우 상단의 Preview버튼을 클릭합니다.
![main](/image/mainpage.png)

### Encryption

상단의 파란색 Encryption을 클릭합니다.
KMS Key arn에 KMS에서 생성한 Key의 ARN을 입력합니다. message에 암호화할 텍스트를 입력한 후 아래 Encryption을 클릭하면
Encrypted Messages에 암호화된 메세지가 표시됩니다.

### Decryption

상단의 파란색 Decryption을 클릭합니다.
KMS Key arn에 KMS에서 생성한 Key의 ARN을 입력합니다. Encryption을 선택하고 Encrypted Message에 암호화한 텍스트를 입력한 후 아래 Decryption 클릭하면
Decrypted Messages에 메세지가 표시됩니다.

#### Contributor

- [jchong18](https://github.com/jchong18)
- [sykang](https://github.com/sykang808)
