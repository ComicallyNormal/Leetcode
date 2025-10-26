package org.Leetcode;

import java.math.BigDecimal;
import java.util.*;

public class LeetcodeFunctions {

    public LeetcodeFunctions(){}


    //Proof of concept string reversal.
    public String reverseStringTest(String xx){
        String reverse = "";
        for(int i = xx.length() -1; i>=0; i--){
            char curStr =xx.charAt(i);
            reverse = reverse + curStr;
        }
        return reverse;
    }


    /**
     * Test requiremensts: Given a dictionary of keys as names and values as scores, we want the highest scored person's name returned.
     * However, this is a recruitment problem, people above a certain score are drafted by someone else, so really we just need the highest
     * score above a threshold.
     * @return Name as string
     */
    public String getTopScoreName(Hashtable<String,Integer> scoresDictionary,int cutoff){
        String topName = "";
        int currentTopValue = 0;
        Set<String> names = scoresDictionary.keySet();
        for(String name : names){
            int scoreVal = scoresDictionary.get(name);
            if(scoreVal>currentTopValue && cutoff>scoreVal){
                currentTopValue = scoreVal;
                topName = name;
            }
        }

        return topName;
    }


    /**
     * Given a strangely formatted list of objects, where each object is kind of like a json object but with a = sign as the key value delimeter and an ; as the attribute delimeter,
     * we need to reorder the internal object elements alphabetically, and we also need to hierarchically order the list first by name then by value.
     * (20 minutes to solve)
     */
    public List<String> hierarchicallyOrderedString(List<String> listOfPersons){
        return new ArrayList<>();
    }

    /**
     * Given a list of grocery prices, and a discount as a integer representing a percent, we need
     * to discount the top value, and then return a sum of the groceries including the discount
     * (15 minutes to solve)
     */
    public Integer discountedSumOfGroceries(Integer[] prices, Integer discount){

        int maxVal = 0;
        int sumOfGroceries = 0;
        for(int p : prices){
            sumOfGroceries = sumOfGroceries + p;
            if (p>maxVal){
                maxVal = p;
            }
        }
        int sumOfPricesWithoutMax = sumOfGroceries - maxVal;
        BigDecimal discountedItemPrice = BigDecimal.valueOf(maxVal).multiply(BigDecimal.valueOf(100 - discount)).divide(BigDecimal.valueOf(100));
        int discountedItemPriceInt = discountedItemPrice.intValue();


        return discountedItemPriceInt + sumOfPricesWithoutMax;
    }




}
