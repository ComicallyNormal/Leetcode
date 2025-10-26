package org.Leetcode;

import java.math.BigDecimal;
import java.sql.Array;
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
     * we need to reorder the internal object elements alphabetically, and we also need to hierarchically order the list first by value then by name
     * (20 minutes to solve)
     */
    public List<String> hierarchicallyOrderedString(List<String> listOfPersons){
        List<String> orderedList = new ArrayList<>();

        ArrayList<String> namesOfAllPersons = new ArrayList<>();
        Hashtable<String,Hashtable<String,String>> decomposedObjects = new Hashtable<>();
        Hashtable<String,String> personNamesAndStrings = new Hashtable<>();
        ArrayList<String> objectsSortedByName = new ArrayList<>();
        Hashtable<Integer,ArrayList<String>> namesWithValues = new Hashtable();
        for(String personObject : listOfPersons){

            Hashtable<String,String> decomposedObj = new Hashtable<>();
            ArrayList<String> attributes = new ArrayList();
            String[] splitOnColonList = personObject.split(";");
            for(String kvpStr : splitOnColonList){
                String[] splitOnEqualsList = kvpStr.split("=");
                attributes.add(splitOnEqualsList[0]);
                decomposedObj.put(splitOnEqualsList[0],splitOnEqualsList[1]);
            }
            Integer curVal = Integer.valueOf(decomposedObj.get("Worth"));
            String curName = decomposedObj.get("Name");
            namesOfAllPersons.add(curName);
            decomposedObjects.put(curName,decomposedObj); //associate name with object
            if(namesWithValues.getOrDefault(Integer.valueOf(decomposedObj.get("Worth")),null)==null){
                ArrayList<String> arr = new ArrayList();
                arr.add(curName);
                namesWithValues.put(curVal,arr);
            }
            else{
                namesWithValues.get(curVal).add(curName);
            }

            String[] castArray = new String[attributes.size()];
            for(int i = 0; i<attributes.size();i++){
                castArray[i] = attributes.get(i);
            }
            Arrays.sort(castArray);

            String sortedObjectString = "";
            StringBuilder attrObjBuilder = new StringBuilder();
            for(String attr : castArray ){
                String substr = attr + "=" + decomposedObj.get(attr);
                attrObjBuilder.append(substr).append(";");
            }
            sortedObjectString = attrObjBuilder.toString();
            orderedList.add(sortedObjectString);
            personNamesAndStrings.put(decomposedObj.get("Name"),sortedObjectString);
        }

        Integer[] sortedValues = new Integer[namesWithValues.keySet().size()];
        int tmpCounter = 0;
        for(Integer i : namesWithValues.keySet()){
            sortedValues[tmpCounter] = i;
            tmpCounter++;
        }

        Arrays.sort(sortedValues); //values are now sorted

        ArrayList<String> finalOrdering = new ArrayList();
        System.out.println();
        System.out.println(String.valueOf(sortedValues.length) +" sorted values size");

        for(int j = sortedValues.length-1;j>=0; j--){
            ArrayList<String> allNamesOfValueJ = namesWithValues.get(sortedValues[j]); //names at j
            System.out.println("all names at j length "+ String.valueOf(allNamesOfValueJ.size()));
            String[] orderedNames = new String[allNamesOfValueJ.size()];
            orderedNames = allNamesOfValueJ.toArray(orderedNames);
            System.out.println("names of all persons size " +String.valueOf(orderedNames.length) );
            Arrays.sort(orderedNames); //names at i are now ordered by name
            for(String lexString : orderedNames){
                finalOrdering.add(lexString);
            }
        }

        System.out.println(String.valueOf(finalOrdering.size()) +" final ordering size");

        for(String personName : finalOrdering){
            objectsSortedByName.add(personNamesAndStrings.get(personName));
        }

        return objectsSortedByName;
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
