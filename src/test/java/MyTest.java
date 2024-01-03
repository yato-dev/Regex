
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.Validator;


public class MyTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = new Validator();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Shikhar", "Barthwal", "Rajat", "Yadav", "Vivek", "Pandey" })
    public void validateCorrectNameHappy(String str) {
        assertTrue(validator.validateName(str));
    }

    @ParameterizedTest
    @ValueSource(strings = { "sHiKhar", "BarThwal", "ADT123ya", "yaDav", "K232usJJhal", "Pan#$dey" })
    public void validateInCorrectNameSad(String str) {
        assertFalse(validator.validateName(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.co",
            "abc111@abc.com",
            "abc-100@abc.net",
            "abc.100@abc.com.a",
            "abc@1.com",
            "abc@gmail.com.co",
            "abc+100@gmail.co",
    })
    public void validateCorrectEmailHappy(String email) {
        assertTrue(validator.validateEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a ",
            "abc123@.com ",
            "abc123@.com.com",
            ".abc@abc.com ",
            "abc()*@gmail.com ",
            "abc@%*.com ",
            "abc..2002@gmail.com ",
            "abc.@gmail.com ",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au",
    })
    public void validateInCorrectEmailSAD(String email) {
        assertFalse(validator.validateEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = { "91 9977649723", "989 9988665533", "1 7788554411" })
    public void validateCorrectPhoneHappy(String phone) {
        assertTrue(validator.validatePhone(phone));
    }

    @ParameterizedTest
    @ValueSource(strings = { "91 99776497", "9899988665533", "1 778855441a" })
    public void validateInCorrectPhonesad(String phone) {
        assertFalse(validator.validatePhone(phone));
    }

    @ParameterizedTest
    @ValueSource(strings = { "@Reur985", "!@#$98754addFas", "!1Aa123awsed" })
    public void validateCorrectPasswordhappy(String password) {
        assertTrue(validator.validatePassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = { "asd", "shikhar", "!1a123awsed", "shikharA2223" })
    public void validateInCorrectPasswordsad(String password) {
        assertFalse(validator.validatePassword(password));
    }

}