package com.guxo.crmbackend.appuser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AppUserRoleTest {
    /**
     * Method under test: {@link AppUserRole#valueOf(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValueOf() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.guxo.crmbackend.appuser.AppUserRole.Name
        //       at java.lang.Enum.valueOf(Enum.java:273)
        //       at com.guxo.crmbackend.appuser.AppUserRole.valueOf(AppUserRole.java:3)
        //   In order to prevent valueOf(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   valueOf(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AppUserRole.valueOf("Name");
    }

    /**
     * Method under test: {@link AppUserRole#valueOf(String)}
     */
    @Test
    void testValueOf2() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        AppUserRole.valueOf("ADMIN");
    }

    /**
     * Method under test: {@link AppUserRole#valueOf(String)}
     */
    @Test
    void testValueOf3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        AppUserRole.valueOf("USER");
    }

    /**
     * Method under test: {@link AppUserRole#values()}
     */
    @Test
    void testValues() {
        AppUserRole[] actualValuesResult = AppUserRole.values();
        assertEquals(2, actualValuesResult.length);
        assertEquals(AppUserRole.USER, actualValuesResult[0]);
        assertEquals(AppUserRole.ADMIN, actualValuesResult[1]);
    }
}

