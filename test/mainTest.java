/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sukhb
 */
public class mainTest {

    public mainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkInput method, of class main.
     */
    @Test
    public void testCheckInputGood() {
        System.out.println("Good Result");
        int num_of_players = 2;
        boolean expResult = true;
        boolean result = main.checkInput(num_of_players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCheckInputBad() {
        System.out.println("Bad Result");
        int num_of_players = 1;
        boolean expResult = false;
        boolean result = main.checkInput(num_of_players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCheckInputBoundary() {
        System.out.println("Boundary Result");
        int num_of_players = 2;
        boolean expResult = true;
        boolean result = main.checkInput(num_of_players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
