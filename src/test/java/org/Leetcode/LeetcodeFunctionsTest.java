package org.Leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

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


    //Get Ordered object
    /**************************************************************************************/

    @Test
    public void testInternalObjectOrderingWorks(){
        String testString =  "Name=Lacie;Worth=20;Height=6;";
        ArrayList<String> testObjects = new ArrayList<>();
        testObjects.add(testString);
        LeetcodeFunctions leet = new LeetcodeFunctions();
        List<String>  orderedStrings = leet.hierarchicallyOrderedString(testObjects);
        assertEquals("Height=6;Name=Lacie;Worth=20;",orderedStrings.getFirst());

    }

    @Test
    public void testInternalObjectOrderingWorksMultipleObjects(){
        String testString =    "Name=Lacie;Worth=20;Height=6;";
        String testString2 =  "Name=Jeremy;Cat=Terry;Worth=25;Height=55;";
        String testString3 =  "Name=Jacob;Dog=Spot;Worth=35;";


        ArrayList<String> testObjects = new ArrayList<>();
        testObjects.add(testString);
        testObjects.add(testString2);
        testObjects.add(testString3);
        LeetcodeFunctions leet = new LeetcodeFunctions();
        String[] hackyStr = new String[testObjects.size()];
        int hackyCounter = 0;

        List<String>  orderedStrings = leet.hierarchicallyOrderedString(testObjects);
        for(String x : orderedStrings){
            hackyStr[hackyCounter] =x;
            hackyCounter++;
        }

        assertEquals("Dog=Spot;Name=Jacob;Worth=35;",hackyStr[0]);
        assertEquals("Cat=Terry;Height=55;Name=Jeremy;Worth=25;",hackyStr[1]);
        assertEquals("Height=6;Name=Lacie;Worth=20;",hackyStr[2]);

    }


    @Test
    public void testOrderingByNameWorks(){
        String testString =    "Name=Lacie;Worth=20;Height=6;";
        String testString2 =  "Name=Jeremy;Cat=Terry;Worth=25;Height=55;";
        String testString3 =  "Name=Jacob;Dog=Spot;Worth=35;";


        ArrayList<String> testObjects = new ArrayList<>();
        testObjects.add(testString);
        testObjects.add(testString2);
        testObjects.add(testString3);
        LeetcodeFunctions leet = new LeetcodeFunctions();
        String[] hackyStr = new String[testObjects.size()];
        int hackyCounter = 0;

        List<String>  orderedStrings = leet.hierarchicallyOrderedString(testObjects);
        for(String x : orderedStrings){
            hackyStr[hackyCounter] =x;
            hackyCounter++;
        }
        assertEquals("Dog=Spot;Name=Jacob;Worth=35;",hackyStr[0]);
        assertEquals("Cat=Terry;Height=55;Name=Jeremy;Worth=25;",hackyStr[1]);
        assertEquals("Height=6;Name=Lacie;Worth=20;",hackyStr[2]);
    }

    @Test
    public void testOrderingByValueThenNameWorks(){
        String testString =    "Name=Lacie;Worth=100;Height=6;";
        String testString2 =  "Name=Jeremy;Cat=Terry;Worth=25;Height=55;";
        String testString3 =  "Name=Jacob;Dog=Spot;Worth=25;";


        ArrayList<String> testObjects = new ArrayList<>();
        testObjects.add(testString);
        testObjects.add(testString2);
        testObjects.add(testString3);
        LeetcodeFunctions leet = new LeetcodeFunctions();
        String[] hackyStr = new String[testObjects.size()];
        int hackyCounter = 0;

        List<String>  orderedStrings = leet.hierarchicallyOrderedString(testObjects);
        for(String x : orderedStrings){
            hackyStr[hackyCounter] =x;
            hackyCounter++;
        }
        assertEquals("Height=6;Name=Lacie;Worth=100;",hackyStr[0]);
        assertEquals("Dog=Spot;Name=Jacob;Worth=25;",hackyStr[1]);
        assertEquals("Cat=Terry;Height=55;Name=Jeremy;Worth=25;",hackyStr[2]);
    }
}