# kotlin-api

[spring initilalizr](https://start.spring.io/)

![ 2020-08-22 at 0 23 01](https://user-images.githubusercontent.com/49140016/90907876-8f1dee80-e40e-11ea-990b-e8bfd9e3352d.png)

`build.gradle.kts` の `dependencies` に以下を追加した．

```gradle
implementation("org.springframework.boot:spring-boot-starter-web")
```

## 起動

```bash
./gradlew bootRun
```

## 画像のアップロード

[Postman](https://www.postman.com/)を使って，multipart/form-data形式で画像をアップロードすると，その画像を表示するURLを返す．

![ 2020-08-22 at 4 27 13](https://user-images.githubusercontent.com/49140016/90927305-cd77d580-e42f-11ea-986b-ee26c5a2d95f.png)
