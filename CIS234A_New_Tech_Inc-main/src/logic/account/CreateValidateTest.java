package logic.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateValidateTest {
    CreateValidate cv = new CreateValidate();

    @Test
    void validateUser() {
        assertFalse(cv.validateUser(""));
        assertTrue(cv.validateUser("ValidUsername"));
    }

    @Test
    void validName() {
        assertFalse(cv.validName(""));
        assertTrue(cv.validName("Valid name"));
    }

    @Test
    void validateEmail() {
        assertFalse(cv.validateEmail("badEmail.com"));
        assertTrue(cv.validateEmail("OkEmail@yahoo.com"));
    }

    @Test
    void validPass() {
        assertFalse(cv.validPass(""));
        assertTrue(cv.validPass("Password"));
    }

    @Test
    void samePass() {
        assertFalse(cv.samePass("password", "not same"));
        assertTrue(cv.samePass("pass", "pass"));
    }
}