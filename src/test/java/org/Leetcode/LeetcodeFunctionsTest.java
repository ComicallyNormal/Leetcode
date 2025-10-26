package org.Leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class LeetcodeFunctionsTest {

    @Test
    public void testThatAhhReturnsHha(){
        LeetcodeFunctions leet = new LeetcodeFunctions();
        String returnString = leet.reverseStringTest("AHH");
        assertEquals("HHA",returnString);
    }

    @Test
    public void testOneEqualsOne(){
        assertEquals("ONE","ONE");
    }


//GET TOP SCORE TESTS
    /***************************************************************************************/

    //EASY TEST DOESNT HIT EDGECASE
    @Test
    public void testAliceBob100And200And1000cutoffReturnsBob(){
    Hashtable<String,Integer> inputDict = new Hashtable<>();
    inputDict.put("Alice",Integer.valueOf(100));
    inputDict.put("Bob",Integer.valueOf(200));
    int cutoff = 1000;

    LeetcodeFunctions leet = new LeetcodeFunctions();
    String topName = leet.getTopScoreName(inputDict,cutoff);


    assertEquals("Bob",topName);
}


    //TEST HITS EDGECASE
    @Test
    public void testAliceBopCharlie100And200And300And250Cutoff(){
        Hashtable<String,Integer> inputDict = new Hashtable<>();
        inputDict.put("Alice",Integer.valueOf(100));
        inputDict.put("Bob",Integer.valueOf(200));
        inputDict.put("Charlie",Integer.valueOf(300));
        int cutoff = 250;
        LeetcodeFunctions leet = new LeetcodeFunctions();
        String topName = leet.getTopScoreName(inputDict,cutoff);
        assertEquals("Bob",topName);
    }


    //TEST HITS EDGECASE AND CONTINUES AFTER EDGECASE
    @Test
    public void testAliceBopCharlie100And200And300And400And250Cutoff(){
        Hashtable<String,Integer> inputDict = new Hashtable<>();
        inputDict.put("Alice",Integer.valueOf(100));
        inputDict.put("Bob",Integer.valueOf(200));
        inputDict.put("Charlie",Integer.valueOf(300));
        inputDict.put("Addie",Integer.valueOf(220));

        int cutoff = 290;
        LeetcodeFunctions leet = new LeetcodeFunctions();
        String topName = leet.getTopScoreName(inputDict,cutoff);
        assertEquals("Addie",topName);
    }




    //GET DISCOUNTED GROCERIES TESTS
    /***************************************************************************************/


    //TEST HITS EDGECASE AND CONTINUES AFTER EDGECASE
    @Test
    public void testGroceries20And50And10DiscountGives65Total(){
        Integer[] prices = {20,50};
        int discount = 10;
        LeetcodeFunctions leet = new LeetcodeFunctions();
        int sum = leet.discountedSumOfGroceries(prices,discount);
        assertEquals(65,sum);
    }


    //TEST HITS EDGECASE AND CONTINUES AFTER EDGECASE
    @Test
    public void testGroceries20And30And60And25DiscountGives95Total(){
        Integer[] prices = {20,30,60};
        int discount = 25;
        LeetcodeFunctions leet = new LeetcodeFunctions();
        int sum = leet.discountedSumOfGroceries(prices,discount);
        assertEquals(95,sum);
    }
}