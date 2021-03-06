package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static List<Map<String, Integer>> allData = new ArrayList<Map<String, Integer>>();
    public static String skill = "swords";
    public static int noe;

    public static void main(String[] args) throws IOException {
        // 4 - nickname, 6 - level
        noe = new File(skill).listFiles().length;
        for (int i = 0; i < noe; i++) {
            BufferedReader br = new BufferedReader(new FileReader(skill + "/" + i + ".txt"));
            Map<String, Integer> input = new HashMap<String, Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.trim().replaceAll(" +", " ").split(" ");
                input.put(split[4].toLowerCase(), Integer.parseInt(split[6]));
            }
            allData.add(input);
            br.close();
        }
        Scanner in = new Scanner(System.in);
        String input;
        while (!(input = in.nextLine().toLowerCase()).equals("exit")) {
            System.out.print(input + ": ");
            for (int i = 0; i < noe; i++) {
                System.out.print(allData.get(i).get(input) + ", ");
            }
            System.out.println();
        }
        in.close();
    }

}
