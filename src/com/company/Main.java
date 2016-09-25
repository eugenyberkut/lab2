package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    private void run(){
//        List<Toy> toys = fillToys();
        List<Toy> toys = readFromFile("toys.txt");
        //Files.lines(Paths.get("D:\\Java\text.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
        int SetPrice = 80;

//        sort(toys);
//        for (Toy t : toys) {
//            System.out.println(t);
//        }
        toys = toys.stream().collect(toList());
        toys.forEach(System.out::println);
        System.out.println("-------------------");
//        for (int i = 0; i < toys.size(); i++) {
//            if ((toys.get(i).getPrice()<SetPrice)&((toys.get(i).getAge1()<=5)&(toys.get(i).getAge2()>=5)))
//                System.out.println(toys.get(i));
//        }
        Toy t = new Toy("Ball", 99, 3, 12);
        System.out.println(toys.contains(t));
        System.out.println(toys.indexOf(t));
        System.out.println("--------------------");
        toys.stream().sorted(Comparator.comparing(Toy::getName).thenComparing(Toy::getPrice).reversed()).forEach(System.out::println);
    }

    private List<Toy> readFromFile(String fileName) {
        try {
            return Files.lines(Paths.get("toys.txt")).map(Toy::parseToy).collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    private List<Toy> readFromFileOld(String fileName) {
        List<Toy> toys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine())!=null){
                Toy t = Toy.parseToy(line);
                toys.add(t);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return toys;
        }
    }

    private void sort(List<Toy> toys) {
        boolean flag=true;
        while (flag) {
            flag = false;
            for (int i = 0; i < toys.size() - 1; i++) {
                if (toys.get(i).getPrice() > toys.get(i + 1).getPrice()) {
                    Toy temp = toys.get(i);
                    toys.set(i, toys.get(i + 1));
                    toys.set(i + 1, temp);
                    flag=true;
                }
            }
        }
    }

    private List<Toy> fillToys() {
        Toy[] ts = {
                new Toy("Ball", 199, 3, 12),
                new Toy("Doll", 75, 6, 10),
                new Toy("Lego", 150, 10, 16),
                new Toy("Cubic", 50, 3, 8),
                new Toy("Ball", 99, 3, 12)
        };

        return new ArrayList<>(Arrays.asList(ts));
    }
}

