package br.com.santarosadigital.todolist.enumeration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileEnumTest {

    @Test
    void getValue() {
        assertEquals("MANAGER", ProfileEnum.MANAGER.getValue());
        assertEquals("ADMINISTRATOR", ProfileEnum.ADMINISTRATOR.getValue());
        assertEquals("OPERATOR", ProfileEnum.OPERATOR.getValue());
    }

    @Test
    void getEnum() {
        assertEquals(ProfileEnum.MANAGER, ProfileEnum.getEnum("MANAGER"));
        assertEquals(ProfileEnum.ADMINISTRATOR, ProfileEnum.getEnum("ADMINISTRATOR"));
        assertEquals(ProfileEnum.OPERATOR, ProfileEnum.getEnum("OPERATOR"));
    }
}