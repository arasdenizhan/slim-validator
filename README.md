
# slim-validator

![Build](https://github.com/arasdenizhan/slim-validator/actions/workflows/maven.yml/badge.svg)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://github.com/arasdenizhan/slim-validator/blob/master/LICENSE)
[![Release](https://img.shields.io/github/v/release/arasdenizhan/slim-validator)](https://github.com/arasdenizhan/slim-validator/releases/tag/1.0.0)
[![Maven Central](https://img.shields.io/badge/Maven_Central-1.0.0-green)](https://central.sonatype.com/artifact/io.github.arasdenizhan/slim-validator)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)

**A lightweight, annotation-driven Java validation library with zero dependencies.**  
Easily validate your POJOs using simple annotations like `@NotNull`, `@Min`, `@Max`, `@Pattern`, `@Email`, and `@Length`.

More features will be integrated soon.

---

## 🚀 Features

- **Annotation-based validation** — simple and clear  
- Supported annotations:  
  - `@NotNull` — null check  
  - `@Min` / `@Max` — numeric boundaries  
  - `@Pattern` — regex pattern validation  
  - `@Email` — email format validation  
  - `@Length` — string length constraints  
- **Performance optimized** — reflection access is cached  
- **Easy integration** — just annotate your POJOs and call the validator  
- **Open source** — community-driven and extendable

---

## 💡 Usage

### 1. Define your POJO

```java
public class UserDto {
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email format is invalid")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 99, message = "Age must be less than 100")
    private Integer age;

    @Length(min = 2, max = 3, message = "Country code length must be between 2 and 3")
    private String countryCode;

    // getters and setters
}
```

### 2. Validate your object

```java
SlimValidator validator = new SlimValidator();

UserDto userDto = new UserDto();
userDto.setAge(12);
userDto.setCountryCode("US");
userDto.setEmail("email@example.com");

validator.validate(userDto); // throws ValidationException on failure
```

---

## 📦 Central Repository

- Maven
```xml
<dependency>
  <groupId>io.github.arasdenizhan</groupId>
  <artifactId>slim-validator</artifactId>
  <version>1.0.0</version>
</dependency>
```

- Gradle
```
implementation group: 'io.github.arasdenizhan', name: 'slim-validator', version: '1.0.0'
```

---

## 🛠️ Development

- Easily add new annotations and validation strategies  
- Extensible architecture based on `StrategyFactory`  
- Reflection caching for optimal performance

---

## 📚 Documentation

The full API documentation is available at:

👉 [Javadoc for Slim Validator](https://arasdenizhan.github.io/slim-validator/)

---

## 📄 License

Apache License 2.0 (Open source and free to use)

---

## 🤝 Contribution

Pull requests and issues are welcome!

---

## Contact

Denizhan Aras — [github.com/arasdenizhan](https://github.com/arasdenizhan)
