package com.salioubah.usermanagement.demo.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CommonUtilsTest {

    @Test
    @DisplayName("Check a valid majority")
    public void isValidMajor(){
        assertEquals(true, CommonUtils.isMajor(LocalDate.of(2000, 12, 13)), "Should be a major");
    }

    @Test
    @DisplayName("Check a non valid majority")
    public void isNonValidMajor(){
        assertEquals(false, CommonUtils.isMajor(LocalDate.of(2010, 12, 13)), "Should be a non valid major");
    }

}