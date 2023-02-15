package core.dataFaker;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataFaker {

    Faker faker = new Faker(new Locale("lv", "lv"));
    private String fakeFirstName = faker.name().firstName();
    private String fakeStringTooLong = faker.bothify("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    private String fakeStringTooShort = faker.bothify("xx");
    private String fakeLastName = faker.name().lastName();
    private String fakeEmail = faker.internet().emailAddress(fakeFirstName);
    private String fakeTelephone = faker.bothify("2#######");
    private String fakePassword = faker.internet().password();
    private String fakePasswordConfirm = fakePassword;
}