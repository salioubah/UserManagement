package com.salioubah.usermanagement.demo.utils;

import com.salioubah.usermanagement.demo.constants.Constants;

import java.time.LocalDate;

/**
 * Class that implements different methods
 */
public class CommonUtils {

    /**
     * Check if some date of birth correspond to a majority or not
     * @param localDate, date of birth to checked
     * @return a boolean, true if is major or false to other case
     */
    public static boolean isMajor(LocalDate localDate) {
        return LocalDate.now().getYear() - localDate.getYear() > Constants.AGE_ALLOWED ||
                (LocalDate.now().getYear() - localDate.getYear() == Constants.AGE_ALLOWED
                        && LocalDate.now().getDayOfYear() > localDate.getDayOfYear());
    }
}
