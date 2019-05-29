package com.wym.combine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YiminWye at 2019/5/28 23:23.
 */
public class KeyboardLettersCombination {
    // 数字与字母对应map
    private static Map<Integer, String> keyboradLetters = null;
    static{
        keyboradLetters = new HashMap<Integer, String>();
        keyboradLetters.put(0, " ");
        keyboradLetters.put(1, " ");
        keyboradLetters.put(2, "abc");
        keyboradLetters.put(3, "def");
        keyboradLetters.put(4, "ghi");
        keyboradLetters.put(5, "jkl");
        keyboradLetters.put(6, "mno");
        keyboradLetters.put(7, "pqrs");
        keyboradLetters.put(8, "tuv");
        keyboradLetters.put(9, "wxyz");
    }

    public List<String> letterCombinations(int[] intArray) {

        List<String> combinations = new ArrayList<String>();
        if (intArray == null || intArray.length == 0){
            return combinations;
        }

        String inputNumbers = "";
        for (int i = 0; i < intArray.length; i++){
            inputNumbers = inputNumbers.concat(String.valueOf(intArray[i]));
        }

        ArrayList<Character> temp = new ArrayList<Character>();
        concatLetters(inputNumbers, temp, combinations);
        return combinations;
    }

    /**
     * 递归方式，逐个拼接字母
     */
    private static void concatLetters(String numbers, ArrayList<Character> temp, List<String> results) {
        if (numbers.length() == 0) {
            char[] arr = new char[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                arr[i] = temp.get(i);
            }
            results.add(String.valueOf(arr));
            return;
        }

        Integer currNumber = Integer.valueOf(numbers.substring(0, 1));
        String letters = keyboradLetters.get(currNumber);
        for (int i = 0; i < letters.length(); i++) {
            temp.add(letters.charAt(i));
            concatLetters(numbers.substring(1), temp, results);
            // 移除已經添加的
            temp.remove(temp.size() - 1);
        }
    }

}
