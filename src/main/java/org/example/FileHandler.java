package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {
    static HashMap<Character, String> dictRus = new HashMap<>();
    static HashMap<Character, String> dictEng = new HashMap<>();
    static List<String> result = new ArrayList<>();

    public static String translateToEng(String string) {
        if (dictRus.isEmpty()) {
            HashMap<Character, String> dict = new HashMap<>();
            dict.put('а', "a");
            dict.put('б', "b");
            dict.put('в', "v");
            dict.put('г', "g");
            dict.put('д', "d");
            dict.put('е', "e");
            dict.put('ё', "e");
            dict.put('ж', "zh");
            dict.put('з', "z");
            dict.put('и', "i");
            dict.put('й', "y");
            dict.put('к', "k");
            dict.put('л', "l");
            dict.put('м', "m");
            dict.put('н', "n");
            dict.put('о', "o");
            dict.put('п', "p");
            dict.put('р', "r");
            dict.put('с', "s");
            dict.put('т', "t");
            dict.put('у', "u");
            dict.put('ф', "f");
            dict.put('х', "h");
            dict.put('ц', "c");
            dict.put('ч', "ch");
            dict.put('ш', "sh");
            dict.put('щ', "sch'");
            dict.put('ы', "y");
            dict.put('ь', "'");
            dict.put('э', "e'");
            dict.put('ю', "yu");
            dict.put('я', "ya");
                for (HashMap.Entry<Character, String> vac :
                    dict.entrySet()) {
                dictRus.put(vac.getKey(),vac.getValue());
                dictRus.put(Character.toUpperCase(vac.getKey()), vac.getValue().toUpperCase());
            }

        }
        char[] chars = string.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            result.append(dictRus.getOrDefault(aChar, aChar + ""));
        }
        return result.toString();
    }

    public static String translateToRus(String string) {
        if (dictEng.isEmpty()) {
            HashMap<Character, String> dict = new HashMap<>();
            dict.put('a', "а");
            dict.put('b', "б");
            dict.put('c', "ц");
            dict.put('d', "д");
            dict.put('e', "е");
            dict.put('f', "ф");
            dict.put('g', "ж");
            dict.put('h', "ш");
            dict.put('i', "ш");
            dict.put('j', "дж");
            dict.put('k', "к");
            dict.put('l', "л");
            dict.put('m', "м");
            dict.put('n', "н");
            dict.put('o', "о");
            dict.put('p', "п");
            dict.put('q', "ку");
            dict.put('r', "р");
            dict.put('s', "с");
            dict.put('t', "т");
            dict.put('u', "у");
            dict.put('v', "в");
            dict.put('w', "в");
            dict.put('x', "икс");
            dict.put('y', "й");
            dict.put('z', "з");
            for (Map.Entry<Character, String> vac :
                    dict.entrySet()) {
                char temp = Character.toUpperCase(vac.getKey());
                dictEng.put(vac.getKey(), vac.getValue());
                dictEng.put(temp, vac.getValue().toUpperCase());
            }
        }
        char[] chars = string.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            result.append(dictEng.getOrDefault(aChar, aChar + ""));
        }
        return result.toString();
    }

    public static String upperCase(String string) {
        char[] chars = string.toCharArray();
        string = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                chars[i + 1] = Character.toString(chars[i + 1]).toUpperCase().charAt(0);
            }
            if (i == 0) {
                chars[i] = Character.toString(chars[i]).toUpperCase().charAt(0);
            }
            string += chars[i];
        }
        return string;
    }

    public static String lowerCase(String string) {
        return string.toLowerCase();
    }

    public static void writeToFile(String string) {
        try {
            result.add(string);
            Files.write(Paths.get(App.file), result, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
