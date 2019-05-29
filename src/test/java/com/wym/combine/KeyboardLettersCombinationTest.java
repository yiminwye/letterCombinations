package com.wym.combine;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class KeyboardLettersCombinationTest {

    @Test
    public void test01() {
        int[] intArray = {};
        List<String> list = getCombine(intArray);
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void test02() {
        int[] intArray = {0, 1};
        List<String> list = getCombine(intArray);
        System.out.println(list);
    }

    @Test
    public void test03() {
        int[] intArray = {2, 3};
        List<String> list = getCombine(intArray);
        Assert.assertEquals(9, list.size());
    }

    @Test
    public void test04() {
        int[] intArray = {4, 5};
        List<String> list = getCombine(intArray);
        String[] expected = {"gj", "gk", "gl", "hj", "hk", "hl", "ij", "ik", "il"};
        Assert.assertTrue(Arrays.asList(expected).containsAll(list));
    }

    @Test
    public void test05() {
        int[] intArray = {6};
        List<String> list = getCombine(intArray);
        String[] expected = {"m", "n", "o"};
        Assert.assertTrue(Arrays.asList(expected).containsAll(list));
    }

    @Test
    public void test06() {
        int[] intArray = {7, 8, 9};
        List<String> list = getCombine(intArray);
        Assert.assertEquals(48, list.size());
    }


    private List<String> getCombine(int[] intArray){
        KeyboardLettersCombination kc = new KeyboardLettersCombination();
        return kc.letterCombinations(intArray);
    }
}
