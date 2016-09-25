package com.company;

import java.util.Objects;

public class Toy implements Comparable<Toy> {

    private String name;
    private int price;
    private int age1;
    private int age2;

    public Toy(String name, int price, int age1, int age2) {
        this.name = name;
        this.price = price;
        this.age1 = age1;
        this.age2 = age2;
    }


    @Override
    public String toString() {
        return "Toy "+name+ " cost "+price+" cents. It is for kids from "+age1+" to "+age2+" years.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy)) return false;
        Toy toy = (Toy) o;
        return price == toy.price && age1 == toy.age1 && age2 == toy.age2 && Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, age1, age2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    @Override
    public int compareTo(Toy o) {
        if (price<o.price) {
            return -1;
        }
        if (price>o.price) {
            return 1;
        }
        return 0;
    }

    public static Toy parseToy(String line) {
        String[] split = line.split(";");
        String name = split[0];
        int price = Integer.parseInt(split[1]);
        int age1 = Integer.parseInt(split[2]);
        int age2 = Integer.parseInt(split[3].trim());
        return new Toy(name,price,age1,age2);
    }
}